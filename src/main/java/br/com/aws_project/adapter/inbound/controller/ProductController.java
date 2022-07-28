package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.inbound.dto.ProductDto;
import br.com.aws_project.adapter.outbound.mapper.ProductModelMapper;
import br.com.aws_project.applications.port.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductModelMapper productModelMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ProductDto createProduct(@RequestBody ProductDto productDto){
        var product = productService.createProduct(productModelMapper.toProduct(productDto));
        return productModelMapper.toProductDto(product);
    }

}
