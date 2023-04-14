package edu.observer;

public class TesteObserver {
	
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("João");
		Pessoa p2 = new Pessoa("Maria");
		
		Jornal j1 = new Jornal("Estadão");
		Jornal j2 = new Jornal("Clarim Diário");
		
		j1.adicionar(p1);
		j1.adicionar(p2);
		
		j2.adicionar(p2);
		
		j1.publicar("Baleia Baleia Baleia");
		
		j2.publicar("Cobra Cobra Cobra");
	}

}
