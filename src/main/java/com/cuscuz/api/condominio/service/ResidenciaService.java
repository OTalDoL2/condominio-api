package com.cuscuz.api.condominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.spel.ExpressionDependencies;
import org.springframework.stereotype.Service;

import com.cuscuz.api.condominio.entity.Residencia;
import com.cuscuz.api.condominio.repository.ResidenciaRepository;

@Service
public class ResidenciaService {
    @Autowired
    ResidenciaRepository residenciaRepository;
    
    public Residencia buscarResidencia(Long id) {
        return residenciaRepository.findById(id).orElse(null);
    }

    public Residencia cadastrarResidencia(Residencia residencia) {
        return residenciaRepository.save(residencia);
    }

    public Residencia atualizarResidencia(Long id, Residencia residencia) {
        residencia.setId(id);
        return residenciaRepository.save(residencia);
    }

    public void excluirResidencia(Long id) {
        residenciaRepository.deleteById(id);
    }
}
