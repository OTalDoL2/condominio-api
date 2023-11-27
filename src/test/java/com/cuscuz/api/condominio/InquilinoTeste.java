package com.cuscuz.api.condominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.cuscuz.api.condominio.entity.Inquilino;
import com.cuscuz.api.condominio.repository.InquilinoRepository;

public class InquilinoTeste {
    @Autowired
    private InquilinoRepository repository;

    @Test
    @AutoConfigureTestDatabase(replace = Replace.NONE)
    public void testCriarInquilino(){
        criarInquilino("null", "null");
    }

    @Test
    void testCriarInquilinoComNomeNulo(String nome) {
        try {
            if(nome == null)
                fail("O código não levantou a exceção IllegalArgumentException");
        } 
        catch (IllegalArgumentException e) {
            assertEquals("O campo nome é obrigatório", e.getMessage());
        }
    }

    @Test
    void testCriarInquilinoComCPFNulo(String cpf) {
        try {
            if(cpf == null)
                fail("O código não levantou a exceção IllegalArgumentException");
        } 
        catch (IllegalArgumentException e) {
            assertEquals("O campo nome é obrigatório", e.getMessage());
        }
    }

    @Test
    void validaInquilinoDadosNulos(String nome, String cpf){
        testCriarInquilinoComNomeNulo(nome);
        testCriarInquilinoComCPFNulo(cpf);

    }

    @Test
    public Inquilino criarInquilino(String nome, String cpf){

        try {
            validaInquilinoDadosNulos(nome, cpf);
            Inquilino Inquilino = new Inquilino(nome, cpf);
            repository.save(Inquilino);

            return Inquilino;

        } 
        
        catch (Exception e) {
            return null;
        }
        
    }    
}
