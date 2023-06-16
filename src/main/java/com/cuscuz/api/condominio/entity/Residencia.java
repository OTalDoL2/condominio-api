package com.cuscuz.api.condominio.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Residencia")
public class Residencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private int numero;
	private String bloco;
    private boolean disponibilidade = true;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getBloco() {
        return bloco;
    }
    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    

}
