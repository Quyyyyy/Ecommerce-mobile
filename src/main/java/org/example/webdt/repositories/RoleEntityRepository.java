package org.example.webdt.repositories;

import org.example.webdt.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByName(String name);
}
