package edu.pizza;

public abstract class PizzaBrotinho extends Pizza {
	public void preparar() { 
		System.out.println("Abrir a massa");
	}
	
	public void cortar() { 
		System.out.println("Cortada em 4 pedaços");
	}
}
