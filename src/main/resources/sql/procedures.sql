CREATE OR REPLACE PROCEDURE InserirCliente(
    IN cpf_cliente_param VARCHAR(11),
    IN prim_nome_param VARCHAR(20),
    IN ult_nome_param VARCHAR(30),
    IN senha_param VARCHAR(100),
    IN is_flamengo_param BOOLEAN,
    IN one_piece_fan_param BOOLEAN,
    IN sousense_param BOOLEAN,
    OUT novo_cliente_cpf VARCHAR(11)
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Cliente (cpf_cliente, prim_nome, ult_nome, senha, is_flamengo, one_piece_fan, sousense)
    VALUES (cpf_cliente_param, prim_nome_param, ult_nome_param, senha_param, is_flamengo_param, one_piece_fan_param, sousense_param);

    novo_cliente_cpf := cpf_cliente_param; -- Pass the input CPF back as output directly

EXCEPTION
    WHEN OTHERS THEN
        RAISE NOTICE 'Error occurred: %', SQLERRM;
        novo_cliente_cpf := NULL; -- set output as NULL to indicate failure
END;
$$;

CREATE PROCEDURE AtualizarCliente(
    IN cpf_cliente_param VARCHAR(11),
    IN prim_nome_param VARCHAR(20),
    IN ult_nome_param VARCHAR(30),
    IN senha_param VARCHAR(100),
    IN is_flamengo_param BOOLEAN,
    IN one_piece_fan_param BOOLEAN,
    IN sousense_param BOOLEAN
)
BEGIN ATOMIC
    UPDATE Cliente
    SET prim_nome = prim_nome_param,
        ult_nome = ult_nome_param,
        senha = senha_param,
        is_flamengo = is_flamengo_param,
        one_piece_fan = one_piece_fan_param,
        sousense = sousense_param
    WHERE cpf_cliente = cpf_cliente_param;
END;

CREATE OR REPLACE PROCEDURE InserirVendedor(
    IN cpf_vendedor_param VARCHAR(11),
    IN prim_nome_param VARCHAR(20),
    IN ult_nome_param VARCHAR(30),
    IN senha_param VARCHAR(100),
    OUT novo_vendedor_cpf VARCHAR(11)
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO vendedor (cpf_vendedor, prim_nome, ult_nome, senha)
    VALUES (cpf_vendedor_param, prim_nome_param, ult_nome_param, senha_param)
    RETURNING cpf_vendedor INTO novo_vendedor_cpf;

EXCEPTION
    WHEN OTHERS THEN
        RAISE NOTICE 'Error occurred: %', SQLERRM;
        novo_vendedor_cpf := NULL;
END;
$$;

CREATE OR REPLACE PROCEDURE AtualizarVendedor(
    IN cpf_vendedor_param VARCHAR(11),
    IN prim_nome_param VARCHAR(20),
    IN ult_nome_param VARCHAR(30),
    IN senha_param VARCHAR(100)
)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE vendedor
    SET prim_nome = prim_nome_param,
        ult_nome = ult_nome_param,
        senha = senha_param
    WHERE cpf_vendedor = cpf_vendedor_param;

EXCEPTION
    WHEN OTHERS THEN
        RAISE NOTICE 'Error occurred: %', SQLERRM;
END;
$$;


CREATE PROCEDURE ConsultarRelatorioVendas(
    IN cpf_vendedor_param VARCHAR(11),
    IN mes_param SMALLINT,
    IN ano_param SMALLINT
)	
BEGIN ATOMIC
    SELECT metodo_pgmt, valor_total
    FROM compra
    WHERE cpf_vendedor = cpf_vendedor_param
        AND mes = mes_param
        AND ano = ano_param;
END;

CREATE PROCEDURE CriarProduto(
    IN nome_param VARCHAR(255),
    IN preco_param DECIMAL(10, 2),
    IN categoria_param categoria_type,
    IN fab_Mari_param BOOLEAN,
    IN qtd_produto_param INT
)
BEGIN ATOMIC
    INSERT INTO Produto (nome, preco, categoria, fab_Mari, qtd_produto)
    VALUES (nome_param, preco_param, categoria_param, fab_Mari_param, qtd_produto_param);
END;

CREATE PROCEDURE AtualizarProduto(
    IN id_produto_param INT,
    IN nome_param VARCHAR(255),
    IN preco_param DECIMAL(10, 2),
    IN categoria_param categoria_type,
    IN fab_Mari_param BOOLEAN,
    IN qtd_produto_param INT
)
BEGIN ATOMIC
    UPDATE Produto
    SET nome = nome_param,
        preco = preco_param,
        categoria = categoria_param,
        fab_Mari = fab_Mari_param,
        qtd_produto = qtd_produto_param
    WHERE id_produto = id_produto_param;
END;
