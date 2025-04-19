package contaBancaria;

public class Operacoes {
	private Conta conta;

    public Operacoes(Conta conta) {
        this.conta = conta;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f\n", conta.getSaldo());
    }

    public void consultarChequeEspecial() {
        System.out.printf("Cheque especial: R$ %.2f\n", conta.getChequeAtualizado());
    }

    public void verificarUsoChequeEspecial() {
        if (conta.estaUsandoChequeEspecial()) {
            System.out.println("Você está utilizando o cheque especial");
        } else {
            System.out.println("Sua conta não está usando cheque especial");
        }
    }

    public void depositar(float valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito");
            return;
        }

        conta.adicionarSaldo(valor);

        if (conta.getChequeAtualizado() > 0) {
            float taxa = conta.getChequeAtualizado() * 0.2f;
            conta.removerSaldo(taxa);
            System.out.printf("Taxa de R$ %.2f foi cobrada pelo uso do cheque especial\n", taxa);
            conta.definirValorUsadoChequeEspecial(0); // para zerar o valor usado do cheque especial
        }

        System.out.printf("Depósito de R$ %.2f realizado com sucesso\n", valor);
    }

    public void sacar(float valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque");
            return;
        }
        float saldoTotal = conta.getChequeAtualizado() + conta.getSaldo();

        if (saldoTotal >= valor) {
            conta.removerSaldo(valor);
            if (conta.getSaldo() < 0) {
                float valorUsado = -conta.getSaldo();// saldo conta negativo = usando cheque especial
                // multiplica o saldo negativo por -1, o tornando positivo
                conta.definirValorUsadoChequeEspecial(valorUsado);
                conta.atualizarChequeEspecialUsado(valorUsado);
            }
            System.out.printf("Saque de R$ %.2f realizado\n", valor);
        } else {
            System.out.println("Saldo insuficiente, incluindo cheque especial");
        }
    }

    public void pagarBoleto(float valor) {
        System.out.printf("Pagando boleto de R$ %.2f \n",valor);// multiplica o saldo negativo por -
        conta.removerSaldo(valor);
        if (conta.getSaldo() < 0) { // Verifica se o saldo ficou negativo
            float valorUsado = -conta.getSaldo();
            conta.definirValorUsadoChequeEspecial(valorUsado);
            conta.atualizarChequeEspecialUsado(valorUsado);
        }
    }

}
