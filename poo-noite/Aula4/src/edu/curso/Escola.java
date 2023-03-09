package edu.curso;

public class Escola {
	
		void fazerMatricula(Aluno a) { 
			a.endereco.logradouro = "R. Tiquatira";
		}
		
		void contar( int n ) { 
			n = 10;
		}
		
		public static void main(String[] args) {
			Escola fatec = new Escola();
			Endereco e1 = new Endereco();
			e1.logradouro = "Aguia de Haia";
			e1.cep = "09654-000";
			
			Endereco e2 = new Endereco();
			e2.logradouro = "R. Sonho Gaucho";
			e2.cep = "09655-000";
			
			Aluno a1 = new Aluno();
			a1.idade = 18;
			a1.endereco = e1;
			
			Aluno a2 = new Aluno();
			a2.idade = 19;
			a2.endereco = e2;
			
			System.out.println("Endereco: " + 
					a1.endereco.logradouro);
			
			fatec.fazerMatricula(a1);
			
			System.out.println("Endereco: " + 
					a1.endereco.logradouro);
			
			int a = 50;
			
			System.out.println("A: " + a);
			fatec.contar( a );
			System.out.println("A: " + a);
			
			
			
			
		}
}
