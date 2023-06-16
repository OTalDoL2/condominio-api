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

import com.cuscuz.api.condominio.entity.Inquilino;
import com.cuscuz.api.condominio.service.InquilinoService;

@RestController
@RequestMapping("/inquilino")
public class InquilinoController {
    @Autowired
    InquilinoService inquilinoService;

    @GetMapping
    public List<Inquilino> buscarInquilinos(){
        return inquilinoService.buscarInquilinos();
    }

    @GetMapping("/{id}")
    public Inquilino buscarInquilinoPeloId(@PathVariable Long id){
        return inquilinoService.buscarInquilinoPeloId(id);
    }

    @PostMapping
    public Inquilino cadastrarInquilino(@RequestBody Inquilino contrato){
        return inquilinoService.cadastrarInquilino(contrato);
    }

    @PutMapping("/{id}")
    public Inquilino atualizarInquilino(@PathVariable Long id, @RequestBody Inquilino contrato){
        return inquilinoService.atualizarInquilino(id, contrato);
    }

    @DeleteMapping("/{id}")
    public void deletarInquilino(@PathVariable Long id){
        inquilinoService.deletarInquilino(id);
    }



}
