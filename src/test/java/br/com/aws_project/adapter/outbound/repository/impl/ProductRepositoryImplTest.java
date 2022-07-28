package br.com.aws_project.adapter.outbound.repository.impl;

import br.com.aws_project.adapter.outbound.repository.ProductMongoRepository;
import br.com.aws_project.applications.port.ProductRepository;
import br.com.aws_project.templates.ProductTemplatTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static br.com.aws_project.templates.ProductTemplatTest.getProducTemplat;
import static org.junit.jupiter.api.Assertions.*;
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
}