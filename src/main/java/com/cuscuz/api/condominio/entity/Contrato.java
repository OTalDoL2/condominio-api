package com.cuscuz.api.condominio.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataEntrada;
    private Date dataTermino = null;
    private int tempoContratoMeses;
    private String status = null;
    private Long inquilinoId;
    private Long residenciaId;
    private Long proprietarioId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public Date getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    public int getTempoContratoMeses() {
        return tempoContratoMeses;
    }
    public void setTempoContratoMeses(int tempoContratoMeses) {
        this.tempoContratoMeses = tempoContratoMeses;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Long getInquilinoId() {
        return inquilinoId;
    }
    public void setInquilinoId(Long inquilinoId) {
        this.inquilinoId = inquilinoId;
    }
    public Long getResidenciaId() {
        return residenciaId;
    }
    public void setResidenciaId(Long residenciaId) {
        this.residenciaId = residenciaId;
    }
    public Long getProprietarioId() {
        return proprietarioId;
    }
    public void setProprietarioId(Long proprietarioId) {
        this.proprietarioId = proprietarioId;
    }
    
}
