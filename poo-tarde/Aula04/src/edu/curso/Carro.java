package edu.curso;

public class Carro {

	String cor;
	String chassi;
	
	public Roda roda;
	private Motor motor = new Motor();
	
	public void ligar() { 
		motor.ligar();
		System.out.println("Carro ligado...");
	}
	
	public void acelerar() { 
		roda.rodar();
		System.out.println("Acelerando...");
	}
}
