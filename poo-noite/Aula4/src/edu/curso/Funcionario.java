package edu.curso;

public class Funcionario {

	double salario;
	
	public void receberPagamento(String nome, 
			double ... adicionais  ) {
		double total = this.salario;
		for (int i = 0; i < adicionais.length; i++) { 
			total += adicionais[i];
		}
		System.out.println("Empregado " + nome +
				" recebeu: " + total);
		
	}
}
