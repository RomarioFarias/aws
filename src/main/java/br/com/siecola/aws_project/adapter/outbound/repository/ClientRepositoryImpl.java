package br.com.siecola.aws_project.adapter.outbound.repository;

import br.com.siecola.aws_project.applications.entity.Client;
import br.com.siecola.aws_project.applications.port.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private ClientMongoRepository clientMongoRepository;

    @Override
    public Client createClient(Client client) {
        return clientMongoRepository.save(client);
    }
}
