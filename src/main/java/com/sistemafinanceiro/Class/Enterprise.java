package main.java.com.sistemafinanceiro.Class;
import main.java.com.sistemafinanceiro.Controller.IdGeneretor;

public class Enterprise {
    private int id = IdGeneretor.generateId();
    private String name;
    private String cnpj;
    private double balance;

    // GETTERS e SETTERS

    // ID EMPRESA
    public int getId(){
        return id;
    }

    // NOME EMPRESA
    public String getName(){
        return name;
    }
    public String setName(String enterprise_name){
        return this.name = enterprise_name;
    }

    // CNPJ EMPRESA
    public String getCNPJ(){
        return cnpj;
    }
    public String setCNPJ(String CNPJ){
        return this.cnpj = CNPJ;
    }

    // SALDO EMPRESA
    public double getBalance(){
        return balance;
    }
    public void setBalance(double enterprise_balance){
        if (balance >= 0){
            this.balance = enterprise_balance;
        } else {
            System.out.println("---Saldo nao pode ser negativo---");
        }
    }
}
