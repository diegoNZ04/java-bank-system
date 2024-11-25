package co.diegoamorim.bank;

import java.util.List;
import java.util.ArrayList;

public class Bank {

    // Propriedades
    private String ag;
    private List<Account> accounts;
    private int lastAccount = 1;

    // Construtor
    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    // Getter - Lista de Contas
    public List<Account> getAccounts(){
        return accounts;
    }

    public void insertAccount(Account account){
        // Adicionar conta no Array List
        accounts.add(account);
    }

    // Funcao gerar conta
    public Account generateAccount(String name){
        Account account = new Account(ag, "" + lastAccount, name);
        lastAccount++;
        return account;
    }

    // Calcular valor total do banco
    public void outputTotal(){
        double total = 0;
        for(Account account : accounts){
            double balance = account.getBalance();
            total += balance;
        }
        System.out.print("O banco possui atualmente: R$" + total);
    }

}
