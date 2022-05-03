package br.com.siecola.aws_project.applications.port;

import br.com.siecola.aws_project.applications.entity.Client;

public interface ClientRepository {

    Client createClient(Client client);
}
