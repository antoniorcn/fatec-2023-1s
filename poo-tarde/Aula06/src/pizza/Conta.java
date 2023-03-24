package pizza;

public class Conta {
	
	public float saldo = 1000.0f;
	
	public void saque(float valor) { 
		if (saldo >= valor) {
			synchronized (this) {
				saldo = saldo - valor;
			}
		}
	}
	
	public static void main(String[] args) {
		Conta c1 = new Conta();
		
		//Thread A
		c1.saque(200);
		c1.saque(300);
		c1.saque(800);
		c1.saque(300);
		c1.saque(200);
		
		// Thread B
		c1.saque(200);
		c1.saque(300);
		c1.saque(800);
		c1.saque(300);
		c1.saque(200);
	}

}

