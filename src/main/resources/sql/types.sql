CREATE TYPE categoria_type AS ENUM (
    'computador', 'notebook', 'monitor', 'processador', 'memoria', 'placa de video',
    'armazenamento', 'gabinete', 'fonte', 'mouse', 'teclado', 'diversos'
);

CREATE TYPE pagamento_type AS ENUM (
    'pix', 'cartao', 'boleto', 'berries'
);
