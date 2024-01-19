package org.example.webdt.repositories;

import org.example.webdt.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesEntityRepository extends JpaRepository<CategoriesEntity,Long> {
    Optional<CategoriesEntity> findCategoriesEntityById(Long id);
}
