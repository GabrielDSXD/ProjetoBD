package com.ci.hatertruck.CRUD.model;

// Classe Java equivalente para a tabela SQL 'telefone'
public class Telefone {
    private String numeroTelefone;
    private String cpfCliente;

    // Construtor
    public Telefone(String numeroTelefone, String cpfCliente) {
        this.numeroTelefone = numeroTelefone;
        this.cpfCliente = cpfCliente;
    }

    // Getters e Setters
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}
