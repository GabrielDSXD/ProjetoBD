package com.ci.hatertruck.CRUD.model;

public class Produto {
	private Integer codigo;
	private String nome;
	private Float preco;
	private String descricao;
	
	public Produto() {}
	
	public Produto(String nome, String descricao, Float preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		
	}

	public Produto(Integer codigo, String nome, String descricao, Float preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer id) {
		this.codigo = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
