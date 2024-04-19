package com.ci.hatertruck.CRUD.model;

// Classe Java equivalente para a tabela SQL 'vendedor'
public class Vendedor {
    private String cpfVendedor;
    private String primeiroNome;
    private String ultimoNome;
    private String senha;

    // Construtor
    public Vendedor(String cpfVendedor, String primeiroNome, String ultimoNome, String senha) {
        this.cpfVendedor = cpfVendedor;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.senha = senha;
    }

    // Getters e Setters
    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(String cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
