package contaBancaria;

import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);
    private static Conta conta;
    private static Operacoes operacoes;
    
	public static void main(String[] args) {
		System.out.print("Digite o valor inicial da conta: R$ ");
        float depositoInicial = input.nextFloat();
        conta = new Conta(depositoInicial);
        operacoes = new Operacoes(conta);

        int op;
        do {
            System.out.println("\nMenu de opções do Banco:");
            System.out.println("\t1 - Consultar saldo");
            System.out.println("\t2 - Consultar cheque especial");
            System.out.println("\t3 - Depositar dinheiro");
            System.out.println("\t4 - Sacar dinheiro");
            System.out.println("\t5 - Pagar boleto");
            System.out.println("\t6 - Verificar se está usando cheque especial");
            System.out.println("\t7 - Criar nova conta");
            System.out.println("\t0 - Encerrar o sistema");
            System.out.print("\nDigite a opção desejada: ");
            op = input.nextInt();
            input.nextLine(); 

            switch (op) {
                case 1:
                    operacoes.consultarSaldo();
                    break;
                case 2:
                    operacoes.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.print("Digite o valor do depósito: R$ ");
                    float deposito = input.nextFloat();
                    operacoes.depositar(deposito);
                    operacoes.consultarSaldo();
                    break;
                case 4:
                    System.out.print("Digite o valor do saque: R$ ");
                    float saque = input.nextFloat();
                    operacoes.sacar(saque);
                    operacoes.consultarSaldo();
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto: R$ ");
                    float boleto = input.nextFloat();
                    operacoes.pagarBoleto(boleto);
                    operacoes.consultarSaldo();
                    break;
                case 6:
                    operacoes.verificarUsoChequeEspecial();
                    break;
                case 7:
                    criarNovaConta();
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (op != 0);
    }
	
	public static void criarNovaConta() {
	    System.out.print("Digite o valor inicial da nova conta: R$ ");
	    float novoDepositoInicial = input.nextFloat();
	    input.nextLine(); 
	    conta = new Conta(novoDepositoInicial);
	    operacoes = new Operacoes(conta);
	    System.out.println("Nova conta criada com sucesso!");
	}
	
}
