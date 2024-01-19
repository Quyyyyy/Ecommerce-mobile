package org.example.webdt.services;

import org.example.webdt.dto.CategoryDto;
import org.example.webdt.dto.ResultResponse;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long id);
    ResultResponse getAllCategories(int pageNo, int pageSize, String sortDir, String sortBy);
    String deleteCate(Long id);
    List<CategoryDto> getCategories();
}
