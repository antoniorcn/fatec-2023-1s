package edu.curso;

public interface Estagiario {
	double salarioBase = 1020.00; 
	void trabalhar();
	void estudar();
	
	default void relatorioEstagio() { 
		System.out.println("Fazendo relatorio de estágio");
	}
	
	static void fazAlgo() { 
		System.out.println("Fazendo algo");
	}
}
