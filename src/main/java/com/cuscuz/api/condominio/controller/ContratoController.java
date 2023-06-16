package com.cuscuz.api.condominio.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

import com.cuscuz.api.condominio.entity.Contrato;
import com.cuscuz.api.condominio.entity.Inquilino;
import com.cuscuz.api.condominio.entity.Proprietario;
import com.cuscuz.api.condominio.entity.Residencia;
import com.cuscuz.api.condominio.service.ContratoService;
import com.cuscuz.api.condominio.service.InquilinoService;
import com.cuscuz.api.condominio.service.ProprietarioService;
import com.cuscuz.api.condominio.service.ResidenciaService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
    @Autowired
    private ContratoService contratoService;
    @Autowired
    private ResidenciaService residenciaService;
    @Autowired
    private ProprietarioService proprietarioService;
    @Autowired
    private InquilinoService inquilinoService;

    @GetMapping("/{id}")
    public Contrato visualizarContrato(@PathVariable Long id){
        return contratoService.visualizarContrato(id);
    }

    @GetMapping("fim-contrato/{id}")
    public Contrato finalizarContrato(@PathVariable Long id){
        Contrato contrato = contratoService.visualizarContrato(id);
        
        LocalDate dataAtual = LocalDate.now();
        Date dataAtualDate = java.sql.Date.valueOf(dataAtual);

        contrato.setDataTermino(dataAtualDate);
        contrato.setStatus("Finalizado");


        Residencia residencia = residenciaService.buscarResidencia(contrato.getResidenciaId());
        Proprietario proprietario = proprietarioService.buscarProprietarioPeloId(contrato.getProprietarioId());
        Inquilino inquilino = inquilinoService.buscarInquilinoPeloId(contrato.getInquilinoId());
        
        residencia.setDisponibilidade(true);
        

        proprietario.getIdContratos().remove(id);
        proprietarioService.atualizarProprietario(proprietario.getId(), proprietario);
        
        inquilino.setIdContrato(null);
        inquilinoService.atualizarInquilino(inquilino.getId(), inquilino);

        return contratoService.atualizaContrato(id, contrato);
    }

    @PostMapping
    public Contrato cadastrarContrato(@RequestBody Contrato contrato){
        Residencia residencia = residenciaService.buscarResidencia(contrato.getResidenciaId());
        Proprietario proprietario = proprietarioService.buscarProprietarioPeloId(contrato.getProprietarioId());
        Inquilino inquilino = inquilinoService.buscarInquilinoPeloId(contrato.getInquilinoId());
        
        if(residencia.isDisponibilidade()) {

            residencia.setDisponibilidade(false);
            
            contrato.setInquilinoId(inquilino.getId());
            contrato.setProprietarioId(proprietario.getId());
            contrato.setResidenciaId(residencia.getId());
            contrato.setStatus("Alocado");

            Contrato contratoCriado = contratoService.criarContrato(contrato);

            locacao(inquilino, proprietario, contratoCriado.getId());    
            
            return contratoCriado; 
        } else{
            return null;
        }
    }

    @PutMapping("/{id}")
    public Contrato atualizaContrato(@PathVariable Long id, @RequestBody Contrato contrato){

        return contratoService.atualizaContrato(id, contrato);
    }

    @DeleteMapping("/{id}")
    public void excluirContrato(@PathVariable Long id){
        contratoService.excluiContrato(id);
    }

    public void locacao(Inquilino inquilino, Proprietario proprietario, Long id_contrato){
        List<Long> contratoIds = new ArrayList<>();
        contratoIds.add(id_contrato);
        proprietario.setIdContratos(contratoIds);
        proprietarioService.atualizarProprietario(proprietario.getId(), proprietario);
        
        inquilino.setIdContrato(id_contrato);
        inquilinoService.atualizarInquilino(inquilino.getId(), inquilino);
    }

    
}
