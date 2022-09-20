package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ClientMongoRepository;
import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.applications.port.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private ClientMongoRepository clientMongoRepository;

    @Override
    public Provider createProvider(Provider Provider) {
        return clientMongoRepository.save(Provider);
    }

    @Override
    public Optional<Provider> getProvider(String id) {
        return clientMongoRepository.findClientById(id);
    }

    @Override
    public void deleteClientById(Provider Provider) {
        clientMongoRepository.delete(Provider);
    }

    @Override
    public Set<Provider> listClients() {
            return new HashSet<>(clientMongoRepository.findAll());
    }
}
