package edu.curso.alunos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

public class GestaoAlunos {

	private int indice = 0;
	private Aluno[] alunos = new Aluno[1000];
	private Scanner input = new Scanner(System.in);
	private DateTimeFormatter dtf = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void criar() {
		Aluno a = new Aluno();
		System.out.println("Cadastrando novo aluno");
		System.out.println("Digite o RA");
		a.ra = input.nextLine();
		System.out.println("Digite o NOME");
		a.nome = input.nextLine();
		System.out.println("Digite a data de NASCIMENTO (DD/MM/AAAA)");
		String strData = input.nextLine();
		a.nascimento = LocalDate.from(dtf.parse(strData));
		
		alunos[indice] = a;
		indice = indice + 1;
		System.out.println("Aluno cadastrado, tecle <ENTER> para continuar");
		input.nextLine();
	}
	
	public void exibir() { 
		System.out.println("Procurando aluno");
		System.out.println("Digite o numero do RA do aluno");
		String ra = input.nextLine();
		for (int i = 0; i < this.indice; i++) { 
			Aluno a = alunos[i];
			if (a != null) { 
				if (ra.equals(a.ra)) { 
					System.out.println("Aluno encontrado");
					System.out.println("ID: " + a.id);
					System.out.println("RA: " + a.ra);
					System.out.println("Nome: " + a.nome);
					System.out.println("Nascimento: " + 
									dtf.format(a.nascimento));
					System.out.println("Tecle <ENTER> para continuar");
					input.nextLine();	
					break;
				}
			}
		}
	}
	
	public void remover() { 
		System.out.println("Removendo aluno");
		System.out.println("Digite o numero do RA do aluno a ser removido");
		String ra = input.nextLine();
		for (int i = 0; i < this.indice; i++) {
			Aluno a = alunos[i];
			if (a != null) { 
				if (ra.equals(a.ra)) {
					alunos[i] = null;
					System.out.println("Aluno removido com sucesso. Tecle <ENTER> para continuar");
					input.nextLine();	
					break;
				}
			}
		}
	}
	
	public void atualizar() { 
		System.out.println("Atualizando dados do aluno");
		System.out.println("Digite o numero do RA do aluno a ser atualizado");
		String ra = input.nextLine();
		for (int i = 0; i < this.indice; i++) {
			Aluno a = alunos[i];
			if (a != null) { 
				if (ra.equals(a.ra)) {
					System.out.println("Digite o NOVO NOME");
					a.nome = input.nextLine();
					System.out.println("Digite a NOVA DATA DE NASCIMENTO (DD/MM/AAAA)");
					String strData = input.nextLine();
					a.nascimento = LocalDate.from(dtf.parse(strData));
					System.out.println("Aluno atualizado com sucesso. Tecle <ENTER> para continuar");
					input.nextLine();	
					break;
				}
			}
		}
	}
	
	public void menu() { 
		boolean executando = true;
		while (executando) {
			System.out.println("Gestão de alunos");
			System.out.println("(C)riar");           
			System.out.println("(E)xibir");
			System.out.println("(R)emover");
			System.out.println("(A)tualizar");
			System.out.println("(S)air");
			char opcao = input.nextLine()
					.toUpperCase().charAt(0);
			if (opcao == 'C') { 
				this.criar();
			} else if (opcao == 'E') { 
				this.exibir();
			} else if (opcao == 'R') { 
				this.remover();
			} else if (opcao == 'A') { 
				this.atualizar();
			} else if (opcao == 'S') { 
				System.out.println("Sistema encerrado");
				executando = false;
			} else { 
				System.out.println("Opção inválida");
			}
		}
	} 
	
	
	public static void main(String[] args) {
		GestaoAlunos ga = new GestaoAlunos();
		ga.menu();
	}
	
}
