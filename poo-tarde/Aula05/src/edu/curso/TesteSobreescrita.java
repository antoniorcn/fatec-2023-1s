package edu.curso;
import java.util.Random;

public class TesteSobreescrita {
	public static void main(String[] args) {
		Random rnd = new Random();
		Pessoa p1 = new Pessoa("João Silva");
		Aluno a1 = new Aluno("Maria Silva", "22222");
		
		p1.ler();
		a1.ler();
		
		Pessoa p3;
		int i = rnd.nextInt(100);
		if (i < 20) { 
			p3 = p1;
		} else { 
			p3 = a1;
		}
		p3.ler();
	}
}
