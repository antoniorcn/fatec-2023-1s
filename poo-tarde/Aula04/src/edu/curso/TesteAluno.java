package edu.curso;

public class TesteAluno {
	public static void main(String[] args) {
		// Aluno a1 = new Aluno("João Silva", "111111", "ADS");
		Aluno a1 = new Aluno();
		a1.documento = "111.111.111-11";
		
		Aluno a2 = new Aluno("Maria Silva", "222222", "ADS");
		a2.documento = "222.222.222-22";
		
		a1.imprimir();
		a2.imprimir();
	}
}
