package com.cuscuz.api.condominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuscuz.api.condominio.entity.Inquilino;
import com.cuscuz.api.condominio.repository.InquilinoRepository;

@Service
public class InquilinoService {
    @Autowired
    private InquilinoRepository inquilinoRepository;

    public List<Inquilino> buscarInquilinos() {
        return inquilinoRepository.findAll();
    }

    public Inquilino buscarInquilinoPeloId(Long id) {
        return inquilinoRepository.findById(id).orElse(null);
    }

    public Inquilino cadastrarInquilino(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    public Inquilino atualizarInquilino(Long id, Inquilino inquilino) {
        inquilino.setId(id);
        return inquilinoRepository.save(inquilino);
    }

    public void deletarInquilino(Long id) {
        inquilinoRepository.deleteById(id);
    }
}
