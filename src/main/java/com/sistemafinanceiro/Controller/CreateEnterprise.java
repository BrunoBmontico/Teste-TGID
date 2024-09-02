package main.java.com.sistemafinanceiro.Controller;
import main.java.com.sistemafinanceiro.Class.Enterprise;
import main.java.com.sistemafinanceiro.Class.Tax;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class CreateEnterprise {

    //OBJ PARA ENTRADA DE INFORMAÇÃO, INPUT
    static Scanner input = new Scanner(System.in);

    // CONVERTE DADOS EM JAVA PARA JSON
    static ObjectMapper mapper = new ObjectMapper();

    // NOVO OBJ EMPRESA
    static Enterprise new_enterprise = new Enterprise();

    //FUNÇÃO PARA PADRONIZAR O CAMINHO DOS ARQUIVOS JSON
    public static File pathJSON(String pathname){
        
        // CRIA O CAMINHO PARA A PASTA DESEJADA
        File file = new File("src/main/java/data/" + pathname);

        return file;
    }

    // REGISTRO DAS EMPRESAS
    public static void create_object(){
        try {
            File file = pathJSON("Enterprise.json");

            //LE O CONTEUDO DO ARQUIVO E REESCREVE COM O NOVO OBJ, CASO NAO EXISTA CRIA UM NOVO (nao pode existir um arquivo json vazil).
            // "empresa_list" armazena a lista em formato exclusivo para objetos tipo "Empresa"
            List<Enterprise> enterprise_list;
            if (file.exists()){

                enterprise_list = mapper.readValue(file, new TypeReference<List<Enterprise>>(){});

            } else {

                enterprise_list = new ArrayList<>();

            }

            // FORMULARIO DE REGISTRO DAS EMPRESAS
            System.out.println("---Registrar Empresa---");
            System.out.println("Nome da empresa:");
            String enterpise_name = input.nextLine();
            System.out.println("CPNPJ da empresa:");
            String CNPJ = input.nextLine();
            System.out.println("Porcentagem aplicada no saque:");

            // VERIFICA SE O CNPJ DA EMPRESA É VALIDO
            if (DocValidator.isCnpjValid(CNPJ)){

                new_enterprise.setName(enterpise_name);
                new_enterprise.setCNPJ(CNPJ);
                new_enterprise.setBalance(1000.00);
                
                // ADICIONA A NOVA EMPRESA NA LISTA
                enterprise_list.add(new_enterprise);

                //REESCREVE A LISTA NO ARQUIVO JSON
                mapper.writeValue(file, enterprise_list);

                //MENSAGEM DE SUCESSO
                System.out.println("---Empresa adicionada com sucesso!---");
                
            } else {

                //MENSAGEM CASO O CNPJ SEJA INVALIDO
                System.out.println("CNPJ inválido!");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //DEFINE AS TAXAS DE TRANSAÇÕES
    public static void configTax(){
        try {

            //LOCAL DO ARQUIVO ONDE ARMAZENA AS TAXAS
            File file = pathJSON("Tax.json");

            //LISTA DAS TAXAS
            List<Tax> tax_list;
            if (file.exists()){

                tax_list = mapper.readValue(file, new TypeReference<List<Tax>>(){});

            } else {

                tax_list = new ArrayList<>();

            }

            //FORMULARIO DE ESCOLHA DAS TAXAS
            System.out.println("Deseja aplicar uma taxa de transação?\n1. Sim \n2. Não");
            int prompt_answer = Integer.parseInt(input.nextLine());

            //CONDIÇÃO DEPENDENDO DA RESPOSTA
            if (prompt_answer == 1){

                System.out.println("Você deseja?\n1. Taxa igual em ambas Transações. \n2. Taxas diferentes");
                int prompt_tax = Integer.parseInt(input.nextLine());

                //CASO A RESPOSTA DO USUARIO SEJA IGUAL A 1
                if (prompt_tax == 1){

                    System.out.println("Valor a ser taxado:");
                    double value_tax = Float.parseFloat(input.nextLine());
                    
                    //FOR PARA ADICIONAR DUAS TAXAS COM VALORES IGUAIS
                    for (int i = 1; i <= 2; i++){

                        Tax new_tax = new Tax();
    
                        new_tax.setForeignkey(new_enterprise.getId());
                        new_tax.setValue(value_tax);
    
                        if (i == 1){

                            new_tax.setType("Depósito");
                            
                        } else if (i == 2) {

                            new_tax.setType("Saque");
                            
                        }
                        tax_list.add(new_tax);
                    }

                    //REESCREVE A LISTA NO ARQUIVO JSON
                    mapper.writeValue(file, tax_list);

                    //MENSAGEM DE SUCESSO
                    System.out.println("---Taxa registrada com sucesso!---");  

                //CASO A RESPOSTA DO USUARIO SEJA IGUAL A 2    
                } else if (prompt_tax == 2){

                    String[] type_tax = {"Depósito","Saque"};
                    int indice = 0; 
                    
                    //FOR PARA ADICIONAR DUAS TAXAS COM VALORES DIFERENTES
                    for (int i = 1; i <= 2; i++){

                        System.out.printf("Valor a ser taxado no %s:", type_tax[indice]);
                        double value_tax = Float.parseFloat(input.nextLine());
    
                        Tax new_tax = new Tax();
    
                        new_tax.setForeignkey(new_enterprise.getId());
    
                        if (i == 1){

                            new_tax.setValue(value_tax);
                            new_tax.setType("Depósito");
        
                        } else if (i == 2) {

                            new_tax.setValue(value_tax);
                            new_tax.setType("Saque");
                            
                        }

                        tax_list.add(new_tax);
                        indice++;
                        
                    }

                    //REESCREVE A LISTA NO ARQUIVO JSON
                    mapper.writeValue(file, tax_list);

                    //MENSAGEM DE SUCESSO
                    System.out.println("---Taxa registrada com sucesso!---");  

                }

            }else if (prompt_answer == 2){

                //MENSAGEM CASO O A EMPRESA ESCOLHA NAO TAXAR AS TRANSAÇÕES
                System.out.println("---Nenhuma taxa adicionada, cadastro da empresa concluído---");

            } else {
                
                //MENSAGEM CASO SEJA DIGITADO ALGO NAO ESPERADO
                System.out.println("comando invalido");

            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
