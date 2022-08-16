package br.com.aws_project.adapter.inbound.ampq;

import br.com.aws_project.applications.entity.ProviderEvent;
import br.com.aws_project.applications.port.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.messaging.config.annotation.NotificationMessage;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductConsumerImpl {
    private final ObjectMapper objectMapper;
    private final ProductService productService;


    @SqsListener(value = "test-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void deleteClient(@NotificationMessage ProviderEvent providerEvent, @Header("SenderId") Map<String, Object> senderId) throws JsonProcessingException {
        providerEvent = objectMapper.readValue(senderId.get("Message").toString(), ProviderEvent.class);
        log.info("Notification to [topic = {}]  and [provider ID :{}] ", senderId, providerEvent.getId());
        if (providerEvent.getId() != null) {
            this.productService.deleteAllProductByProviderId(providerEvent.getId());
        }
    }
}
