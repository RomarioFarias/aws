package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ProductMongoRepository;
import br.com.aws_project.applications.entity.Product;
import br.com.aws_project.applications.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private ProductMongoRepository productMongoRepository;


    @Override
    public Product createProduct(Product product) {
        return productMongoRepository.save(product);
    }

    @Override
    public Optional<Product> findProductById(String productId) {
        return productMongoRepository.findProductById(productId);
    }
}
