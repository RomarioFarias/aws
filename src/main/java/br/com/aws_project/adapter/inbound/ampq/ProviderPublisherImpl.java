package br.com.aws_project.adapter.inbound.ampq;

import br.com.aws_project.adapter.outbound.amqp.SNSProducer;
import br.com.aws_project.applications.entity.ProviderEvent;
import br.com.aws_project.applications.port.ProviderSnsEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProviderPublisherImpl implements ProviderSnsEvent {

    private final SNSProducer producer;

    @Value("${cloud.aws.sns.topic.t-client-delete-requested}")
    private String clientUpdateTopic;


    @Override
    public void deleteProvider(ProviderEvent clientEven) {
        log.info("Sending notification to [topic={}] for provider delete [getId={}]",
                clientUpdateTopic, clientEven.getId());

        producer.send(clientUpdateTopic, clientEven);
    }
}
