package org.example.webdt.services;

import jakarta.persistence.criteria.JoinType;
import org.example.webdt.entities.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

public interface ProductSpecificatons {
    static Specification<ProductEntity> joinCategory(Long minPrice, Long maxPrice, String categoryName, String brand){
        return (root, query, criteriaBuilder) -> {
            // Thực hiện join với bảng category
            root.join("categories", JoinType.INNER);

            // Tạo các điều kiện
            Specification<ProductEntity> priceCondition = (minPrice != null) ?
                    (rootPrice, queryPrice, cbPrice) -> cbPrice.greaterThanOrEqualTo(rootPrice.get("discount"), minPrice) : null;
            Specification<ProductEntity> maxPriceCondition = (maxPrice != null) ?
                    (rootMaxPrice, queryMaxPrice, cbMaxPrice) -> cbMaxPrice.lessThanOrEqualTo(rootMaxPrice.get("discount"), maxPrice) : null;
            Specification<ProductEntity> categoryCondition =
                    (categoryName != null) ? (rootCategory, queryCategory, cbCategory) -> cbCategory.equal(rootCategory.get("categories").get("name"), categoryName) : null;
            Specification<ProductEntity> brandCondition =
                    (brand != null) ? (rootBrand, queryBrand, cbBrand) -> cbBrand.equal(rootBrand.get("brand"), brand) : null;

            // Tạo Specification cuối cùng bằng cách kết hợp các điều kiện
            Specification<ProductEntity> finalSpecification = Specification.where(priceCondition)
                    .and(maxPriceCondition)
                    .and(categoryCondition)
                    .and(brandCondition);

            // Thêm điều kiện sắp xếp
            query.orderBy(criteriaBuilder.asc(root.get("price")));

            // Trả về điều kiện cuối cùng
            return finalSpecification.toPredicate(root, query, criteriaBuilder);
        };
    }
}
