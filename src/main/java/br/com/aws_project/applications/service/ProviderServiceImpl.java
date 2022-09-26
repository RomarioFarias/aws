package br.com.aws_project.applications.service;


import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.applications.entity.ProviderEvent;
import br.com.aws_project.applications.enumeration.ExceptionCode;
import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.port.ClientRepository;
import br.com.aws_project.applications.port.ProviderService;
import br.com.aws_project.applications.port.ClientSnsEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
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
    public Provider createProvider(Provider Provider) {
        Provider.setId(UUID.randomUUID().toString());
        log.info("Create provider by [ID={}]", Provider.getId());
        return clientRepository.createProvider(Provider);
    }

    @Override
    public Provider getProvider(String id) {
        var client = clientRepository.getProvider(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionCode.PROVIDER_NOT_FOUND, id));
        log.info("Provider name: [name={}]", client.getName());
        return client;
    }

    @Override
    public void deleteProviderById(String id) {
        var client = this.getProvider(id);
        log.info("Delete Provider by [ID={}]", client.getId());
        clientRepository.deleteClientById(client);
        clientSnsEvent.deleteClient(new ProviderEvent(client.getId(), client.getName()));
    }

    @Override
    public Set<Provider> listProvider() {
        log.info("List all Providers");
        return this.clientRepository.listProvider();
    }
}
