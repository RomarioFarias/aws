package br.com.aws_project.applications.port;

import br.com.aws_project.applications.entity.Product;
import br.com.aws_project.applications.entity.Provider;

public interface ProductService {
    Product createProduct(Product product);

}
