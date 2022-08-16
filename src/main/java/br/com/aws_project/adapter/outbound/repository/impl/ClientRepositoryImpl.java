package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ClientMongoRepository;
import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.applications.port.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private ClientMongoRepository clientMongoRepository;

    @Override
    public Provider createClient(Provider provider) {
        return clientMongoRepository.save(provider);
    }

    @Override
    public Optional<Provider> getClient(String id) {
        return clientMongoRepository.findClientById(id);
    }

    @Override
    public void deleteClientById(Provider provider) {
        clientMongoRepository.delete(provider);
    }
}
