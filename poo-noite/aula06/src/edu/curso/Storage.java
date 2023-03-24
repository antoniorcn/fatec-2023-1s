package edu.curso;

public class Storage<T1, T2> {
	
	T1 valor1;
	T2 valor2;
	
	public void guardar1(T1 obj) { 
		this.valor1 = obj;
	}
	
	public void guardar2(T2 obj) { 
		this.valor2 = obj;
	}
	 
	 
	public void mostrar() { 
		System.out.println("Estamos guardando");
		System.out.println(valor1);
		System.out.println(valor2);
	}

}
