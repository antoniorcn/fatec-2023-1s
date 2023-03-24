package edu.curso;

import a.B;

public class TestaStorage {
	public static void main(String[] args) {
		Storage<String, Integer> storage = new Storage<>();
		String pacote = "Pacote com texto a ser guardado";
		
		storage.guardar1(pacote);
		storage.mostrar();
		
		Storage storage2;
		if (storage.valor1 == null) {
			storage2 = new Storage<Double, String>();
			storage2.guardar1(3.1415);
			storage2.mostrar();
		} else { 
			storage2 = new Storage<String, Funcionario>();
			storage2.guardar1("Teste de String");
			storage2.mostrar();
		}
		
		Funcionario joao = new Funcionario();
		
		Storage<Funcionario, String> storage3 = new Storage<>();
		storage3.guardar1(joao);
		storage3.mostrar();
	}
}
