package br.com.siecola.aws_project.applications.service;


import br.com.siecola.aws_project.applications.entity.Client;
import br.com.siecola.aws_project.applications.enumeration.ExceptionCode;
import br.com.siecola.aws_project.applications.exception.UnprocessableEntityException;
import br.com.siecola.aws_project.applications.port.ClientRepository;
import br.com.siecola.aws_project.applications.port.ClientService;
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
        var client = clientRepository.getClient(id).orElseThrow(()-> new UnprocessableEntityException(ExceptionCode.BUSINESS_EXCEPTION));
        log.info("User client name: [name={}]", client.getName());
        return client;
    }
}
