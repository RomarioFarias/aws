package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ClientMongoRepository;
import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.templates.ClientTemplatTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.util.AssertionErrors;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static br.com.aws_project.templates.ClientTemplatTest.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

class ProviderRepositoryImplTest {

    @Mock
    ClientMongoRepository clientMongoRepository;

    @InjectMocks
    ClientRepositoryImpl clientRepositoryImpl;

    @BeforeEach
    void setup() {
        openMocks(this);
    }

    @Test
    void createClient() {
        when(clientMongoRepository.save(any())).thenReturn(getClientTemplat());
        clientMongoRepository.save(getClientTemplat());
        verify(clientMongoRepository, times(1)).save(any());
    }

    @Test
    void getClient() {
        when(clientMongoRepository.findClientById(anyString())).thenReturn(getOptionalClientTemplat());
        clientRepositoryImpl.getProvider(ID);
        verify(clientMongoRepository, times(1)).findClientById(any());
    }

    @Test
    void deleteClient() {
        clientRepositoryImpl.deleteClientById(getClientTemplat());
        verify(clientMongoRepository, times(1)).delete(any());
    }

    @Test
    void listAllProvider() {
        when(clientMongoRepository.findAll()).thenReturn(new ArrayList<>(ClientTemplatTest.listAllProvider()));
        var listProvider = clientRepositoryImpl.listProvider();
        Assertions.assertNotNull(listProvider);
        verify(clientMongoRepository, times(1)).findAll();
    }
}
