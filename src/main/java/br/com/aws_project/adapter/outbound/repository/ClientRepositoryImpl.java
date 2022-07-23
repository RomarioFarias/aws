package br.com.aws_project.adapter.outbound.repository;

import br.com.aws_project.applications.entity.Client;
import br.com.aws_project.applications.port.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private ClientMongoRepository clientMongoRepository;

    @Override
    public Client createClient(Client client) {
        client.setId(UUID.randomUUID().toString());
        return clientMongoRepository.save(client);
    }

    @Override
    public Optional<Client> getClient(String id) {
        return clientMongoRepository.findClientById(id);
    }
}
