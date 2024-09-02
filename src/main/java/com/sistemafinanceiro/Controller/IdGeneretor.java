package main.java.com.sistemafinanceiro.Controller;

public class IdGeneretor {

    private static int counter = 1;

    public static int generateId(){

        return counter++;

    }
    
}
