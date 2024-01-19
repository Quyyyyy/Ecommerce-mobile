package org.example.webdt.repositories;

import org.example.webdt.entities.FeedBackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackEntityRepository extends JpaRepository<FeedBackEntity,Long> {
}
