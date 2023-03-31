package edu.curso;

public class Ferrari extends Carro {
	
	private Pneu estepe;
	private int a;
	
	private class PneuFerrari extends Pneu { 
		@Override
		@SuppressWarnings(value = { "unused" })
		public void rodar( ) { 
			int b = 20;
			System.out.println("Rodando como estepe");
		}
	}
	
	
	public void trocarPneu() { 
		estepe = new PneuFerrari();
	}
	

}
