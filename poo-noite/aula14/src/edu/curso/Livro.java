package edu.curso;

import java.time.LocalDate;

public class Livro {
	private long id;
	private String titulo;
	private int paginas;
	private LocalDate dataPublicacao;
	
	public long getId() { 
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public String toString() { 
		return this.id + " - " + this.titulo + " - " + this.paginas;
	}
}
