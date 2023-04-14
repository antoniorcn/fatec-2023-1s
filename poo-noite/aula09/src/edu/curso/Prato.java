package edu.curso;

public class Prato {

	private String nome;
	private String codigo;
	private String ingredientes;
	
	public String getNome() { 
		return nome;
	}
	public void setNome(String texto) { 
		this.nome = texto;
	}
	
	public String getCodigo() { 
		return codigo;
	}
	public void setCodigo(String texto) { 
		this.codigo = texto;
	}
	
	public String getIngredientes() { 
		return this.ingredientes;
	}
	public void setIngredientes(String texto) {
		this.ingredientes = texto;
	}
	
	@Override
	public String toString() {
		return this.codigo+ " - " + this.nome + 
				"\n" + this.ingredientes;
	}
}
