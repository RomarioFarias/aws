package br.com.aws_project.adapter.outbound.mapper;

import br.com.aws_project.adapter.inbound.dto.ClientDto;
import br.com.aws_project.adapter.inbound.dto.ProductDto;
import br.com.aws_project.applications.entity.Product;
import br.com.aws_project.applications.entity.Provider;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class ProductModelMapper {
    private ModelMapper modelMapper;

    public Product toProduct(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    public ProductDto toProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }


}
