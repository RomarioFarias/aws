package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product findProductById(String productId);

    void deleteProduct(String productId);

    void deleteAllProductByProviderId(String productId);


}
