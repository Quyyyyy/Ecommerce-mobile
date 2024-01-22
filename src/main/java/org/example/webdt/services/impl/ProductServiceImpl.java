package org.example.webdt.services.impl;

import jakarta.transaction.Transactional;
import org.example.webdt.dto.ProductDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.mapper.ProductMapper;
import org.example.webdt.dto.request.ProductRequest;
import org.example.webdt.entities.CategoriesEntity;
import org.example.webdt.entities.ProductEntity;
import org.example.webdt.repositories.CategoriesEntityRepository;
import org.example.webdt.repositories.ProductEntityRepository;
import org.example.webdt.services.ProductService;
import org.example.webdt.services.ProductSpecificatons;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private ProductEntityRepository productRepository;
    private CategoriesEntityRepository categoriesRepository;

    public ProductServiceImpl(ProductEntityRepository productRepository, CategoriesEntityRepository categoriesRepository) {
        this.productRepository = productRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity product = productRepository.findById(id).get();
        ProductDto productDto = ProductMapper.MAPPER.mapToProductDto(product);
        return productDto;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        ProductEntity product = ProductMapper.MAPPER.mapToProductEntity(productDto);
        ProductEntity saveProduct = productRepository.save(product);
        return ProductMapper.MAPPER.mapToProductDto(saveProduct);
    }

    @Override
    public ResultResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<ProductEntity> products = productRepository.findAll(pageable);
        List<ProductEntity> listOfProducts = products.getContent();
        List<ProductDto> contents = listOfProducts.stream()
                .map(product -> ProductMapper.MAPPER.mapToProductDto(product)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(products.getNumber());
        resultResponse.setPageSize(products.getSize());
        resultResponse.setTotalElements(products.getTotalElements());
        resultResponse.setTotalPages(products.getTotalPages());
        resultResponse.setLast(products.isLast());
        return resultResponse;
    }

    @Override
    public List<ProductDto> getAllProductsByCate(Long cate) {
        CategoriesEntity categories = categoriesRepository.findCategoriesEntityById(cate).orElse(null);
        if(categories == null){
            return null;
        }
        List<ProductEntity> entityList = productRepository.getByCate(categories.getId());
        return entityList.stream()
                .map(product -> ProductMapper.MAPPER.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getPronews() {
        List<ProductEntity> pronews = productRepository.getProNews();
        return pronews.stream()
                .map(product -> ProductMapper.MAPPER.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ResultResponse search(Long minPrice, Long maxPrice, String categoryName,
                                 String brand,String sortDir,String sortBy,int pageNo, int pageSize) {
        Specification<ProductEntity> specification = ProductSpecificatons
                .joinCategory(minPrice, maxPrice, categoryName, brand);
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<ProductEntity> products = productRepository.findAll(specification, pageable);
        List<ProductEntity> listOfProducts = products.getContent();
        List<ProductDto> contents = listOfProducts.stream()
                .map(product -> ProductMapper.MAPPER.mapToProductDto(product)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(products.getNumber());
        resultResponse.setPageSize(products.getSize());
        resultResponse.setTotalElements(products.getTotalElements());
        resultResponse.setTotalPages(products.getTotalPages());
        resultResponse.setLast(products.isLast());
        return resultResponse;
    }

    @Override
    public ResultResponse search1(String title, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<ProductEntity> products = productRepository.searchProductEntityByTitle(title,pageable);
        List<ProductEntity> productList = products.getContent();
        List<ProductDto> contents = productList.stream()
                .map((product)->ProductMapper.MAPPER.mapToProductDto(product)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(products.getNumber());
        resultResponse.setPageSize(products.getSize());
        resultResponse.setTotalElements(products.getTotalElements());
        resultResponse.setTotalPages(products.getTotalPages());
        resultResponse.setLast(products.isLast());
        return resultResponse;
    }

    @Override
    public ProductDto createProduct(ProductRequest productDto, MultipartFile avatar) throws IOException {
        ProductEntity product = new ProductEntity();
        if(productDto.getId()!=null){
            product = productRepository.findById(productDto.getId()).get();
        }
        if(!avatar.isEmpty()){
            String uploadDir = "upload/product/avatar/";
            if (!Files.exists(Paths.get(uploadDir))) {
                Files.createDirectories(Paths.get(uploadDir));
            }
            String avatarPath = product.getAvatar();
            if(avatarPath != null && !avatarPath.isEmpty()){
                Files.deleteIfExists(Paths.get(avatarPath));
            }
            String filename = avatar.getOriginalFilename();
            String[] name = filename.split("\\.");
            String randomID = UUID.randomUUID().toString();
            filename = productDto.getTitle()+randomID+"."+name[1];
            Path filePath = Paths.get(uploadDir,filename);
            Files.copy(avatar.getInputStream(),filePath);

            product.setAvatar(filePath.toString());
        }
        product.setTitle(productDto.getTitle());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setDiscount(productDto.getDiscount());
        product.setQuantity(productDto.getQuantity());
        product.setSymbol(productDto.getSymbol());
        product.setDetails(productDto.getDetails());
        product.setPin(productDto.getPin());
        product.setRom(productDto.getRom());
        product.setRam(productDto.getRam());
        product.setKTmanHinh(productDto.getKTmanHinh());
        product.setCPU(productDto.getCPU());
        product.setCameraTruoc(productDto.getCameraTruoc());
        product.setCameraSau(productDto.getCameraSau());
        product.setCategories(categoriesRepository.findById(productDto.getCategories()).get());
        ProductEntity product1 = productRepository.save(product);
        return ProductMapper.MAPPER.mapToProductDto(product1);
    }
}
