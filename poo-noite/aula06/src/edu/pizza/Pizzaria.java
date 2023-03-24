package edu.pizza;

public class Pizzaria {
	public static void main(String[] args) {
		Pizza p1 = new PizzaMussarelaBrotinho();
		p1.preparar();
		p1.assar();
		p1.cortar();
		p1.servir();
	}
}
