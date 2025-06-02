CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE tb_usuarios (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome_usuario VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL

);
