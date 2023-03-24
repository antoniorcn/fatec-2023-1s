package pizza;

public class Pizzaria {

	static int quantidadeFuncionarios = 20;
	
	public static void main(String[] args) {
		
//		Matematica mat = new Matematica();
		int r = Matematica.somar(5, 5);
		System.out.println("Soma: " + r);
		
		Pizzaria zsul = new Pizzaria();
		Pizzaria zleste = new Pizzaria();
		zleste.quantidadeFuncionarios = 18;
		
		System.out.println(zsul.quantidadeFuncionarios);
		
		Pizza p1 = new PizzaMussarela();
		Pizza p2 = new PizzaCalabresa();
		
		p2.peso
		
		p1.preparar();
		p1.assar();
		p1.cortar();
		p1.servir();
		
	}
}
