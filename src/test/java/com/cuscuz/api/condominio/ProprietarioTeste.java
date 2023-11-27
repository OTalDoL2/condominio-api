package com.cuscuz.api.condominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cuscuz.api.condominio.entity.Proprietario;
import com.cuscuz.api.condominio.repository.ProprietarioRepository;

@DataJpaTest
public class ProprietarioTeste {
    @Autowired
    private ProprietarioRepository repository;

    // @Test
    // @AutoConfigureTestDatabase(replace = Replace.NONE)
    // public boolean cpfValidation(String cpf){
        
    //     if(cpf.length() < 11 || cpf.length() > 11){
    //         assert(false);
    //         return false;
    //     }
        
        
    //     int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
    //     int soma = 0;

    //     for (int i = 0; i < 9; i++) {
    //         soma += cpf.charAt(i) * pesos[i];
    //     }

    //     int resto = soma % 11;
    //     System.out.println(resto);

    //     if(cpf.charAt(9) == (11 - resto)){
    //         assert(false);
    //         return false;    
    //     }
    //     else {
    //         return true;
    //     }

    //     // return false || true ? cpf.charAt(9) == '0' : cpf.charAt(9) == (11 - resto);
    // }
    @Test
    @AutoConfigureTestDatabase(replace = Replace.NONE)
    public void testCriarProprietario(){
        criarProprietario("null", "null");
    }

    @Test
    void testCriarProprietarioComNomeNulo(String nome) {
        try {
            if(nome == null)
                fail("O código não levantou a exceção IllegalArgumentException");
        } 
        catch (IllegalArgumentException e) {
            assertEquals("O campo nome é obrigatório", e.getMessage());
        }
    }

    @Test
    void testCriarProprietarioComCPFNulo(String cpf) {
        try {
            if(cpf == null)
                fail("O código não levantou a exceção IllegalArgumentException");
        } 
        catch (IllegalArgumentException e) {
            assertEquals("O campo nome é obrigatório", e.getMessage());
        }
    }

    @Test
    void validaProprietarioDadosNulos(String nome, String cpf){
        testCriarProprietarioComNomeNulo(nome);
        testCriarProprietarioComCPFNulo(cpf);

    }

    @Test
    public Proprietario criarProprietario(String nome, String cpf){

        try {
            validaProprietarioDadosNulos(nome, cpf);
            Proprietario proprietario = new Proprietario(nome, cpf);
            repository.save(proprietario);

            return proprietario;

        } 
        
        catch (Exception e) {
            return null;
        }
        
    }
}
