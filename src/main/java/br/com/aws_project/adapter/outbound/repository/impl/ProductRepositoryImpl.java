package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ProductMongoRepository;
import br.com.aws_project.applications.entity.Product;
import br.com.aws_project.applications.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

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

    @Override
    public void deleteProduct(Product product) {
        this.productMongoRepository.delete(product);
    }

    @Override
    public Set<Product> listProducByProviderId(String productId) {
        return productMongoRepository.findProductByProviderId(productId);
    }

    @Override
    public void deleteAllProduct(Set<Product> listProduct) {
        productMongoRepository.deleteAll(listProduct);
    }
}
