show databases;

create database test;

use test;

show tables;

CREATE TABLE agenda (
	id int PRIMARY KEY AUTO_INCREMENT,
	nome char(100),
	telefone char(30),
	email char(100)
);

CREATE TABLE despesas (
	id int PRIMARY KEY AUTO_INCREMENT,
	razao char(100),
	data date,
	valor decimal(7, 2)
);

INSERT INTO despesas (razao, data, valor) 
	VALUES ('Conta de Luz', '2023-05-15', 350.40); 

INSERT INTO agenda (nome, telefone, email) 
	VALUES ('Antonio Carvalho', '(11) 2323-4545', 
	'antonio@teste.com');
	
SELECT * FROM agenda;