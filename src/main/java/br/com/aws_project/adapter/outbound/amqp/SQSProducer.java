package br.com.aws_project.adapter.outbound.amqp;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SQSProducer {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public void sendMessage(String topicName, Object message) {
        queueMessagingTemplate.send(topicName, (Message<?>) message);
    }

    public void sendObjectMessage(String topicName, Object message) {
        queueMessagingTemplate.convertAndSend(topicName, message);
    }
}