package edu.curso;

public class MotoristaUber extends Aluno 
				implements Estudante, Trabalhador, Motorista {

	@Override
	public void estudar() { 
		System.out.println("Estudando enquanto "
				+ "aguarda passageiro");
	}
	
	public void trabalhar() { 
		
	}
	
	public void dirigir() { 
		
	}
	
	public void mostrarHabilitacao() { 
		
	}
}
