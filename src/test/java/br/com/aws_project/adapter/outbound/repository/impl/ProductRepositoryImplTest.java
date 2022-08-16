package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ProductMongoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static br.com.aws_project.templates.ProductTemplatTest.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ProductRepositoryImplTest {

    @Mock
    ProductMongoRepository productRepository;

    @InjectMocks
    ProductRepositoryImpl productRepositoryImpl;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        Mockito.when(productRepository.save(any())).thenReturn(getProducTemplat());
        productRepositoryImpl.createProduct(getProducTemplat());
        verify(productRepository, times(1)).save(any());

    }

    @Test
    void findProductById() {
        Mockito.when(productRepository.findProductById(any())).thenReturn(getOptinalProduct());
        productRepositoryImpl.findProductById(ID);
        verify(productRepository, times(1)).findProductById(any());
    }

    @Test
    void deleteProduct() {
        productRepositoryImpl.deleteProduct(getProducTemplat());
        verify(productRepository, times(1)).delete(any());
    }

    @Test
    void deleteAllProduct() {
        productRepositoryImpl.deleteAllProduct(getListProduct());
        verify(productRepository, times(1)).deleteAll(any());
    }

    @Test
    void listProducByProviderId() {
        productRepositoryImpl.listProducByProviderId(ID);
        verify(productRepository, times(1)).findProductByProviderId(any());
    }
}