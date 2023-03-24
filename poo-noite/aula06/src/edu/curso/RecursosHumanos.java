package edu.curso;

public class RecursosHumanos {
	
	void fazPagamento(Funcionario f, 
			double ... valores) {
		double soma = 0;
		for(double valor : valores) { 
			// soma += valor;
			soma = soma + valor;
		}
		f.receberPagamento(soma);
	}

}
