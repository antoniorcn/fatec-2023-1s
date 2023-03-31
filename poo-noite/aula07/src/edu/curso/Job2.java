package edu.curso;
public class Job2 {
	public synchronized void run() { 
		if (Conta.saldo >= 1000.0f) { 
			Conta.saldo = Conta.saldo - 1000.0f;
		}
	}
}
