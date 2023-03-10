package edu.curso;

public class Carro {
	String cor;
	String modelo;
	String placa;
	
	public Carro() { 
		System.out.println("Construindo o carro... sem parametros");
	}
	
	public Carro(String cor) {
		System.out.println("Construindo o carro... apenas cor");
		this.cor = cor;
	}
	
	public Carro(String cor, String modelo, 
			String placa) {
		System.out.println("Construindo o carro... cor, modelo e placa");
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
	}
	
	void preencherDados(String cor, String modelo, 
			String placa) { 
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
	}
	
	void imprimirDados() { 
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Cor: " + cor);
		System.out.println("Placa: " + this.placa);
	}
	
	public static void main(String[] args) {
		Carro c1 = new Carro("roxo", "corsa", "AAA1010");
		Carro c2 = new Carro();
		Carro c3 = new Carro("preto");
		c1.imprimirDados();		
	}

}
