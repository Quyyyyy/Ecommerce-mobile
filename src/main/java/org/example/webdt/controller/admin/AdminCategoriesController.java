package org.example.webdt.controller.admin;


import org.example.webdt.dto.CategoryDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.services.CategoryService;
import org.example.webdt.utils.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCategoriesController {
    CategoryService categoryService;

    public AdminCategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String home(
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
           @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
           @RequestParam(value="sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
           @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir,
           Model model){
        ResultResponse result = categoryService.getAllCategories(pageNo, pageSize, sortDir, sortBy);
        List<CategoryDto> categories = (List<CategoryDto>) result.getContent();
        model.addAttribute("categories",categories);
        model.addAttribute("result",result);
        model.addAttribute("url","../");
        return "admin/list-cate";
    }

    @GetMapping("/categories/create")
    public String ShowAddCteView(Model model){
        model.addAttribute("url","../../");
        return "admin/add-cate";
    }

    @GetMapping("/categories/{id}")
    public String getCateById(Model model, @PathVariable("id") Long id){
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        model.addAttribute("url","../../");
        model.addAttribute("category",categoryDto);
        return "admin/add-cate";
    }

    @PostMapping("/categories/create")
    public String AddUser(Model model, @ModelAttribute CategoryDto cate){
        CategoryDto categoryDto = categoryService.createCategory(cate);
        return "redirect:/admin/categories";
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCate(@PathVariable("id") Long id){
        String result = categoryService.deleteCate(id);
        return ResponseEntity.ok(result);
    }
}
