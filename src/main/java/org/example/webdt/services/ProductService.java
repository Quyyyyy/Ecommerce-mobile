package org.example.webdt.services;

import org.example.webdt.dto.ProductDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.request.ProductRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long id);
    ProductDto updateProduct(ProductDto productDto);
    ResultResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir);
    List<ProductDto> getAllProductsByCate(Long cate);
    List<ProductDto> getPronews();
    ResultResponse search(Long minPrice, Long maxPrice,
                          String categoryName, String brand,String sortDir,String sortBy,
                          int pageNo, int pageSize);
    ResultResponse search1(String title,int pageNo,int pageSize);

    ProductDto createProduct(ProductRequest productDto, MultipartFile avatar) throws IOException;
}
