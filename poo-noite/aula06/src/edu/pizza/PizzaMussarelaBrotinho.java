package edu.pizza;

public class PizzaMussarelaBrotinho 
		extends PizzaBrotinho {
	
	public void preparar() { 
		super.preparar();
		System.out.println("Adicionar pouco molho,"
				+ "pouco queijo, tomate, oregano "
				+ "e azeitona preta");
	}
}
