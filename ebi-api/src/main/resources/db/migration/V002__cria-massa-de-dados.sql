INSERT INTO usuario (id, nome, email, celular, senha) VALUES
    (1, 'Wagner Junior', 'wagnerjr300@gmail.com', '91980499377', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb'),
    (2, 'Valdeir Nascimento', 'valdeircn11@gmail.com', '91981124566', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb'),
    (3, 'Esther', 'esther_shekinah@hotmail.com', '91999265701', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb');

INSERT INTO tipo_atividade (id, nome, listar_palestrantes) VALUES
    (1, 'Simpósio', true),
    (2, 'Comunicação Oral', false);

INSERT INTO sala (id, nome, imagem) VALUES
    (1, 'TAXONOMIA, FILOGENIA E EVOLUÇÃO', null),
    (2, 'ECOLOGIA', null);

INSERT INTO atividade (id, nome, resumo, inicio, fim, tipo_atividade, sala) VALUES
    (1, 'Identificação molecular de peixes', 'resumo', '2019-01-28 10:30', '2019-01-28 16:00', 1, 1),
    (2, 'Conhecimento e conservação de peixes marinho-estuarinos da costa Norte do Brasil', 'resumo', '2019-01-29 10:30', '2019-01-29 16:00', 1, 1),
    (3, 'Taxonomia', 'resumo', '2019-01-28 16:30', '2019-01-28 18:30', 2, 1),
    (4, 'Ecologia', 'resumo', '2019-01-28 16:30', '2019-01-29 18:30', 2, 2);

INSERT INTO trabalho (id, titulo, resumo, palavras_chaves, atividade) VALUES
    (1,'Estudos ecológicos como subsídio à conservação de peixes recifais brasileiros','Resumo estudos ecologicos','Ecologia, simposio', 1),
    (2,'T2','Resumo sobre baleias','Ecologia, mini-simposio', 1),
    (3,'T3','Resumo estudos ecologicos','Ecologia, simposio', 2),
    (4,'T4','Resumo sobre baleias','Ecologia, mini-simposio', 2),
    (5,'T5','Resumo estudos ecologicos','Ecologia, simposio', 3),
    (6,'T6','Resumo sobre baleias','Ecologia, mini-simposio', 4);

INSERT INTO autor (id, nome, abreviado, instituicao) VALUES
    (1,'Sérgio Floeter', 'Sérgio', 'UFPA'),
    (2,'Luciano Montag', 'Montang', 'UFPA'),
    (3,'Maria Edna', 'Maria', 'UFBA'),
    (4,'Elton Cezar', 'Cezar', 'UFCE'),
    (5,'Francisco Alves', 'Francisco', 'UFPA'),
    (6,'Luciana Silva', 'Luciana', 'UFPA'),
    (7,'Fulano de Tal', 'Fulano', 'UFXX');

INSERT INTO trabalho_autor (trabalho_id, autor_id) VALUES
    (1,1),
    (1,2),
    (2,3),
    (3,4),
    (4,5),
    (5,6),
    (6,1),
    (6,7);