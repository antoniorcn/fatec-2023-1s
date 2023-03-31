package edu.curso;

public class Job1 {
	public synchronized void run() { 
		if (Conta.saldo >= 1500.0f) { 
			Conta.saldo = Conta.saldo - 1500.0f;
		}
	}
}
