package edu.curso;

public class Pizza {
	private String sabor;
	private float preco;
	private String tamanho;
	
	public String getSabor() { 
		return sabor;
	}
	public void setSabor(String sabor) { 
		this.sabor = sabor;
	}
	
	public float getPreco() { 
		return this.preco;
	}
	public void setPreco(float preco) {
		if (preco > 0) { 
			this.preco = preco;
		}
	}
	
	public String getTamanho() { 
		return this.tamanho;
	}
	public void setTamanho(String tamanho) { 
		this.tamanho = tamanho;
	}
	
	@Override
	public String toString() { 
		return "Sabor: " + this.sabor + 
				"  preço: " + this.preco;
	}
}
