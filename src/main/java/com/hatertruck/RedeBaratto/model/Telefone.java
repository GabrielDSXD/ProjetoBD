package com.hatertruck.RedeBaratto.model;

public class Telefone {
    private String numeroTelefone;
    private String cpfCliente;

    public Telefone(String numeroTelefone, String cpfCliente) {
        this.numeroTelefone = numeroTelefone;
        this.cpfCliente = cpfCliente;
    }

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