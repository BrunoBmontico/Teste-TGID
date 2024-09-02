package main.java.com.sistemafinanceiro.Controller;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

// VALIDA O CNPJ E CPF
public class DocValidator {
    
    // CNPJ
    public static boolean isCnpjValid(String cnpj){

        CNPJValidator validator = new CNPJValidator();

        try{

            validator.assertValid(cnpj);
            return true;

        } catch (InvalidStateException e){

            return false;

        }
        
    }

    // CPF
    public static boolean isCpfValid(String cpf){

        CPFValidator validator = new CPFValidator();

        try {
            
            validator.assertValid(cpf);
            return true;

        } catch (InvalidStateException e) {

            return false;

        }

    }
    
}
