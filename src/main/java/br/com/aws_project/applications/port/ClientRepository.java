package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Client;

import java.util.Optional;

public interface ClientRepository {

    Client createClient(Client client);
    Optional<Client> getClient(String id);
}
