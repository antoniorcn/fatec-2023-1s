package edu.curso.alunos;

import java.time.LocalDate;

public class Aluno {
	
	public long id;
	public String nome = "";
	public String ra = "";
	public LocalDate nascimento = LocalDate.now();
	
	@Override
	public String toString() { 
		return this.ra + " - " + this.nome;
	}

}
