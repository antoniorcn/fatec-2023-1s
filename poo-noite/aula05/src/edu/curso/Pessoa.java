package edu.curso;

public class Pessoa extends Animal {
	String nome;
	public Pessoa() {
		this("Desconhecido");
	}
	
	public Pessoa(String nome) { 
		super();
		this.nome = nome;
		System.out.println("Construindo pessoa");
	}
}
