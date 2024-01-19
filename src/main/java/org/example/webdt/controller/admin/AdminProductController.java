package org.example.webdt.controller.admin;


import org.example.webdt.dto.CategoryDto;
import org.example.webdt.dto.ProductDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.request.ProductRequest;
import org.example.webdt.services.CategoryService;
import org.example.webdt.services.ProductService;
import org.example.webdt.utils.AppConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
    private ProductService productService;
    private CategoryService categoryService;

    public AdminProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String home(
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value="sortBy",defaultValue = "updated",required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir,
            Model model
    ){
        ResultResponse result = productService.getAllProducts(pageNo, pageSize, sortBy, sortDir);
        List<ProductDto> products = (List<ProductDto>) result.getContent();
        model.addAttribute("products",products);
        model.addAttribute("result",result);
        model.addAttribute("url","../");
        return "admin/list-product";
    }

    @GetMapping("/products/create")
    public String ShowAddProductView(Model model){
        model.addAttribute("url","../../");
        List<CategoryDto> list = categoryService.getCategories();
        model.addAttribute("categories",list);
        return "admin/add-product";
    }

    @GetMapping("/products/{id}")
    public String getProductById(Model model, @PathVariable("id") Long id){
        ProductDto productDto = productService.getProductById(id);
        model.addAttribute("url","../../");
        model.addAttribute("product",productDto);
        List<CategoryDto> list = categoryService.getCategories();
        model.addAttribute("categories",list);
        return "admin/add-product";
    }

    @PostMapping("/products/create")
    public String addProduct(Model model, @ModelAttribute ProductRequest product
    , @RequestParam("avatar")MultipartFile avatar) throws IOException {
        ProductDto productDto1 = productService.createProduct(product,avatar);
        return "redirect:/admin/products";
    }
}
