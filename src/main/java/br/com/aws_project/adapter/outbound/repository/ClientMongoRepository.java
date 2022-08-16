package br.com.aws_project.adapter.outbound.repository;

import br.com.aws_project.applications.entity.Provider;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMongoRepository extends MongoRepository<Provider, String> {
    Optional<Provider> findClientById(String id);

}
