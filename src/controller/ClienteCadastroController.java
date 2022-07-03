package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClienteCadastroController {
	
	static int contadorCodigo = 0;
	
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
