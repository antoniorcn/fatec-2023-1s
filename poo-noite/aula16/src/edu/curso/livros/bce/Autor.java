package edu.curso.livros.bce;

public class Autor {
	private long id;
	private String nome;
	private String editora;
	private String cidade;
	
	public long getId() { 
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String toString() { 
		return this.id + " - " + this.nome + " - " + this.editora;
	}
}
