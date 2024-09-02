package main.java.com.sistemafinanceiro.Controller;
import com.fasterxml.jackson.core.type.TypeReference;
import main.java.com.sistemafinanceiro.Class.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;

public class CreateClient {
    static Scanner input = new Scanner(System.in);

    // CONVERTE DADOS EM JAVA PARA JSON
    static ObjectMapper mapper = new ObjectMapper();

    // CRIA O CAMINHO PARA A PASTA DESEJADA
    static File file = new File("src/main/java/data/Cliente.json");

    // REGISTRO DOS CLIENTES
    public static void create_object(){

        try {

            //LE O CONTEUDO DO ARQUIVO E REESCREVE COM O NOVO OBJ, CASO NAO EXISTA CRIA UM NOVO (nao pode existir um arquivo json vazio).
            // "cliente_list" armazena a lista em formato exclusivo para objetos tipo "Cliente"
            List<Customer> cliente_list;
            if (file.exists()){

                cliente_list = mapper.readValue(file, new TypeReference<List<Customer>>(){});

            } else {

                cliente_list = new ArrayList<>();

            }

            // FORMULARIO DE REGISTRO DO CLIENTE
            System.out.println("---Registrar Cliente---");
            System.out.println("Nome do Cliente:");
            String nome_Cliente = input.nextLine();
            System.out.println("CPF do Cliente:");
            String CPF = input.nextLine();
            System.out.println("Senha de usuario:");
            String senha_usuario = input.nextLine();

            // NOVO OBJ EMPRESA
            Customer novo_cliente = new Customer();

            // VERIFICA SE O CNPJ DA EMPRESA É VALIDO
            if (DocValidator.isCpfValid(CPF)){

                novo_cliente.setName(nome_Cliente);
                novo_cliente.setCPF(CPF);
                novo_cliente.setSaldo(00);
                novo_cliente.setPassword(senha_usuario);

                // ADICIONA A NOVA EMPRESA NA LISTA
                cliente_list.add(novo_cliente);

                //REESCREVE A LISTA NO ARQUIVO JSON
                mapper.writeValue(file, cliente_list);

                System.out.println("---Cliente adicionado com sucesso!---");
                
            } else {

                //MENSAGEM CASO CPF SEJA INVALIDO
                System.out.println("CPF inválido!");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
