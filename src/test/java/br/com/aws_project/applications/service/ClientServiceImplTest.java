package br.com.aws_project.applications.service;

import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.port.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.aws_project.templates.ClientTemplatTest.ID;
import static br.com.aws_project.templates.ClientTemplatTest.getOptionalClientTemplat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

class ClientServiceImplTest {

    @InjectMocks
    ClientServiceImpl clienteServiceImpl;

    @Mock
    ClientRepository clientRepository;

    @BeforeEach
     void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createClient() {
    }

    @Test
    @DisplayName("Return Client by ID")
    void getClient() {
        when(clientRepository.getClient(any())).thenReturn(getOptionalClientTemplat());
        var client = this.clienteServiceImpl.getClient(ID);
        assertNotNull("Test OK",client);
        verify(clientRepository, times(1)).getClient(anyString());
    }

    @Test
    @DisplayName("Return ResourceNotFoundException im Client by ID")
    void getClient1() {
        Throwable ex = assertThrows(Throwable.class, () -> clienteServiceImpl.getClient(ID));
        assertEquals(ex.getClass() ,ResourceNotFoundException.class);
        verify(clientRepository, times(1)).getClient(anyString());
    }
}