package edu.curso.bce.adaptado;

import java.util.ArrayList;
import java.util.List;

public class DespesaControl {
	private List<Despesa> despesas = new ArrayList<>();
	
	public void adicionar(Despesa d) { 
		despesas.add(d);
	}
	
	public Despesa pesquisar(String razao) { 
		for (Despesa d : despesas) {
			if (d.getRazao().toLowerCase()
					.contains(razao.toLowerCase())) {
				return d;
			}
		}
		return null;
	}
}
