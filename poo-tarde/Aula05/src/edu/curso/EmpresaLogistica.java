package edu.curso;

public class EmpresaLogistica<T> {
	
	public void fazerEntrega(T carga, Motorista mot) { 
		System.out.println("Fazendo entrega");
	}
	
	public static void main(String[] args) {
		EmpresaLogistica<Mercadoria> ml = new EmpresaLogistica<>();
		EmpresaLogistica<Alimento> ifood = new EmpresaLogistica<>();
		
		Motorista joao = new MotoristaCaminhao();
		MotoristaMotoTaxi maddog = new MotoristaMotoTaxi();
		MotoristaUber osvaldo = new MotoristaUber();
			
		Mercadoria tv = new Mercadoria("Tv");
		Alimento hamb = new Alimento("Hamburguer");
		
		ml.fazerEntrega(tv, maddog);
		ifood.fazerEntrega(hamb, osvaldo);
		
		
	}

}
