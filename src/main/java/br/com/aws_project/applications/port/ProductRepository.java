package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    Product createProduct(Product product);

    Optional<Product> findProductById(String productId);
}
