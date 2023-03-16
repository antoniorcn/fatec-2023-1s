package edu.curso;

public class Gato {
	String nome;
	String raca;
	int idade;
	
	public void dados(String nome, String raca, int idade) { 
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
	}
	
	public void miar() { 
		System.out.println("Miauuuu...");
	}
	
	public void comer() { 
		System.out.println("Comendo....");
	}
	
	public void imprimir() { 
		System.out.println("Nome: " + this.nome);
		System.out.println("Raca: " + this.raca);
		System.out.println("Idade: " + this.idade);
	}
}
