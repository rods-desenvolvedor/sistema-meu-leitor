CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE tb_historias (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    genero VARCHAR(50) NOT NULL,
    usuario_id UUID NOT NULL,
    CONSTRAINT fk_historia_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuarios(id)
);

CREATE TABLE tb_capitulos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(100) NOT NULL,
    conteudo TEXT NOT NULL,
    historia_id UUID NOT NULL,
    CONSTRAINT fk_capitulo_historia FOREIGN KEY (historia_id) REFERENCES tb_historias(id)
);