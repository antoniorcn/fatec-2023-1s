package edu.curso;

public class Empresa {

	
	public void contratarEstagiario(Estagiario stag) { 
		stag.trabalhar();
		stag.estudar();
		stag.relatorioEstagio();
		Estagiario.fazAlgo();
		System.out.println(Estagiario.salarioBase);
	}
	
	public static void main(String[] args) {
		Empresa emp = new Empresa();
		
		EstudanteFatec e1 = new EstudanteFatec();
		EstudanteSenai e2 = new EstudanteSenai();
			
		emp.contratarEstagiario(e1);
		emp.contratarEstagiario(e2);
	}
	
}
