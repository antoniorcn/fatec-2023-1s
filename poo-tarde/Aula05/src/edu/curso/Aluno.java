package edu.curso;

public class Aluno extends Pessoa {
	String ra;
	
	public Aluno() { 
		super("Aluno desconhecido");
	}
	
	public Aluno(String ra) { 
		this();
		this.ra = ra;
	}
	
	public Aluno(String nome, String ra) { 
		super(nome);
		this.ra = ra;
	}
	
	public void ler() { 
		System.out.println("Aluno: " + this.nome + 
				" leu um texto qualquer");
	}
	
	public void ler(String tituloLivro, int capitulo) { 
		System.out.println("Aluno: " + this.nome + " está lendo o livro " + tituloLivro + 
				" no capítulo " + capitulo);
	}
}
