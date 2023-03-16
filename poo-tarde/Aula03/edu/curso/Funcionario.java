package edu.curso;

public class Funcionario {
	String documento;
	String nome;
	double salario;
	
	void imprimir() {
		System.out.println(this.nome + " - " + this.salario);
	}
	
	void receberPagamento(double valor) { 
		System.out.println("Eu " + this.nome +
				" estou feliz recebi: R$ " + valor);
	}

}
