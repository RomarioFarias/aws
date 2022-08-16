package br.com.aws_project.applications.service;

import br.com.aws_project.applications.port.ProductRepository;
import br.com.aws_project.applications.port.ProviderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.aws_project.templates.ProductTemplatTest.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {
    @Mock
    ProductRepository productRepository;

    @Mock
    ProviderService providerService;

    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        when(productRepository.createProduct(any())).thenReturn(getProducTemplat());
        var product = productServiceImpl.createProduct(getProducTemplat());

        Assertions.assertNotNull(product);
        verify(productRepository, times(1)).createProduct(any());

    }

    @Test
    void findProductById() {
        when(productRepository.findProductById(any())).thenReturn(getOptinalProduct());
        var product = productServiceImpl.findProductById(ID);

        Assertions.assertNotNull(product);
        verify(productRepository, times(1)).findProductById(any());

    }

    @Test
    void deleteProductById() {
        when(productRepository.findProductById(any())).thenReturn(getOptinalProduct());
        productServiceImpl.deleteProduct(ID);

        verify(productRepository, times(1)).findProductById(any());
        verify(productRepository, times(1)).deleteProduct(any());

    }


    @Test
    void deleteProductAll() {
        var listProduct = getListProduct();
        when(productRepository.listProducByProviderId(any())).thenReturn(listProduct);
        productServiceImpl.deleteAllProductByProviderId(ID);
        verify(productRepository, times(1)).listProducByProviderId(any());
        verify(productRepository, times(1)).deleteAllProduct(any());

    }
}