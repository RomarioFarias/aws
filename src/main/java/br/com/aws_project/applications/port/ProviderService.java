package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Provider;

import java.util.Set;

public interface ProviderService {
    Provider createProvider(Provider provider);

    Provider getProvider(String id);

    void deleteProviderById(String id);

    Set<Provider> listProvider();
}
