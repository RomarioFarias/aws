package br.com.aws_project.applications.service;


import br.com.aws_project.adapter.inbound.dto.ClientDto;
import br.com.aws_project.applications.enumeration.ExceptionCode;
import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.port.ClientRepository;
import br.com.aws_project.applications.port.ClientService;
import br.com.aws_project.applications.entity.Client;
import br.com.aws_project.applications.port.ClientSnsEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ClientServiceImpl implements ClientService {

    public ClientServiceImpl(ClientRepository clientRepository, ClientSnsEvent clientSnsEvent) {
        this.clientRepository = clientRepository;
        this.clientSnsEvent = clientSnsEvent;
    }

    private final ClientRepository clientRepository;
    private final ClientSnsEvent clientSnsEvent;

    @Override
    public Client createClient(Client client) {
        client.setId(UUID.randomUUID().toString());
        return clientRepository.createClient(client);
    }

    @Override
    public Client getClient(String id) {
        var client = clientRepository.getClient(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionCode.CLIENT_NOT_FOUND, id));
        log.info("User client name: [name={}]", client.getName());
        return client;
    }
}
