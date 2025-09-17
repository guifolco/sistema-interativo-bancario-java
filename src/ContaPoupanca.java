public class ContaPoupanca extends Conta {

    private static final double TAXA_RENDIMENTO = 0.005; // 0.5%

    public ContaPoupanca(String titular, String numero) {
        super(titular, numero);
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * TAXA_RENDIMENTO;
        depositar(rendimento);
    }
}