CREATE OR REPLACE FUNCTION ConsultarClientePorCPF(
    cpf_cliente_param VARCHAR(11)
)
RETURNS SETOF Cliente  -- Change the return type as needed
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY SELECT * FROM Cliente WHERE cpf_cliente = cpf_cliente_param;
END;
$$;

CREATE OR REPLACE FUNCTION ConsultarVendedorPorCPF(
    cpf_vendedor_param VARCHAR(11)
)
RETURNS SETOF Vendedor
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY SELECT * FROM vendedor WHERE cpf_vendedor = cpf_vendedor_param;
END;
$$;



CREATE OR REPLACE FUNCTION CriarCompraFunc(
    IN cpf_cliente_param VARCHAR(11),
    IN cpf_vendedor_param VARCHAR(11),
    IN dia_param SMALLINT,
    IN mes_param SMALLINT,
    IN ano_param SMALLINT,
    IN metodo_pgmt_param pagamento_type,
    IN status_pago_param BOOLEAN,
    IN valor_total_param DECIMAL(10, 2)
) RETURNS INT  -- This function returns an integer
LANGUAGE plpgsql
AS $$
DECLARE
    id_compra_inserted INT;
BEGIN
    -- Verificar se o método de pagamento é válido
    IF metodo_pgmt_param NOT IN ('pix', 'cartao', 'boleto', 'berries') THEN
        RAISE EXCEPTION 'Método de pagamento inválido. Opções válidas: pix, cartao, boleto, berries.';
    END IF;

    -- Verificar se o status é válido
    IF status_param NOT IN ('pago', 'nao_pago') THEN
        RAISE EXCEPTION 'Status inválido. Opções válidas: pago, nao_pago.';
    END IF;

    INSERT INTO Compra (cpf_cliente, cpf_vendedor, dia, mes, ano, metodo_pgmt, status_pago, valor_total)
    VALUES (cpf_cliente_param, cpf_vendedor_param, dia_param, mes_param, ano_param, metodo_pgmt_param, status_pago_param, valor_total_param)
    RETURNING id_compra INTO id_compra_inserted;

    RETURN id_compra_inserted;  -- Return the ID of the newly inserted row
END;
$$;
