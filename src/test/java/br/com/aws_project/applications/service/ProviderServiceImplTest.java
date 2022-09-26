package br.com.aws_project.applications.service;

import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.port.ClientRepository;
import br.com.aws_project.applications.port.ClientSnsEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.aws_project.templates.ClientTemplatTest.*;
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
    ProviderServiceImpl clienteServiceImpl;

    @Mock
    ClientRepository clientRepository;

    @Mock
    ClientSnsEvent clientSnsEvent;

    @BeforeEach
     void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createClient() {
        when(clientRepository.createProvider(any())).thenReturn(getClientTemplat());
        var client = this.clienteServiceImpl.createProvider(getClientTemplat());
        assertTrue("client get by id is not null",client.getId() != null);
        verify(clientRepository, times(1)).createProvider(any());
    }

    @Test
    @DisplayName("Return Client by ID")
    void getClient() {
        when(clientRepository.getProvider(any())).thenReturn(getOptionalClientTemplat());
        var client = this.clienteServiceImpl.getProvider(ID);
        assertNotNull("Test OK",client);
        verify(clientRepository, times(1)).getProvider(anyString());
    }

    @Test
    @DisplayName("Return ResourceNotFoundException im Client by ID")
    void sholdReturngetResourceNotFoundException() {
        Throwable ex = assertThrows(Throwable.class, () -> clienteServiceImpl.getProvider(ID));
        assertEquals(ex.getClass() ,ResourceNotFoundException.class);
        verify(clientRepository, times(1)).getProvider(anyString());
    }

    @Test
    @DisplayName("Return delete Client by ID")
    void deleteClient() {
        when(clientRepository.getProvider(anyString())).thenReturn(getOptionalClientTemplat());
        this.clienteServiceImpl.deleteProviderById(ID);
        verify(clientRepository, times(1)).getProvider(anyString());
        verify(clientSnsEvent, times(1)).deleteClient(any());
    }

    @Test
    @DisplayName("Return list all Provider")
    void listProvider() {
        when(clientRepository.listProvider()).thenReturn(listAllProvider());
        this.clienteServiceImpl.listProvider();
        verify(clientRepository, times(1)).listProvider();
    }
}