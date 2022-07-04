package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe Controller do Cadastro de Clientes
 * @author Davi
 *
 */
public class ClienteCadastroController {
	
	/**
	 * Valor inicial do código do cliente
	 */
	static int contadorCodigo = 0;
	
	/**
	 * Gera o próximo código a ser utilizado no cadastro
	 */
	public static void geraCodigo() {
		contadorCodigo ++;
	}

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCpfCadastro;

    @FXML
    private TextField inputClienteCadastro;

    @FXML
    private TextField inputEmailCadastro;

    @FXML
    private TextField inputTelefoneCadastro;

    @FXML
    private Label msgErro;
    
    /**
     * Verifica se os inputs foram preenchidos gera um código e cadastra um novo cliente 
     * @param event
     */
    @FXML
    void salvaCadastroCliente(ActionEvent event) {
    	
    	String nome = inputClienteCadastro.getText();
		String cpf = inputCpfCadastro.getText();
		String email = inputEmailCadastro.getText();
		String telefone = inputTelefoneCadastro.getText();
	    
	    if (nome == "" || cpf == "" || email == "" || telefone == "")  {
	    	
    		msgErro.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	} else {
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		Facade.cadastrarCliente(codigo, nome, cpf, email, telefone);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }

}
