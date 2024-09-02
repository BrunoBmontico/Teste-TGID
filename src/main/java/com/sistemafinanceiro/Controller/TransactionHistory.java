package main.java.com.sistemafinanceiro.Controller;
import com.fasterxml.jackson.core.type.TypeReference;
import main.java.com.sistemafinanceiro.Class.Enterprise;
import main.java.com.sistemafinanceiro.Class.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionHistory {

    static Scanner input = new Scanner(System.in);

    // CONVERTE DADOS EM JAVA PARA JSON
    static ObjectMapper mapper = new ObjectMapper();

    // CRIA O CAMINHO PARA A PASTA DESEJADA
    static File file_transaction = new File("src/main/java/data/Transaction.json");
    static File file_enterprise = new File("src/main/java/data/Enterprise.json");

    //DEPÓSITO
    public static void deposit(){

        try {
            
            //LISTA DAS TRANSAÇÕES
            List<Transaction> transaction_list;
            if (file_transaction.exists()){

                transaction_list = mapper.readValue(file_transaction, new TypeReference<List<Transaction>>(){});

            } else {

                transaction_list = new ArrayList<>();

            }

            // FORMULARIO DE TRANSAÇÃO
            System.out.println("---Transação---");
            System.out.println("Qual transação deseja efetuar? \n1. Depósito \n2. Saque");
            int prompt_answer = Integer.parseInt(input.nextLine());

            // SE A ESCOLHA FOR DEPÓSITO
            if (prompt_answer == 1){

                // VERIFICA SE O ARQUIVO JSON DA EMPRESA
                if (file_enterprise.exists()){

                    // LE O ARQUIVO
                    List<Enterprise> enterprise_list = mapper.readValue(

                        file_enterprise, 
                        mapper.getTypeFactory().constructCollectionType(List.class, Enterprise.class)

                    );

                    // MOSTRA AS EMPRESAS REGISTRADAS PARA O USUARIO ESCOLHER FAZER DEPÓSITO
                    int i = 1;
                    System.out.println("Qual empresa vc deseja fazer o deposito? (Reescreva o nome da empresa)");
                    for (Enterprise enterprise : enterprise_list){

                        System.out.printf("%d. %s\n", i,enterprise.getName());
                        i++;

                    }
                    String prompt_enterprise = input.nextLine();

                    System.out.println("Qual valor deseja depositar?");
                    double prompt_value = Float.parseFloat(prompt_enterprise);
                    

                    Transaction new_Transaction = new Transaction();

                    
                    for (Enterprise enterprise : enterprise_list){
                        if (enterprise.getName() == prompt_enterprise){
                            new_Transaction.setId_enterprise(enterprise.getId());
                            new_Transaction.setType("Depósito");
                            new_Transaction.setValue(prompt_value);
                        }
                    }




                } else {
                    
                    System.out.println("---Nenhuma empresa registrada!---");

                }


                
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
