package edu.curso;

public class Teste {
	public static void main(String[] args) {
		Gato jeremias = new Gato();
		Gato leonidas = new Gato();
		
//		jeremias.nome = "Jeremias o Gato";
//		jeremias.raca = "Persa";
//		jeremias.idade = 7;
		jeremias.dados("Jeremias o Gato", "Persa", 7);
		jeremias.imprimir();
		
//		leonidas.nome = "Leonidas o Gato";
//		leonidas.raca = "Angora";
//		leonidas.idade = 9;
		leonidas.dados("Leonidas o Gato", "Angora", 9);
		leonidas.imprimir();
		
	}
}
