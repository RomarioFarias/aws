package br.com.aws_project.applications.service;


import br.com.aws_project.applications.enumeration.ExceptionCode;
import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.exception.UnprocessableEntityException;
import br.com.aws_project.applications.port.ClientRepository;
import br.com.aws_project.applications.port.ClientService;
import br.com.aws_project.applications.entity.Client;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientServiceImpl implements ClientService {

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private final ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.createClient(client);
    }

    @Override
    public Client getClient(String id) {
        var client = clientRepository.getClient(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionCode.CLIENT_NOT_FOUND, id));
        log.info("User client name: [name={}]", client.getName());
        return client;
    }
}
