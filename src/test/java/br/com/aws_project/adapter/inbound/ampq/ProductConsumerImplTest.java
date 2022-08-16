package br.com.aws_project.adapter.inbound.ampq;

import br.com.aws_project.applications.entity.ProviderEvent;
import br.com.aws_project.applications.port.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static br.com.aws_project.templates.ProviderEventTemplat.getProviderEventTemplat;
import static br.com.aws_project.templates.ProviderEventTemplat.getRequestHeadersTemplat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ProductConsumerImplTest {

    @InjectMocks
    ProductConsumerImpl productConsumerImpl;

    @Mock
    ProductService productService;

    @Mock
    ObjectMapper objectMapper;



    @BeforeEach
    void setup(){
        openMocks(this);
    }

    @Test
    void deleteClient() throws JsonProcessingException {
        when(objectMapper.readValue(anyString(), eq(ProviderEvent.class))).thenReturn(getProviderEventTemplat());
        productConsumerImpl.deleteClient(getProviderEventTemplat(), getRequestHeadersTemplat() );
    }
}