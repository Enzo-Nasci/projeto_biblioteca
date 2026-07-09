CREATE OR REPLACE PROCEDURE realizar_compra(
    id_usuario TEXT,
    id_livro TEXT,
    quantidade_comprada INTEGER
)
LANGUAGE plpgsql
AS $$
DECLARE
preco DECIMAL;
BEGIN
SELECT PRECO
INTO preco
FROM LIVRO
WHERE ID = p_id_livro;

INSERT INTO COMPRA (
    ID,
    ID_LIVRO,
    ID_USUARIO,
    VALOR
)
VALUES (
           id_compra,
           id_livro,
           id_usuario,
           preco * quantidade_comprada
       );

UPDATE ESTOQUE
SET QUANTIDADE = QUANTIDADE - quantidade_comprada
WHERE ID_LIVRO = id_livro;
END;
$$;