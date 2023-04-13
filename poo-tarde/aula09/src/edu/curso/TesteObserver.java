package edu.curso;

public class TesteObserver {
	public static void main(String[] args) {
		RevistaAbril veja = new RevistaAbril();
		RevistaAbril quatroRodas = new RevistaAbril();
		Leitor l1 = new Leitor();
		Leitor l2 = new Leitor();
		
		veja.adicionarAssinante(l1);
		
		quatroRodas.adicionarAssinante(l1);
		quatroRodas.adicionarAssinante(l2);
		
		veja.publicar("Dolar baixa para R$ 4,90");
		quatroRodas.publicar("Novo Caoa Cherry Híbrido "
				+ "fica abaixo de mercado");
	}
}
