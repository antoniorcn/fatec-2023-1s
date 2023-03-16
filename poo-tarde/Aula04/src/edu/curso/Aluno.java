package edu.curso;

public class Aluno {
	String nome;
	String ra;
	String documento;
	String curso;
	
	public Aluno() { 
		
	}
	
	public Aluno(String nome, String ra, String curso) { 
		this.nome = nome;
		this.ra = ra;
		this.curso = curso;
	}
	
	public void imprimir() { 
		System.out.println("Nome: " + this.nome);
		System.out.println("Ra: " + this.ra);
		System.out.println("Documento: " + this.documento);
		System.out.println("Curso: " + this.curso);
	}
}
