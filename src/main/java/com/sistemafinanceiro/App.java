package main.java.com.sistemafinanceiro;
import main.java.com.sistemafinanceiro.Controller.*;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    // MENU PRINCIPAL
    public static int showMainMenu(){

        System.out.println("---Sistema financeiro---");
        System.out.println("1. Cadastrar empresa.");
        System.out.println("2. Realizar Depósito.\n3. Realizar Saque\n4. Consultar Saldo");
        System.out.println("5. Sair");

        // INPUT DE RESPOSTA
        int output = Integer.parseInt(input.nextLine());

        return output;
        
    }

    public static void main(String[] args) {

        // showMainMenu();
        // CreateEnterprise.create_object();
        // CreateEnterprise.configTax();
        // CreateClient.create_object();
        TransactionHistory.deposit();
    }
}
