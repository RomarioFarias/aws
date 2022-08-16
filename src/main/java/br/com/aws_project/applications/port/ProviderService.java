package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Provider;

public interface ProviderService {
    Provider createClient(Provider provider);

    Provider getClient(String id);

    void deleteClientById(String id);
}
