package br.com.aws_project.applications.service;


import br.com.aws_project.applications.entity.Product;
import br.com.aws_project.applications.enumeration.ExceptionCode;
import br.com.aws_project.applications.exception.ResourceNotFoundException;
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
        var productSave = productRepository.createProduct(product);
        log.info("Product create by [ID: {}]", productSave.getId());
        return productSave;
    }

    @Override
    public Product findProductById(String productId) {
        log.info("Find Product by [ID: {}]", productId);

        return productRepository.findProductById(productId).orElseThrow(() -> new ResourceNotFoundException(ExceptionCode.PRODUCT_NOT_FOUND, productId));
    }

    @Override
    public void deleteProduct(String productId) {
        var product = this.findProductById(productId);
        log.info("Delete product by [ID:{}]", productId);
        this.productRepository.deleteProduct(product);
    }


    @Override
    public void deleteAllProductByProviderId(String providerId) {
        var listProduct = productRepository.listProducByProviderId(providerId);
        log.info("Delete all product by [providerID:{}]", providerId);
        productRepository.deleteAllProduct(listProduct);

    }

    private void validProvider(String providerId) {
        providerService.getProvider(providerId);
    }
}
