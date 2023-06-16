package com.cuscuz.api.condominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuscuz.api.condominio.entity.Proprietario;
import com.cuscuz.api.condominio.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public List<Proprietario> buscarProprietarios() {
        return proprietarioRepository.findAll();
    }

    public Proprietario buscarProprietarioPeloId(Long id) {
        return proprietarioRepository.findById(id).orElse(null);
    }

    public Proprietario cadastrarProprietario(Proprietario Proprietario) {
        return proprietarioRepository.save(Proprietario);
    }

    public Proprietario atualizarProprietario(Long id, Proprietario Proprietario) {
        Proprietario.setId(id);
        return proprietarioRepository.save(Proprietario);
    }

    public void deletarProprietario(Long id) {
        proprietarioRepository.deleteById(id);
    }
}
