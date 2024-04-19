package com.ci.hatertruck.CRUD.model;

// Classe Java equivalente para a tabela SQL 'compra_produto'
public class Compra_produto {
    private int idCompra;
    private int idProduto;
    private int quantidade;

    // Construtor
    public Compra_produto(int idCompra, int idProduto, int quantidade) {
        this.idCompra = idCompra;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

