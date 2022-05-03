package br.com.siecola.aws_project.applications.service;


import br.com.siecola.aws_project.applications.entity.Client;
import br.com.siecola.aws_project.applications.port.ClientRepository;
import br.com.siecola.aws_project.applications.port.ClientService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientServiceImpl implements ClientService {


    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.createClient(client);
    }
}
