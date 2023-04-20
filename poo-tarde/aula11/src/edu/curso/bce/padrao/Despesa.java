package edu.curso.bce.padrao;

import java.time.LocalDate;

public class Despesa {
	private long id = 0;
	private String razao = "";
	private LocalDate data = LocalDate.now();
	private double valor = 0.0;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() { 
		return "Razao: " + razao + "\nValor: " + 
						valor + "\nData: " + data;
	}
}
