package org.example.webdt.repositories;

import org.example.webdt.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity ,Long>,
        JpaSpecificationExecutor<ProductEntity> {
    @Query(value = "SELECT * FROM products WHERE category_id = :id LIMIT 0,4", nativeQuery = true)
    List<ProductEntity> getByCate(@Param("id") Long id);
    @Query(value = "SELECT * FROM products ORDER BY updated DESC LIMIT 0,4", nativeQuery = true)
    List<ProductEntity> getProNews();
    @Query(value="SELECT p FROM ProductEntity p WHERE p.title LIKE %:title% OR p.categories.name LIKE %:title% " +
            "OR p.details LIKE %:title% OR p.brand LIKE %:title%")
    Page<ProductEntity> searchProductEntityByTitle(String title, Pageable pageable);
}
