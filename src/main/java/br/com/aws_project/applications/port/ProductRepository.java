package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Product;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository {

    Product createProduct(Product product);

    Optional<Product> findProductById(String productId);

    void deleteProduct(Product productId);
    Set<Product> listProducByProviderId(String providerId);

    void deleteAllProduct(Set<Product> listProduct );
}
