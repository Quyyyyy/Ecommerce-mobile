package org.example.webdt.dto.mapper;

import org.example.webdt.dto.CategoryDto;
import org.example.webdt.entities.CategoriesEntity;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;


@Mapper
public interface CategoryMapper {
    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);
    CategoryDto mapToCategoryDto(CategoriesEntity categoriesEntity);
    CategoriesEntity mapToCategoriesEntity(CategoryDto categoryDto);
}
