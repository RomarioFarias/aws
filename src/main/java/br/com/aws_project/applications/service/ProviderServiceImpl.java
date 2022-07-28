package br.com.aws_project.applications.service;


import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.applications.entity.ProviderEvent;
import br.com.aws_project.applications.enumeration.ExceptionCode;
import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.port.ClientRepository;
import br.com.aws_project.applications.port.ProviderService;
import br.com.aws_project.applications.port.ClientSnsEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ProviderServiceImpl implements ProviderService {

    public ProviderServiceImpl(ClientRepository clientRepository, ClientSnsEvent clientSnsEvent) {
        this.clientRepository = clientRepository;
        this.clientSnsEvent = clientSnsEvent;
    }

    private final ClientRepository clientRepository;
    private final ClientSnsEvent clientSnsEvent;

    @Override
    public Provider createClient(Provider provider) {
        provider.setId(UUID.randomUUID().toString());
        log.info("Create client by [ID={}]", provider.getId());
        return clientRepository.createClient(provider);
    }

    @Override
    public Provider getClient(String id) {
        var client = clientRepository.getClient(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionCode.CLIENT_NOT_FOUND, id));
        log.info("User client name: [name={}]", client.getName());
        return client;
    }

    @Override
    public void deleteClientById(String id) {
        var client = this.getClient(id);
        log.info("Delete Client by [ID={}]",client.getId());
        clientRepository.deleteClientById(client);
        clientSnsEvent.deleteClient(new ProviderEvent(client.getId(), client.getName()));
    }
}
