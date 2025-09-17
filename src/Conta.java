public class Conta {

    private String titular;
    private double saldo;
    private String numero;

    public Conta(String titular, String numero) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public String getNumero() { return numero; }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
            return false;
        }
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}