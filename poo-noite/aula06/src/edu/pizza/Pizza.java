package edu.pizza;

public abstract class Pizza {
	public abstract void preparar();
	
	public final void assar() { 
		System.out.println("Colocar a pizza no forno");
	}
	
	public void cortar() { 
		System.out.println("Cortado em 8 pedaços");
	}
	
	public void servir() { 
		System.out.println("Servindo a pizza");
	}
}
