package com.example.Modifier.repository;

import com.example.Modifier.entity.SkObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SKRepository extends JpaRepository<SkObject, Integer> {
}
