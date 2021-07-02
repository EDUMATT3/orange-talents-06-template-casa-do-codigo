insert into autor(id, nome, email, descricao, created_at) values
(null, 'nome 1', 'nome1@email.com', 'anydesc', now()),
(null, 'nome 2', 'nome2@email.com', 'anydesc', now()),
(null, 'nome 3', 'nome3@email.com', 'anydesc', now());

insert into categoria(id, nome) values
(null, 'categoria 1'),
(null, 'categoria 2'),
(null, 'categoria 3');


insert into livro (id, autor_id, categoria_id, isbn, numero_paginas, preco, publicacao, resumo, sumario, titulo) values
(null, 1, 1, 'isbn1', 101, 25.1, '2022-05-13', 'resumo 1', 'sumario 1', 'titulo 1'),
(null, 2, 2, 'isbn2', 102, 25.2, '2023-05-13', 'resumo 2', 'sumario 2', 'titulo 2');

insert into pais(id, nome) values (null, 'Brazil'),(null, 'Estados Unidos');
insert into estado(id, nome, pais_id) values (null, 'SP',1),(null, 'NY',2);