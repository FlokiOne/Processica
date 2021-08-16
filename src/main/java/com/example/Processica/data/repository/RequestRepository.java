package com.example.Processica.data.repository;

import com.example.Processica.data.entity.ERequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<ERequest, String> {
}
