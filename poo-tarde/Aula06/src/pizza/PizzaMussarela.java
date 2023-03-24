package pizza;

public class PizzaMussarela extends Pizza {

	@Override
	public void preparar() { 
		System.out.println("Colocar molhor e queijo mussarela, "
				+ "azeitona, tomate e orégano");
	}
	
	@Override
	public void assar() { 
		System.out.println("Assando por 5 minutos no forno");
	}
	
	@Override
	public void cortar() { 
		System.out.println("Cortar em 12 pedaços");
	}
}
