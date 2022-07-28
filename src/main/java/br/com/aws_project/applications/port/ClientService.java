package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Client;

public interface ClientService {
    Client createClient(Client client);

    Client getClient(String id);

    void deleteClientById(String id);
}
