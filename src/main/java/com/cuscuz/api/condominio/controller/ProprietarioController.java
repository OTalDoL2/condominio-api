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

import com.cuscuz.api.condominio.entity.Proprietario;
import com.cuscuz.api.condominio.service.ProprietarioService;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {
    @Autowired
    ProprietarioService proprietarioService;

    @GetMapping
    public List<Proprietario> buscarProprietarios(){
        return proprietarioService.buscarProprietarios();
    }

    @GetMapping("/{id}")
    public Proprietario buscarProprietarioPeloId(@PathVariable Long id){
        return proprietarioService.buscarProprietarioPeloId(id);
    }

    // @GetMapping("/propriedades/{id}")
    // public Proprietario buscarPropriedades(@PathVariable Long id){
    //     return proprietarioService.buscarProprietarioPeloId(id);
    // }


    @PostMapping
    public Proprietario cadastrarProprietario(@RequestBody Proprietario contrato){
        System.out.println("Se liga que chegou aqui " + contrato);
        return proprietarioService.cadastrarProprietario(contrato);
    }

    @PutMapping("/{id}")
    public Proprietario atualizarProprietario(@PathVariable Long id, @RequestBody Proprietario contrato){
        return proprietarioService.atualizarProprietario(id, contrato);
    }

    @DeleteMapping("/{id}")
    public void deletarProprietario(@PathVariable Long id){
        proprietarioService.deletarProprietario(id);
    }



}
