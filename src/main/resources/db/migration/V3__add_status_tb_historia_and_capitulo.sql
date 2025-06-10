-- Adiciona a coluna 'status' na tabela de histórias
ALTER TABLE tb_historias
ADD COLUMN status VARCHAR(20) DEFAULT 'RASCUNHO';

-- Adiciona a coluna 'status' na tabela de capítulos
ALTER TABLE tb_capitulos
ADD COLUMN status VARCHAR(20) DEFAULT 'RASCUNHO';
