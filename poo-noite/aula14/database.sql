create database livraria;

use livraria;

CREATE TABLE livros (
	id int PRIMARY KEY AUTO_INCREMENT,
	titulo char(100),
	paginas int,
	publicacao date
);