package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Provider;

import java.util.Optional;
import java.util.Set;

public interface ClientRepository {

    Provider createProvider(Provider Provider);
    Optional<Provider> getProvider(String id);

    void deleteClientById(Provider Provider);

    Set<Provider> listProvider();
}
