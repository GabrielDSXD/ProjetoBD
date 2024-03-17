CREATE DATABASE hatertruck;

USE hatertruck;

CREATE TABLE produtos(
	codigo SERIAL PRIMARY KEY,
	nome VARCHAR(20) NOT NULL,
	descricao VARCHAR(30) NOT NULL,
	preco FLOAT NOT NULL
);

CREATE TABLE relatorios (
    codigo SERIAL PRIMARY KEY,
    codigo_loja INT NOT NULL,
    faturamento FLOAT NOT NULL,
    estoque INT NOT NULL,
    data DATE NOT NULL
);