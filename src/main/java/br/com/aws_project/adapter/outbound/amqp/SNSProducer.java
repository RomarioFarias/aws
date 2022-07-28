package br.com.aws_project.adapter.outbound.amqp;

import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SNSProducer {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    public void send(String topicName, Object message, String subject) {
        notificationMessagingTemplate.sendNotification(topicName, message, subject);
    }

    public void send(String topicName, Object message) {
        notificationMessagingTemplate.convertAndSend(topicName, message);
    }
}