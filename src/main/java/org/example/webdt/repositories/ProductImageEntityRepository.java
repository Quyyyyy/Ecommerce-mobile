package org.example.webdt.repositories;

import org.example.webdt.entities.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageEntityRepository extends JpaRepository<ProductImageEntity,Long> {
}
