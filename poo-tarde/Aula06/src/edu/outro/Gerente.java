package edu.outro;

import edu.curso.Funcionario;

public class Gerente extends Funcionario {

	void receberGrana() { 
		receberPagamento(3600.0);
	}
	
	void receberGranaToTime() {
		Funcionario joao = new Funcionario();
		Funcionario maria = new Funcionario();
		Funcionario alberto = new Funcionario();
		
		joao.receberPagamento(1200.0);
		maria.receberPagamento(2400.0);
		alberto.receberPagamento(1500.0);
	}
}
