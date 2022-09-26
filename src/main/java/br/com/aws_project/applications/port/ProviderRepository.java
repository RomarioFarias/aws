package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Provider;

import java.util.Optional;
import java.util.Set;

public interface ProviderRepository {

    Provider createProvider(Provider provider);
    Optional<Provider> getProvider(String id);

    void deleteProviderById(Provider provider);

    Set<Provider> listProvider();
}
