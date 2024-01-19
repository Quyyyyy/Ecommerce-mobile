package org.example.webdt.dto.mapper;

import org.example.webdt.dto.ProductDto;
import org.example.webdt.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "categories", target = "categories")
    ProductDto mapToProductDto(ProductEntity product);
    @Mapping(source = "categories", target = "categories")
    ProductEntity mapToProductEntity(ProductDto productDto);
}
