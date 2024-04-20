package com.hatertruck.RedeBaratto.model;

import java.util.Date;
import java.util.List;

public class RelatorioVendedor {
	private int idVendedor;
	private float valorVendido;
	private Date dataRelatorio;
	private List<Integer> vendas;
	
	public RelatorioVendedor(int idVendedor, float valorVendido, Date dataRelatorio, List<Integer> vendas) {
		super();
		this.idVendedor = idVendedor;
		this.valorVendido = valorVendido;
		this.dataRelatorio = dataRelatorio;
		this.vendas = vendas;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public float getValorVendido() {
		return valorVendido;
	}

	public void setValorVendido(float valorVendido) {
		this.valorVendido = valorVendido;
	}

	public Date getDataRelatorio() {
		return dataRelatorio;
	}

	public void setDataRelatorio(Date dataRelatorio) {
		this.dataRelatorio = dataRelatorio;
	}

	public List<Integer> getVendas() {
		return vendas;
	}

	public void setVendas(List<Integer> vendas) {
		this.vendas = vendas;
	}
}
