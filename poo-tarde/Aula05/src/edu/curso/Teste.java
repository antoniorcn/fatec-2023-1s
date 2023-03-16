package edu.curso;

public class Teste {

	public static void main(String[] args) {
//		Pessoa p1 = new Pessoa();
		Aluno a1 = new Aluno("João Silva", "11111");
		Aluno a2 = new Aluno("22222");
		
		a1.ler();
		a2.ler("Use a cabeça Java", 4);
		
		System.out.println("Instancia de aluno criada: " + a1);
		System.out.println("Fim do programa");
	}
}
