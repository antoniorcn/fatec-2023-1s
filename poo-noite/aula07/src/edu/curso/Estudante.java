package edu.curso;

public interface Estudante {
	default void estudar() {
		System.out.println("Estudando de maneira autodidata");
	}
}
