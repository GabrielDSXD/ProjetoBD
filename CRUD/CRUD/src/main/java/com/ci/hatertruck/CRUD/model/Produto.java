package com.ci.hatertruck.CRUD.model;

public class Produto {
	private int idProduto;
	private String nome;
	private float preco;
	private CategoriaProduto categoria;
	private boolean fab_mari;
	private int quantidade;



	public enum CategoriaProduto {
		COMPUTADOR, NOTEBOOK, MONITOR, PROCESSADOR, MEMORIA, PLACA_DE_VIDEO, ARMAZENAMENTO,
		GABINETE, FONTE, MOUSE, TECLADO, DIVERSOS
	}

	public Produto(String nome, float preco, CategoriaProduto categoria, boolean fab_mari, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.fab_mari = fab_mari;
		this.quantidade = quantidade;
	}

	// Getters e Setters

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public boolean isfab_mari() {
		return fab_mari;
	}

	public void setfab_mari(boolean fab_mari) {
		this.fab_mari = fab_mari;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"idProduto=" + idProduto +
				", nome='" + nome + '\'' +
				", preco=" + preco +
				", categoria=" + categoria +
				", fab_mari=" + fab_mari +
				", quantidade=" + quantidade +
				'}';
	}
}
