package com.cuscuz.api.condominio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuscuz.api.condominio.entity.Residencia;
import com.cuscuz.api.condominio.repository.ResidenciaRepository;
import com.cuscuz.api.condominio.service.ResidenciaService;

@RestController
@RequestMapping("/residencia")
public class ResidenciaController {
    @Autowired
    ResidenciaService residenciaService;
    
    @Autowired
    ResidenciaRepository residenciaRepository;

    @GetMapping("/{id}")
    public Residencia buscarResidencia(@PathVariable Long id) {
        return residenciaService.buscarResidencia(id);
    }
    
    @GetMapping
    public List<Residencia> todasAsResidencias() {
        return residenciaRepository.findAll();
    }

    @PostMapping
    public Residencia cadastrarResidencia(@RequestBody Residencia residencia){
        return residenciaService.cadastrarResidencia(residencia);
    }

    @PutMapping("/{id}")
    public Residencia atualizarResidencia(@PathVariable Long id, @RequestBody Residencia residencia){
        return residenciaService.atualizarResidencia(id,residencia);
    }

    @DeleteMapping("/{id}")
    public void excluirResidencia(@PathVariable Long id){
        residenciaService.excluirResidencia(id);
    }
}
