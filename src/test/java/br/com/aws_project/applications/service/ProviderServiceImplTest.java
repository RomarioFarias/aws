package br.com.aws_project.applications.service;

import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.port.ProviderRepository;
import br.com.aws_project.applications.port.ProviderSnsEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.aws_project.templates.ProviderTemplatTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

class ProviderServiceImplTest {

    @InjectMocks
    ProviderServiceImpl providerService;

    @Mock
    ProviderRepository providerRepository;

    @Mock
    ProviderSnsEvent providerSnsEvent;

    @BeforeEach
     void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProvider() {
        when(providerRepository.createProvider(any())).thenReturn(getProviderTemplat());
        var provider = this.providerService.createProvider(getProviderTemplat());
        assertTrue("Provider get by id is not null",provider.getId() != null);
        verify(providerRepository, times(1)).createProvider(any());
    }

    @Test
    @DisplayName("Return Provider by ID")
    void getProvider() {
        when(providerRepository.getProvider(any())).thenReturn(getOptionalProviderTemplat());
        var provider = this.providerService.getProvider(ID);
        assertNotNull("Test OK",provider);
        verify(providerRepository, times(1)).getProvider(anyString());
    }

    @Test
    @DisplayName("Return ResourceNotFoundException in Provider by ID")
    void sholdReturngetResourceNotFoundException() {
        Throwable ex = assertThrows(Throwable.class, () -> providerService.getProvider(ID));
        assertEquals(ex.getClass() ,ResourceNotFoundException.class);
        verify(providerRepository, times(1)).getProvider(anyString());
    }

    @Test
    @DisplayName("Return delete Provider by ID")
    void deleteProvider() {
        when(providerRepository.getProvider(anyString())).thenReturn(getOptionalProviderTemplat());
        this.providerService.deleteProviderById(ID);
        verify(providerRepository, times(1)).getProvider(anyString());
        verify(providerSnsEvent, times(1)).deleteProvider(any());
    }

    @Test
    @DisplayName("Return list all Provider")
    void listProvider() {
        when(providerRepository.listProvider()).thenReturn(listAllProvider());
        this.providerService.listProvider();
        verify(providerRepository, times(1)).listProvider();
    }
}