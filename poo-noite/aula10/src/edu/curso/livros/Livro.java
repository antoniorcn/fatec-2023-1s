package edu.curso.livros;

import java.time.LocalDate;

public class Livro {
	private String titulo;
	private int paginas;
	private LocalDate dataPublicacao;
	
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
}
