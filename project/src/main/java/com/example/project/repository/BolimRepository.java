package com.example.project.repository;

import com.example.project.entity.Bolim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolimRepository extends JpaRepository<Bolim,Long> {
}
