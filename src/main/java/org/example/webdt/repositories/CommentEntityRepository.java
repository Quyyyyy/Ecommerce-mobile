package org.example.webdt.repositories;

import org.example.webdt.entities.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity,Long> {
    @Query(value="SELECT * FROM comments WHERE product_id = :id ORDER BY updated DESC",nativeQuery = true)
    Page<CommentEntity> findCommentEntitiesByProductId(@Param("id") Long id, Pageable pageable);
}
