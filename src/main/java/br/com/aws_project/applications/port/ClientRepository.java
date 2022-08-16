package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Provider;

import java.util.Optional;

public interface ClientRepository {

    Provider createClient(Provider provider);
    Optional<Provider> getClient(String id);

    void deleteClientById(Provider provider);
}
