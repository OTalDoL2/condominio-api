package com.cuscuz.api.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuscuz.api.condominio.entity.Residencia;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Long>{
    
}
