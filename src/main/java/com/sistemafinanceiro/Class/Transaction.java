package main.java.com.sistemafinanceiro.Class;
import main.java.com.sistemafinanceiro.Controller.IdGeneretor;

public class Transaction {
    private int id_transaction = IdGeneretor.generateId();
    private int id_customer;
    private int id_enterprise;
    private String type;
    private double value;
    private String date_hour;

    // GETTERS e SETTERS

    // ID TRANSAÇAO
    public int getId_transaction(){
        return id_transaction;
    }

    // ID CLIENTE
    public int getId_customer(){
        return id_customer;
    }
    public void setId_customer(int id_customer){
        this.id_customer = id_customer;
    }

    // ID EMPRESA
    public int getId_enterprise(){
        return id_enterprise;
    }
    public void setId_enterprise(int id_enterprise){
        this.id_enterprise = id_enterprise;
    }

    // TIPO TRANSAÇAO
    public String getType(){
        return type;
    }
    public void setType(String type_transaction){
        this.type = type_transaction;
    }

    // VALOR TRANSACAO
    public double getValue(){
        return value;
    }
    public void setValue(double value_transaction){
        this.value = value_transaction;
    }

    //DATA TRANSACÃO
    public String getDate(){
        return date_hour;
    }
    public void setDate(String date_hour_transaction){
        this.date_hour = date_hour_transaction;
    }
}

