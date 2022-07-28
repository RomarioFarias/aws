package br.com.aws_project.adapter.outbound.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static br.com.aws_project.templates.ClientTemplatTest.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ClientRepositoryImplTest {

  @Mock ClientMongoRepository clientMongoRepository;

  @InjectMocks ClientRepositoryImpl clientRepositoryImpl;

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
    clientRepositoryImpl.getClient(ID);
    verify(clientMongoRepository, times(1)).findClientById(any());
  }
}