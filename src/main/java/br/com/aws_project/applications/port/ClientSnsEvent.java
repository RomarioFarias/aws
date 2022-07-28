package br.com.aws_project.applications.port;

import br.com.aws_project.adapter.inbound.dto.ClientDto;

public interface ClientSnsEvent {
   void deleteClient(ClientDto client);
}
