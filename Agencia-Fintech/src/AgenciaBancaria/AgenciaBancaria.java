package AgenciaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Conta> ContasCadastradas;

	public static void main(String[] args) {

		ContasCadastradas = new ArrayList<Conta>();
		menu();

	}

	public static void menu() {

		System.out.println("---Agencia Fintech----");
		System.out.println("----------------------");
		System.out.println("---Escolha uma das operações---");
		System.out.println("--- Opção 1 - Criar conta---");
		System.out.println("--- Opção 2 - Depositar---");
		System.out.println("--- Opção 3 - Sacar---");
		System.out.println("--- Opção 4 - Transferir");
		System.out.println("--- Opção 5 - Listar---");
		System.out.println("--- Opção 6 - extrato de conta---");
		System.out.println("--- Opção 7 - Sair---");

		int escolha = scan.nextInt();
		switch (escolha) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			extrato();
			break;
		case 7:
			System.out.println("atendimento finalizado");
			System.exit(0);

		}

	}

	public static void criarConta() {

		System.out.println(" digite  1 -Pessoa Fisica ou  2 - empresa  ?");
		int tipoPessoa = scan.nextInt();
		System.out.println("Nome:");
		String nome = scan.next();

		if (tipoPessoa == 1) {
			System.out.println("cpf");
			String cpf = scan.next();
			Pessoa pessoaFisica = new PessoaFisica(nome, cpf);
			Conta conta1 = new Conta(pessoaFisica);
			ContasCadastradas.add(conta1);

		} else if (tipoPessoa == 2) {
			System.out.println("cnpj");
			String cnpj = scan.next();
			Pessoa pessoaJuridica = new PessoaJuridica(nome, cnpj);
			Conta conta2 = new Conta(pessoaJuridica);
			ContasCadastradas.add(conta2);
		}

		System.out.println("Conta cadastrada");

		menu();
	}

	public static Conta consultaConta(int numConta) {
		Conta conta = null;
		if (ContasCadastradas.size() > 0) {
			for (Conta contaAux : ContasCadastradas) {
				if (contaAux.getNumConta() == numConta) {
					conta = contaAux;
				}
			}
		} else
			System.out.println("conta nao encontrada");
		return conta;

	}

	public static void depositar() {
		System.out.println("informe o numero da conta:");
		int numConta = scan.nextInt();
		Conta contaDeposito = consultaConta(numConta);
		if (contaDeposito != null) {
			System.out.println("valor:");
			double valorDeposito = scan.nextDouble();
			contaDeposito.deposito(valorDeposito);
			System.out.println("valor depositado");
		} else
			System.out.println("conta nao encontrada");

		menu();
	}

	public static void sacar() {
		System.out.println("informe o numero da conta:");
		int numConta = scan.nextInt();
		Conta conta = consultaConta(numConta);
		if (conta != null) {
			System.out.println("valor:");
			double valorDeposito = scan.nextDouble();
			conta.saque(valorDeposito);
			System.out.println("valor sacado");
		} else
			System.out.println("conta nao encontrada");

		menu();
	}

	public static void transferir() {
		System.out.println("Numero da conta Origem");

		int numContaOrigem = scan.nextInt();
		Conta contaOrigem = consultaConta(numContaOrigem);
		if (contaOrigem != null) {
			System.out.println("Numero da conta destino:");

			int numContaDestino = scan.nextInt();
			Conta contaDestino = consultaConta(numContaDestino);
			if (contaDestino != null) {
				System.out.println("valor:");
				double valor = scan.nextDouble();
				contaOrigem.transferencia(contaDestino, valor);
			}else
				System.out.println("dados invalidos");
		}

		menu();

	}

	public static void extrato() {
		System.out.println("informe o numero da conta:");
		int numConta = scan.nextInt();
		Conta conta = consultaConta(numConta);
		if (conta != null) {
			conta.extrato();
		}

		menu();
	}

	public static void listarContas() {
		if (ContasCadastradas.size() > 0) {
			for (Conta contaAux : ContasCadastradas) {
				System.out.println(
						"Cliente: " + contaAux.getPessoa().getNome() + " - numero da conta: " + contaAux.getNumConta());
			}
		} else
			System.out.println("não há contas cadastradas");

		menu();
	}
}
