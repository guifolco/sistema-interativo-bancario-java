public class ContaCorrente extends Conta {

    private static final double LIMITE_CHEQUE_ESPECIAL = 500.0;

    public ContaCorrente(String titular, String numero) {
        super(titular, numero);
    }

    @Override
    public boolean sacar(double valor) {
        double saldoDisponivel = getSaldo() + LIMITE_CHEQUE_ESPECIAL;

        if (valor > 0 && valor <= saldoDisponivel) {
            double novoSaldo = getSaldo() - valor;
            if (novoSaldo < 0) {
                System.out.println("Atenção: Você está utilizando o cheque especial.");
            }
            setSaldo(novoSaldo);
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Falha no saque. Valor excede o saldo disponível mais o limite do cheque especial.");
            return false;
        }
    }
}
