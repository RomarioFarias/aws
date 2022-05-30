package br.com.siecola.aws_project.adapter.outbound.repository;

import br.com.siecola.aws_project.applications.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientMongoRepository extends MongoRepository<Client, String> {
}
