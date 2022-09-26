package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ProviderMongoRepository;
import br.com.aws_project.templates.ProviderTemplatTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static br.com.aws_project.templates.ProviderTemplatTest.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ProviderRepositoryImplTest {

    @Mock
    ProviderMongoRepository providerMongoRepository;

    @InjectMocks
    ProviderRepositoryImpl providerRepository;

    @BeforeEach
    void setup() {
        openMocks(this);
    }

    @Test
    void createProvider() {
        when(providerMongoRepository.save(any())).thenReturn(getProviderTemplat());
        providerMongoRepository.save(getProviderTemplat());
        verify(providerMongoRepository, times(1)).save(any());
    }

    @Test
    void getProvider() {
        when(providerMongoRepository.findProviderById(anyString())).thenReturn(getOptionalProviderTemplat());
        providerRepository.getProvider(ID);
        verify(providerMongoRepository, times(1)).findProviderById(any());
    }

    @Test
    void deleteProvider() {
        providerRepository.deleteProviderById(getProviderTemplat());
        verify(providerMongoRepository, times(1)).delete(any());
    }

    @Test
    void listAllProvider() {
        when(providerMongoRepository.findAll()).thenReturn(new ArrayList<>(ProviderTemplatTest.listAllProvider()));
        var listProvider = providerMongoRepository.findAll();
        Assertions.assertNotNull(listProvider);
        verify(providerMongoRepository, times(1)).findAll();
    }
}
