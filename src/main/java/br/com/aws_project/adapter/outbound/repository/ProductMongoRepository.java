package br.com.aws_project.adapter.outbound.repository;

import br.com.aws_project.applications.entity.Product;
import br.com.aws_project.applications.entity.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String> {

}
