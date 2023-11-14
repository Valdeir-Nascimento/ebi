CREATE TABLE categoria_patrocinador
(
    id    BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome  VARCHAR(100) NOT NULL,
    icone VARCHAR(100) NOT NULL
);

CREATE TABLE patrocinador
(
    id                     BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome                   VARCHAR(100) NOT NULL,
    site                   VARCHAR(100) NOT NULL,
    logomarca              VARCHAR(100) NOT NULL,
    categoria_patrocinador BIGINT       NOT NULL
);

CREATE TABLE tipo_atividade
(
    id                  BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome                VARCHAR(100) NOT NULL,
    listar_palestrantes TINYINT(1)   NOT NULL DEFAULT FALSE
);

CREATE TABLE sala
(
    id     BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome   VARCHAR(100) NOT NULL,
    imagem VARCHAR(100) NULL
);

CREATE TABLE atividade
(
    id             BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(100) NOT NULL,
    resumo         TEXT         NOT NULL,
    inicio         DATETIME     NOT NULL,
    fim            DATETIME     NOT NULL,
    tipo_atividade BIGINT       NOT NULL,
    sala           BIGINT       NOT NULL
);

CREATE TABLE autor
(
    id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome        VARCHAR(150) NOT NULL,
    abreviado   VARCHAR(150) NULL,
    instituicao VARCHAR(50)  NOT NULL
);

CREATE TABLE trabalho
(
    id              BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo          VARCHAR(250) NOT NULL,
    resumo          TEXT         NOT NULL,
    palavras_chaves VARCHAR(150) NOT NULL,
    atividade       BIGINT       NOT NULL
);

CREATE TABLE trabalho_autor
(
    trabalho_id BIGINT NOT NULL,
    autor_id    BIGINT NOT NULL
);

CREATE TABLE financiador
(
    id   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL
);

CREATE TABLE financiador_trabalho
(
    financiador_id BIGINT NOT NULL,
    trabalho_id    BIGINT NOT NULL
);

CREATE TABLE versao
(
    id     BIGINT   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ultima DATETIME NOT NULL
);

CREATE TABLE usuario
(
    id      BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome    VARCHAR(50)  NOT NULL,
    email   VARCHAR(150) NOT NULL,
    celular VARCHAR(11)  NOT NULL,
    senha   VARCHAR(150) NOT NULL
);

CREATE TABLE permissao
(
    id        BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(60) NOT NULL,
    nome      VARCHAR(60) NOT NULL
);

CREATE TABLE grupo
(
    id   BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL
);

CREATE TABLE grupo_permissao
(
    grupo_id     BIGINT NOT NULL,
    permissao_id BIGINT NOT NULL,
    PRIMARY KEY (grupo_id, permissao_id)
);

CREATE TABLE usuario_grupo
(
    grupo_id   BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    PRIMARY KEY (grupo_id, usuario_id)
);

ALTER TABLE patrocinador
    ADD CONSTRAINT fk_patrociandor__categoria_patrocinador__id
        FOREIGN KEY (categoria_patrocinador) REFERENCES categoria_patrocinador (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE atividade
    ADD CONSTRAINT fk_atividade__tipo_atividade__id
        FOREIGN KEY (tipo_atividade) REFERENCES tipo_atividade (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE atividade
    ADD CONSTRAINT fk_atividade__sala__id
        FOREIGN KEY (sala) REFERENCES sala (id)
            ON DELETE NO ACTION
            ON UPDATE CASCADE;


ALTER TABLE trabalho
    ADD CONSTRAINT fk_trabalho__atividade__id
        FOREIGN KEY (atividade) REFERENCES atividade (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE trabalho_autor
    ADD CONSTRAINT fk_trabalho_autor__autor__id
        FOREIGN KEY (autor_id) REFERENCES autor (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE trabalho_autor
    ADD CONSTRAINT fk_trabalho_autor__trablho__id
        FOREIGN KEY (trabalho_id) REFERENCES trabalho (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE financiador_trabalho
    ADD CONSTRAINT fk_financiador_trabalho__financiador__id
        FOREIGN KEY (financiador_id) REFERENCES financiador (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE financiador_trabalho
    ADD CONSTRAINT fk_financiador_trabalho__trabalho__id
        FOREIGN KEY (trabalho_id) REFERENCES trabalho (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE grupo_permissao
    ADD CONSTRAINT fk_grupo_permissao__permissao__id
        FOREIGN KEY (permissao_id) REFERENCES permissao (id);

ALTER TABLE grupo_permissao
    ADD CONSTRAINT fk_grupo_permissao__grupo__id
        FOREIGN KEY (grupo_id) REFERENCES grupo (id);

ALTER TABLE usuario_grupo
    ADD CONSTRAINT fk_usuario_grupo__grupo__id
        foreign key (grupo_id) REFERENCES grupo (id);

ALTER TABLE usuario_grupo
    ADD CONSTRAINT fk_usuario_grupo__usuario__id
        FOREIGN KEY (usuario_id) REFERENCES usuario (id);
