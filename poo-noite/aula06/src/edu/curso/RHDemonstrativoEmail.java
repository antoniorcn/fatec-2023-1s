package edu.curso;

public class RHDemonstrativoEmail 
		extends RHComDemonstrativo {
	
	
	// void fazPagamento(Funcionario f, 
	//		double ... valores)
	
	@Override
	public void fazPagamento(Funcionario f,
			double ... valores ) {
		System.out.println(
				"Fez pagamento com demonstrativo");
		double soma = 0;
		for(double valor : valores) { 
			// soma += valor;
			soma = soma + valor;
		}
		f.receberPagamento(soma);
		System.out.println(
				"Enviamos por email também");
	}

}
