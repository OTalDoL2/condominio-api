package com.cuscuz.api.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuscuz.api.condominio.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    
}
