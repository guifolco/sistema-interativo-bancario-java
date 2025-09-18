import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        // --- FERRAMENTAS INICIAIS ---
        Scanner scanner = new Scanner(System.in);
        List<Conta> contasDoBanco = new ArrayList<>();

        contasDoBanco.add(new ContaCorrente("Bruce Wayne", "CC-001"));
        contasDoBanco.get(0).depositar(10000.00);
        contasDoBanco.add(new ContaPoupanca("Clark Kent", "CP-001"));
        contasDoBanco.get(1).depositar(5000.00);


        // --- LOOP PRINCIPAL DO MENU ---
        while (true) {
            exibirMenuPrincipal();
            int opcao = 0;

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            // --- ROTEADOR DE OPÇÕES ---
            switch (opcao) {
                case 1:
                    criarConta(scanner, contasDoBanco);
                    break;
                case 2:
                    acessarConta(scanner, contasDoBanco);
                    break;
                case 3:
                    listarContas(contasDoBanco);
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar o sistema. Encerrando...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    // --- MÉTODOS DE AJUDA ---

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- BANCO DIGITAL - MENU PRINCIPAL ---");
        System.out.println("1 - Criar Nova Conta");
        System.out.println("2 - Acessar Conta Existente");
        System.out.println("3 - Listar Todas as Contas");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarConta(Scanner scanner, List<Conta> contas) {
        System.out.println("\n--- Criação de Nova Conta ---");
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();
        System.out.print("Digite o número para a nova conta (ex: CC-002): ");
        String numero = scanner.nextLine();

        System.out.print("Qual o tipo da conta? (1 - Corrente, 2 - Poupança): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        Conta novaConta = null;
        if (tipo == 1) {
            novaConta = new ContaCorrente(titular, numero);
        } else if (tipo == 2) {
            novaConta = new ContaPoupanca(titular, numero);
        } else {
            System.out.println("Tipo de conta inválido. Operação cancelada.");
            return;
        }

        contas.add(novaConta);
        System.out.println("Conta criada com sucesso!");
    }

    private static void acessarConta(Scanner scanner, List<Conta> contas) {
        System.out.print("\nDigite o número da conta que deseja acessar: ");
        String numeroBusca = scanner.nextLine();

        Conta contaEncontrada = null;
        for (Conta conta : contas) {
            if (conta.getNumero().equalsIgnoreCase(numeroBusca)) {
                contaEncontrada = conta;
                break;
            }
        }

        if (contaEncontrada != null) {
            exibirMenuDaConta(scanner, contaEncontrada);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void exibirMenuDaConta(Scanner scanner, Conta conta) {
        while (true) {
            System.out.println("\n--- Operações para a Conta " + conta.getNumero() + " (" + conta.getTitular() + ") ---");
            System.out.printf("Saldo Atual: R$ %.2f\n", conta.getSaldo());
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            
            if (conta instanceof ContaPoupanca) {
                System.out.println("3 - Aplicar Rendimento");
                System.out.println("4 - Voltar ao Menu Principal");
            } else {
                System.out.println("3 - Voltar ao Menu Principal");
            }
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (!(conta instanceof ContaPoupanca) && opcao == 3) {
                break; 
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    if (conta instanceof ContaPoupanca) {                        
                        ((ContaPoupanca) conta).aplicarRendimento();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 4:
                    if (conta instanceof ContaPoupanca) {
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            if (opcao == 4 || (!(conta instanceof ContaPoupanca) && opcao == 3)) {
                break;
            }
        }
    }

    private static void listarContas(List<Conta> contas) {
        System.out.println("\n--- Lista de Todas as Contas do Banco ---");
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada ainda.");
            return;
        }
        for (Conta conta : contas) {
            System.out.printf("Conta: %s, Titular: %s, Saldo: R$ %.2f\n", 
                conta.getNumero(), conta.getTitular(), conta.getSaldo());
        }
    }
}
