package com.hatertruck.RedeBaratto.model;

import java.math.BigDecimal;

public class Compra {
    private int idCompra;
    private String cpfCliente;
    private String cpfVendedor;
    private int dia;
    private int mes;
    private int ano;
    private MetodoPagamento metodoPagamento;
    private StatusCompra status;
    private BigDecimal valorTotal;

    public enum MetodoPagamento {
        PIX, CARTAO, BOLETO, BERRIES
    }

    public enum StatusCompra {
        PAGO, NAO_PAGO
    }

    public Compra(int idCompra, String cpfCliente, String cpfVendedor, int dia, int mes, int ano,
                  MetodoPagamento metodoPagamento, StatusCompra status, BigDecimal valorTotal) {
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

    public StatusCompra getStatus() {
        return status;
    }

    public void setStatus(StatusCompra status) {
        this.status = status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}