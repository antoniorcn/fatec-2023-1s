package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class RevistaAbril implements Revista {
	private List<Assinante> lista = new ArrayList<>();
	@Override
	public void adicionarAssinante(Assinante a) {
		lista.add(a);		
	}

	@Override
	public void removerAssinante(Assinante a) {
		lista.remove(a);
	}

	@Override
	public void publicar(String p) {
		for (Assinante a : lista) {
			a.receberPublicacao(p);
		}
	}

}
