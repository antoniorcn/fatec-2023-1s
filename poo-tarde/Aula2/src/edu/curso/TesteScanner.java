package edu.curso;
import java.util.Scanner;

public class TesteScanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite seu nome completo: ");
		String nomeCompleto = scan.nextLine();
		
		System.out.println("Informe seu peso: ");
		float peso = scan.nextFloat();
		
		
		System.out.println("Bem vindo " + nomeCompleto);
		System.out.printf("Você tem %5.2f kilos%n", peso);
	}
}
