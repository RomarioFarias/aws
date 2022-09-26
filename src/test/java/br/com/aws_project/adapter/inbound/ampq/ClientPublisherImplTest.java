package br.com.aws_project.adapter.inbound.ampq;

import br.com.aws_project.adapter.outbound.amqp.SNSProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.aws_project.templates.ProviderEventTemplat.getProviderEventTemplat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ClientPublisherImplTest {

    @InjectMocks
    ProviderPublisherImpl clientPublisher;

    @Mock
    SNSProducer snsProducer;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteClient() {
       this.clientPublisher.deleteProvider(getProviderEventTemplat());
       verify(snsProducer, times(1)).send(any(),any());
    }
}