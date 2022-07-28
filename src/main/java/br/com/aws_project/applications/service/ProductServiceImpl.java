package br.com.aws_project.applications.service;


import br.com.aws_project.applications.entity.Product;
import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.applications.port.ClientRepository;
import br.com.aws_project.applications.port.ProductRepository;
import br.com.aws_project.applications.port.ProductService;
import br.com.aws_project.applications.port.ProviderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {



    private final ProductRepository productRepository;

    private final ProviderService providerService;

    @Override
    public Product createProduct(Product product) {
        this.validProvider(product.getProviderId());

        product.setId(UUID.randomUUID().toString());
        return productRepository.createProduct(product);
    }

    private void validProvider(String providerId){
        providerService.getClient(providerId);
    }
}
