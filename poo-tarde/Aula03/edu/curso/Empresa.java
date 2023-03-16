package edu.curso;
public class Empresa {
	public static void main(String[] args) {	
		Funcionario joao = new Funcionario();
		joao.nome = "Joao Silva";
		joao.documento = "111111";
		joao.salario = 1000.0;
		
		Funcionario maria = new Funcionario();
		maria.nome = "Maria Silva";
		maria.documento = "222222";
		maria.salario = 1200.0;		
		
		
		FolhaPagamento fp = new FolhaPagamento();
		fp.pagarFuncionario(joao, 300.0, 200.0);
		fp.pagarFuncionario(maria, 
				350.0, 150.0, 200.0);
		
	}

}
