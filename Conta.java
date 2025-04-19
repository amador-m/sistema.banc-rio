package contaBancaria;

public class Conta {
	private float saldo;
	private float chequeEspecial;
    private float valorUsadoChequeEspecial;

    public Conta(float depositoInicial) {
        this.saldo = depositoInicial;
        definirChequeEspecial(depositoInicial); //chama o método
        this.valorUsadoChequeEspecial = 0;
    }

    private void definirChequeEspecial(float depositoInicial) {
        if (depositoInicial <= 500) {
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = depositoInicial * 0.5f;
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public float getChequeEspecial() {
        return chequeEspecial;
    }

    public boolean estaUsandoChequeEspecial() {
        return saldo < 0; // true se o saldo for menor que 0
        // gasto maior do que tinha na conta e tá usando o cheque especial
    }

    public void adicionarSaldo(float valor) {
        saldo += valor;
    }

    public void removerSaldo(float valor) {
        saldo -= valor;
    }

    public void definirValorUsadoChequeEspecial(float valor) {
        this.valorUsadoChequeEspecial = valor;
    }

    public float getValorUsadoChequeEspecial() {
        return valorUsadoChequeEspecial;
    }
    
    public void atualizarChequeEspecialUsado(float valorUsado) {
        if (valorUsado > 0) {
            chequeEspecial -= valorUsado; // Reduz o cheque especial proporcionalmente ao valor usado
        }
    }
    
    public float getChequeAtualizado() {
    	return chequeEspecial;
    }
}


