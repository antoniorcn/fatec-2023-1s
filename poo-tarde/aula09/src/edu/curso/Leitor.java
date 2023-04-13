package edu.curso;

public class Leitor implements Assinante {
	@Override
	public void receberPublicacao(String p) {
		System.out.println("Está lendo " + p);
	}

}
