package edu.curso;

public class RHComDemonstrativo 
	extends RecursosHumanos {
	
	void fazPagamento(Funcionario f, 
			double ... valores) {
		System.out.println(
				"Fez pagamento com demonstrativo");
		super.fazPagamento(f, valores);
	}

}
