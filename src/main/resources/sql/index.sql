--Tabela Cliente:
CREATE INDEX idx_one_piece_fan ON Cliente (one_piece_fan); --filtrar quem é fã do GOAT
CREATE INDEX idx_sousense ON Cliente (sousense);

--Tabela Produto:
CREATE INDEX idx_nome_produto ON Produto (nome);
CREATE INDEX idx_categoria ON Produto (categoria);
CREATE INDEX idx_fab_Mari ON Produto (fab_Mari);

--Tabela Compra:
CREATE INDEX idx_cpf_cliente_compra ON Compra (cpf_cliente);
CREATE INDEX idx_dia_mes_ano_compra ON Compra (dia, mes, ano);
CREATE INDEX idx_status_compra ON Compra (status_pago);
