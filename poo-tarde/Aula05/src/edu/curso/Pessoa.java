package edu.curso;
public class Pessoa extends Animal {
	String nome;

	public Pessoa(String nome) { 
		this.nome = nome;
		System.out.println("Pessoa criada");
	}
	
	public void ler() { 
		System.out.println(this.nome + " lendo com dificuldade");
	}
}
