package pizza;

public abstract class Pizza {
	
	public String[] ingredientes = new String[100];
	
	public float peso = 100.465f;
	
	abstract void preparar();
	
	abstract void assar();
	
	public void cortar() { 
		System.out.println("Pizza sendo cortada em 8 peda�os");
	}
	
	public void servir() { 
		System.out.println("Peda�o da pizza sendo servido");
	}

}
