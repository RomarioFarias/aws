package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ProviderMongoRepository;
import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.applications.port.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
public class ProviderRepositoryImpl implements ProviderRepository {

    private ProviderMongoRepository providerMongoRepository;

    @Override
    public Provider createProvider(Provider provider) {
        return providerMongoRepository.save(provider);
    }

    @Override
    public Optional<Provider> getProvider(String id) {
        return providerMongoRepository.findProviderById(id);
    }

    @Override
    public void deleteProviderById(Provider provider) {
        providerMongoRepository.delete(provider);
    }

    @Override
    public Set<Provider> listProvider() {
            return new HashSet<>(providerMongoRepository.findAll());
    }
}
