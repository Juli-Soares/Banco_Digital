package YazBank;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias = new ArrayList<>();

    public static void main(String[] args) {
        operacoes();
    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos ao YazBank---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione a operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta Corrente   |");
        System.out.println("|   Opção 2 - Criar conta Poupança   |");
        System.out.println("|   Opção 3 - Depositar              |");
        System.out.println("|   Opção 4 - Sacar                  |");
        System.out.println("|   Opção 5 - Transferir             |");
        System.out.println("|   Opção 6 - Listar                 |");
        System.out.println("|   Opção 7 - Saldo                  |");
        System.out.println("|   Opção 8 - Sair                   |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta(new Corrente(criarUsuario()));
                break;
            case 2:
                criarConta(new Poupanca(criarUsuario()));
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                transferir();
                break;
            case 6:
                listarContas();
                break;
            case 7:
                System.out.println(" Obrigada! ");
                System.exit(0);
                break;
            case 8:
                Saldo();
                break;
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static Usuario criarUsuario() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        return new Usuario(nome, cpf, email);
    }

    public static void criarConta(Conta conta) {
        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");

        agradecimento();
    }

    private static Conta encontrarConta(int numeroConta) {
        for (Conta conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("--- Depósito realizado com sucesso! ---");
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        agradecimento();
    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        agradecimento();
    }

    public static void transferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = input.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();
                contaRemetente.transferencia(contaDestinatario, valor);
                System.out.println("--- Transferência realizada com sucesso! ---");
            } else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }
        } else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }

        agradecimento();
    }

    public static void listarContas() {
        if (!contasBancarias.isEmpty()) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        agradecimento();
    }

    public static void Saldo() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Saldo: " + conta.getSaldo());
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        agradecimento();
    }

    public static void agradecimento() {
        System.out.println("Obrigada por usar o YazBank");
        System.out.println("Deseja voltar ao menu de operações? (s/n)");
        String resposta = input.next();

        if (resposta.equalsIgnoreCase("s")) {
            operacoes();
        } else {
            System.out.println("Agradecemos a visita, até logo!");
            System.exit(0);
        }
    }
    public static class Main {
        public static void main(String[] args) {
            Banco.operacoes();
        }
    }
}
