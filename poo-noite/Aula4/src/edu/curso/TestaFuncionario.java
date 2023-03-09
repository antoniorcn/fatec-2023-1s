package edu.curso;

public class TestaFuncionario {

	public static void main(String ... args) {
		Funcionario mario = new Funcionario();
		mario.salario = 9900.0;
		mario.receberPagamento("Mario", 400.0, 700.0, 200.0, 450.0);
		
		Funcionario junior = new Funcionario();
		junior.salario = 2300.0;	
		junior.receberPagamento("Junior", 400.0, 300.0, 280.0);
		
		Funcionario osvaldo = new Funcionario();
		osvaldo.salario = 2000.0;	
		osvaldo.receberPagamento("Osvaldo");

	}
}
