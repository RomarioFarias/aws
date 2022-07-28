package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.ClientEvent;

public interface ClientSnsEvent {
    void deleteClient(ClientEvent clientEvent);
}
