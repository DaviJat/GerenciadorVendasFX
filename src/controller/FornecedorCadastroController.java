package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Fornecedor;

public class FornecedorCadastroController {
	
	static int contadorCodigo = 0;
	
	public static void geraCodigo() {
		contadorCodigo ++;
	}

	@FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCNPJCadastro;

    @FXML
    private TextField inputEnderecoCadastro;

    @FXML
    private TextField inputFornecedorCadastro;

    @FXML
    private Label msgErro;

    @FXML
    void salvaCadastroUsuario(ActionEvent event) {
    	
    	String nome = inputFornecedorCadastro.getText();
		String cnpj = inputCNPJCadastro.getText();
		String endereco = inputEnderecoCadastro.getText();
	    
	    if (nome == "" || cnpj == "" || endereco == "") {
	    	
    		msgErro.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	} else {
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		Fornecedor novoFornecedor = new Fornecedor(codigo, nome, cnpj, endereco);
    		Fornecedor.cadastrar(novoFornecedor);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }
	
}
