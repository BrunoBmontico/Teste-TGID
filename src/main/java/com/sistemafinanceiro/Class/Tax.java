package main.java.com.sistemafinanceiro.Class;
import main.java.com.sistemafinanceiro.Controller.IdGeneretor;

public class Tax {
    private int id = IdGeneretor.generateId();
    private String type;
    private double value;
    private int id_enterprise;

    // GETTERS e SETTERS

    // ID TAXA
    public int getId(){
        return id;
    }
    public void setId(int id_tax){
        this.id = id_tax;
    }

    // TIPO TAXA
    public String getType(){
        return type;
    }
    public void setType(String tax_type){
        this.type = tax_type;
    }

    // VALOR TAXA
    public double getValue(){
        return value;
    }
    public void setValue(double tax_value){
        this.value = tax_value;
    }

    // CHAVE ESTRANGEIRA DA EMPRESA
    public int getForeignkey(){
        return id_enterprise;
    }
    public void setForeignkey(int foreign_key){
        this.id_enterprise = foreign_key;
    }
}
