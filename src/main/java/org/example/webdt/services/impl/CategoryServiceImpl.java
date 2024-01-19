package org.example.webdt.services.impl;

import org.example.webdt.dto.CategoryDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.mapper.CategoryMapper;
import org.example.webdt.entities.CategoriesEntity;
import org.example.webdt.repositories.CategoriesEntityRepository;
import org.example.webdt.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoriesEntityRepository categoriesRepository;

    public CategoryServiceImpl(CategoriesEntityRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        CategoriesEntity category = new CategoriesEntity();
        if(categoryDto.getId() != null){
            category = categoriesRepository.findById(categoryDto.getId()).get();
        }
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        CategoriesEntity category1 = categoriesRepository.save(category);
        return CategoryMapper.MAPPER.mapToCategoryDto(category1);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        CategoriesEntity categories = categoriesRepository.findById(id).get();
        CategoryDto categoryDto = CategoryMapper.MAPPER.mapToCategoryDto(categories);
        return categoryDto;
    }

    @Override
    public ResultResponse getAllCategories(int pageNo, int pageSize, String sortDir, String sortBy) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<CategoriesEntity> categories = categoriesRepository.findAll(pageable);
        List<CategoriesEntity> listOfcategory = categories.getContent();
        List<CategoryDto> contents = listOfcategory.stream()
                .map(category -> CategoryMapper.MAPPER.mapToCategoryDto(category)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(categories.getNumber());
        resultResponse.setPageSize(categories.getSize());
        resultResponse.setTotalElements(categories.getTotalElements());
        resultResponse.setTotalPages(categories.getTotalPages());
        resultResponse.setLast(categories.isLast());
        return resultResponse;
    }

    @Override
    public String deleteCate(Long id) {
        categoriesRepository.deleteById(id);
        if(categoriesRepository.existsById(id)){
            return "Không thể xóa do có dữ liệu liên quan";
        } else{
            return "Xóa thành công";
        }
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<CategoriesEntity> categories = categoriesRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(
                (category)->CategoryMapper.MAPPER.mapToCategoryDto(category)).collect(Collectors.toList());
        return categoryDtos;
    }
}
