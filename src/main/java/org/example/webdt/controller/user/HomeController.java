package org.example.webdt.controller.user;

import org.example.webdt.dto.CommentDto;
import org.example.webdt.dto.ProductDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.entities.CommentEntity;
import org.example.webdt.services.CommentService;
import org.example.webdt.services.ProductService;
import org.example.webdt.utils.AppConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class HomeController {
    private ProductService productService;
    private CommentService commentService;

    public HomeController(ProductService productService, CommentService commentService) {
        this.productService = productService;
        this.commentService = commentService;
    }

    @GetMapping("/index")
    private String home(Model model){
        String $url = "../../";
        model.addAttribute("url",$url);
        List<ProductDto> pronews = productService.getPronews();
        List<ProductDto> proFlas = productService.getAllProductsByCate(1L);
        List<ProductDto> proMidran = productService.getAllProductsByCate(2L);
        List<ProductDto> proBud = productService.getAllProductsByCate(3L);
        model.addAttribute("news",pronews);
        model.addAttribute("Flagship",proFlas);
        model.addAttribute("Midrange",proMidran);
        model.addAttribute("Budget",proBud);
        return "user/index";
    }

    @GetMapping("/detail/{id}")
    private String detail(@PathVariable("id") Long id,
          @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
          @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
          Model model){
        ProductDto productDto = productService.getProductById(id);
        ResultResponse comments = commentService.getAllCommentByProduct(id,pageNo,pageSize);
        List<CommentEntity> commentDtos = (List<CommentEntity>) comments.getContent();
        String $url = "../../";
        List<ProductDto> pros = productService.getAllProductsByCate(productDto.getCategories().getId());
        model.addAttribute("pros",pros);
        model.addAttribute("product",productDto);
        model.addAttribute("comments",commentDtos);
        model.addAttribute("result",comments);
        model.addAttribute("url",$url);
        return "user/detail";
    }

    @GetMapping("/filter")
    private String filter(
        @RequestParam(value="minprice",required = false) Long minPrice,
        @RequestParam(value="maxprice",required = false) Long maxPrice,
       @RequestParam(value="thuong-hieu",required = false) String brand,
       @RequestParam(value="cate",required = false) String categoryName,
       @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
       @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
       @RequestParam(value="sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
       @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir,
            Model model){
        String $url = "../../";
        ResultResponse result = productService.search(minPrice,maxPrice,categoryName,
                brand,sortDir,sortBy,pageNo,pageSize);
        List<ProductDto> pros = (List<ProductDto>) result.getContent();
        model.addAttribute("pros",pros);
        model.addAttribute("result",result);
        model.addAttribute("url",$url);
        return "user/category";
    }

    @GetMapping("/tim-kiem")
    private String search(Model model, @RequestParam("content") String title,
          @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
          @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize){

        String $url = "../../";
        ResultResponse result = productService.search1(title,pageNo,pageSize);
        List<ProductDto> pros = (List<ProductDto>) result.getContent();
        model.addAttribute("pros",pros);
        model.addAttribute("result",result);
        model.addAttribute("url",$url);
        return "user/search";
    }
}
