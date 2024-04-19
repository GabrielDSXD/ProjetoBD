package com.ci.hatertruck.CRUD.model;

public class Cliente {
    private String cpf;
    private String primeiroNome;
    private String ultimoNome;
    private String senha;
    private boolean isFlamengo;
    private boolean onePieceFan;
    private boolean sousense;

    public Cliente(String cpf, String primeiroNome, String ultimoNome, String senha,
                   boolean isFlamengo, boolean onePieceFan, boolean sousense) {
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.senha = senha;
        this.isFlamengo = isFlamengo;
        this.onePieceFan = onePieceFan;
        this.sousense = sousense;
    }

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public boolean isFlamengo() {
        return isFlamengo;
    }

    public void setFlamengo(boolean flamengo) {
        isFlamengo = flamengo;
    }

    public boolean isOnePieceFan() {
        return onePieceFan;
    }

    public void setOnePieceFan(boolean onePieceFan) {
        this.onePieceFan = onePieceFan;
    }

    public boolean isSousense() {
        return sousense;
    }

    public void setSousense(boolean sousense) {
        this.sousense = sousense;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", senha='" + senha + '\'' +
                ", isFlamengo=" + isFlamengo +
                ", onePieceFan=" + onePieceFan +
                ", sousense=" + sousense +
                '}';
    }
}
