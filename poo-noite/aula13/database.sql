CREATE TABLE contatos (
	id int PRIMARY KEY AUTO_INCREMENT,
	nome char(100),
	telefone char(30),
	email char(100)
);

INSERT INTO contatos (nome, telefone, email) 
VALUES ('Antonio Carvalho', 
		'(11) 1234-5678', 'antonio@teste.com');
		
SELECT * FROM contatos;