package com.cuscuz.api.condominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuscuz.api.condominio.entity.Contrato;
import com.cuscuz.api.condominio.repository.ContratoRepository;

@Service
public class ContratoService {
    @Autowired
    ContratoRepository contratoRepository;

    public Contrato visualizarContrato(Long id){
        return contratoRepository.findById(id).orElse(null);
    }

    public Contrato criarContrato(Contrato novContrato){
        return contratoRepository.save(novContrato);
    }

    public Contrato atualizaContrato(Long id, Contrato contrato){
        contrato.setId(id);
        return contratoRepository.save(contrato);
    }

    public void excluiContrato(Long id){
        contratoRepository.deleteById(id);
    }
}
