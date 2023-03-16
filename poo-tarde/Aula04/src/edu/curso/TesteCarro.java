package edu.curso;

public class TesteCarro {

	
	public static void main(String[] args) {
		Carro fusca = new Carro();
		
		fusca.roda = null;
		
		Roda michelin = new Roda();
		fusca.roda = michelin;
		
		Roda pirelli = new Roda();
		fusca.roda = pirelli;
		
		
		Roda rodaSalva = fusca.roda;
		fusca = null;
	}
}
