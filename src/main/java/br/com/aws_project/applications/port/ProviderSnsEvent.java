package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.ProviderEvent;

public interface ProviderSnsEvent {
    void deleteProvider(ProviderEvent providerEvent);
}
