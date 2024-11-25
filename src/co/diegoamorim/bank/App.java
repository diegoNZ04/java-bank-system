package co.diegoamorim.bank;

import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args){
        // Instanciando Scanner, pegar entradas do sistema
        Scanner scanner = new Scanner(System.in);

        // Criando novo banco
        Bank santander = new Bank("0001");

        // C = Criar Conta
        // E = Encerrar
        label:
        while(true){
            System.out.println("O que deseja fazer?");
            System.out.println("Digite [C] para Criar Conta");
            System.out.println("Digite [E] para Encerrar o Programa");
            String op = scanner.nextLine();

            switch (op){
                case "C": {
                    System.out.println("Digite o seu nome: ");
                    String name = scanner.nextLine();
                    // Criando nova conta
                    Account account = santander.generateAccount(name);
                    // Inserindo nova conta no Array List
                    santander.insertAccount(account);
                    System.out.print(account);

                    // Chamada loop sistema de conta
                    operateAccount(account);
                    break;
                }
                case "E":
                    System.out.println("Sistema encerrado!");
                    break label;
                default:
                    System.out.println("Operação não existe. Tente novamente.");
                    break;
            }

            // Novo scanner a cada operacao
            scanner = new Scanner(System.in);
        }

        List<Account> accountList = santander.getAccounts();

        // Percorrer lista de contas
        for(Account cc : accountList){
            System.out.println(cc);
        }
        // Mostrar valor total do banco
        santander.outputTotal();
    }

    static void operateAccount(Account account){
        Scanner scanner = new Scanner(System.in);

        // Loop do Sistema de Conta
            // D = Deposito
            // S = Saque
            // E = Encerrar
        label:
        while(true){
            System.out.println("O que deseja fazer?");
            System.out.println("Digite [D] para Deposito");
            System.out.println("Digite [S] para Saque");
            System.out.println("Digite [E] para Encerrar a Operaçao da Conta");
            // Armazenar operaçao (entrada)
            String op = scanner.nextLine();

            switch (op) {
                case "D": {
                    System.out.println("Qual valor deseja depositar?: ");
                    double value = scanner.nextDouble();
                    account.deposit(value);
                    break;
                }
                case "S": {
                    System.out.println("Qual valor deseja sacar?: ");
                    double value = scanner.nextDouble();
                    if(!account.withDraw(value)){
                        System.out.println("Não foi possível sacar o valor R$" + value);
                    }
                    break;
                }
                case "E":
                    System.out.println(account);
                    System.out.println("Sistema encerrado!");
                    break label;
                default:
                    System.out.println("Operação não existe. Tente novamente.");
                    break;
            }

            // Novo scanner a cada operacao
            scanner = new Scanner(System.in);
        }
    }

}