package br.com.siecola.aws_project.applications.service;

import br.com.siecola.aws_project.applications.port.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ClientServiceImplTest {

    @InjectMocks
    ClientServiceImpl clienteServiceImpl;

    @Mock
    ClientRepository clientRepository;

    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createClient() {
    }

    @Test
    void getClient() {
    }
}