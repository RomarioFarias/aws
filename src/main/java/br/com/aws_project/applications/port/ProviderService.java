package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Provider;

import java.util.Set;

public interface ProviderService {
    Provider createClient(Provider Provider);

    Provider getClient(String id);

    void deleteClientById(String id);

    Set<Provider> listClients();
}
