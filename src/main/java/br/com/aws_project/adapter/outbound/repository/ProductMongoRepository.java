package br.com.aws_project.adapter.outbound.repository;

import br.com.aws_project.applications.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String> {
    Optional<Product> findProductById(String productId);
    Set<Product> findProductByProviderId(String providerId);

}
