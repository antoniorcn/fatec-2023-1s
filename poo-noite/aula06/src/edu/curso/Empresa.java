package edu.curso;

public class Empresa {
	public static void main(String[] args) {
		RecursosHumanos rh = 
				new RHDemonstrativoEmail();
		
		Funcionario joao = new Funcionario();
		Funcionario maria = new Funcionario();
		
		rh.fazPagamento(joao, 2400, 230, 400);
		rh.fazPagamento(maria, 2400, 300, 400);
	}
}
