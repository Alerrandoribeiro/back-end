package com.veiculo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// aqui vai ser o espelho do banco de dadas, nesta classe.
@Entity
@Table(name = "fabricante") // Não é obrigatório
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // com se fosse o auto_increment
    private Long id; // chave primária

    @Column(nullable = false, unique = true, length = 100) // Not null, único, tamanho varchar(100) 
    private String nome;

    @Column(name = "pais_origem",nullable = false, length = 50)
    private String paisOrigem;

     // criando get e set 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }
    
    // criando construtor vazio
    public Fabricante() {
    }

    // criando construtor
    public Fabricante(Long id, String nome, String paisOrigem) {
        this.id = id;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
    }

    @Override
    public String toString() {
        return "Fabricante [id=" + id + ", nome=" + nome + ", paisOrigem=" + paisOrigem + "]";
    }
    
    
}
