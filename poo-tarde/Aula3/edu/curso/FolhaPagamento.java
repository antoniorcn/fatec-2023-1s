package edu.curso;

public class FolhaPagamento {
	
	void pagarFuncionario(Funcionario f, double ... beneficios) { 
		double total = f.salario;
		
		for (int i = 0; i < beneficios.length; i++) { 
			total += beneficios[i];
		}
		
		f.receberPagamento(total);
	}

}
