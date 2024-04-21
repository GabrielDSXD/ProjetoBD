package com.hatertruck.RedeBaratto.model;

public class Compra {
    private int idCompra;
    private String cpfCliente;
    private String cpfVendedor;
    private int dia;
    private int mes;
    private int ano;
    private MetodoPagamento metodoPagamento;
    private boolean status;
    private float valorTotal;

    public enum MetodoPagamento {
        PIX, CARTAO, BOLETO, BERRIES
    }
    
    public Compra() {
    }

    public Compra(int idCompra, String cpfCliente, String cpfVendedor, int dia, int mes, int ano,
                  MetodoPagamento metodoPagamento, boolean status, float valorTotal) {
        this.idCompra = idCompra;
        this.cpfCliente = cpfCliente;
        this.cpfVendedor = cpfVendedor;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
        this.valorTotal = valorTotal;
    }
    
	  public Compra(int idCompra, int dia, int mes, int ano) {
	  this.idCompra = idCompra;
	  this.dia = dia;
	  this.mes = mes;
	  this.ano = ano;
	  this.status = false;
	  this.valorTotal = 0;
	}

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(String cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}