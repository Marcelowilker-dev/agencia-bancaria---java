package AgenciaBancaria;

import java.util.ArrayList;

public class Conta {
	private static int contador = 1;

	private Pessoa pessoa;
	private int numConta;
	private double saldo = 0;
	private ArrayList entradas = new ArrayList<Double>();
	private ArrayList saidas = new ArrayList<Double>();

	public Conta(Pessoa pessoa) {
		contador += 1;
		this.numConta = contador;
		this.pessoa = pessoa;

	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Conta.contador = contador;
	}

	public void deposito(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			saidas.add(valor);

		} else
			System.out.println("valor invalido");
	}

	public void saque(double valor) {
		if (getSaldo() >= valor && valor > 0) {
			setSaldo(getSaldo() - valor);
			entradas.add(valor);

		}
	}

	public void transferencia(Conta conta, double valor) {
		if (getSaldo() >= valor && valor > 0) {
			setSaldo(getSaldo() - valor);
			conta.setSaldo(getSaldo() + valor);
			saidas.add(valor);
			System.out.println("Transferencia realizada com sucesso.");
		}
	}

	public void extrato() {
		double aux = 0;
		double aux2 = 0;
		System.out.println("Saídas");
		for (int i = 0; i < saidas.size(); i++) {
			System.out.println(saidas.get(i));
			aux += (double) saidas.get(i);
		}
		System.out.println("---Entradas----");
		for (int i = 0; i < entradas.size(); i++) {
			System.out.println(entradas.get(i));
			aux2 += (double) saidas.get(i);
		}
		System.out.println("total saidas:" + aux);
		System.out.println("");
		System.out.println("total entradas:" + aux2);
		System.out.println("----------------------");
		System.out.println("Saldo atual: " + getSaldo());
	}

}
