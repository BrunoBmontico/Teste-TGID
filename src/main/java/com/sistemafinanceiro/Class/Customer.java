package main.java.com.sistemafinanceiro.Class;
import main.java.com.sistemafinanceiro.Controller.IdGeneretor;

public class Customer {
    private int id = IdGeneretor.generateId();
    private String name;
    private String CPF;
    private double balance;
    private String password;

    // GETTERS e SETTERS

    // ID CLIENTE
    public int getId(){
        return id;
    }

    // NOME CLIENTE
    public String getName(){
        return name;
    }
    public void setName(String customer_name){
        this.name = customer_name;
    }

    // CPF CLIENTE
    public String getCPF(){
        return CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    // SALDO CLIENTE
    public double getSaldo(){
        return balance;
    }
    public void setSaldo(double customer_balance){
        if (balance >= 0){
            this.balance = customer_balance;
        } else {
            System.out.println("**-Saldo nao pode ser negativo-**");
        }
    }

    // SENHA DE USUARIO CLIENTE
    public String getPassword(){
        return password;
    }
    public void setPassword(String customer_password){
        this.password = customer_password;
    }
}
