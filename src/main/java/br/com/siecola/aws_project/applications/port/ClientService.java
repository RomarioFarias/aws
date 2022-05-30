package br.com.siecola.aws_project.applications.port;

import br.com.siecola.aws_project.applications.entity.Client;

public interface ClientService {
    Client createClient(Client client);

    Client getClient(String id);
}
