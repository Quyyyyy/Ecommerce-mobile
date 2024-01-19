package org.example.webdt.repositories;

import org.example.webdt.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    @Query(value = "SELECT COUNT(*) FROM users",nativeQuery = true)
    Long getToTalUser();
    Optional<UserEntity> findByUsernameOrEmail(String username, String email);
}
