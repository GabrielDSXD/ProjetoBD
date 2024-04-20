package com.hatertruck.RedeBaratto.model;

import java.util.Date;

public class Relatorio {
    private Integer codigo;
    private Integer codigoLoja;
    private Float faturamento;
    private Integer estoque;
    private Date data;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigoLoja() {
		return codigoLoja;
	}

	public void setCodigoLoja(Integer codigoLoja) {
		this.codigoLoja = codigoLoja;
	}

	public Float getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Float faturamento) {
		this.faturamento = faturamento;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}