package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe Controller do Cadastro de Fornecedores
 * @author Davi
 *
 */
public class FornecedorCadastroController {
	
	/**
	 * Valor inicial do código do Fornecedor
	 */
	static int contadorCodigo = 2;
	
	/**
	 * Gera o próximo código a ser utilizado no cadastro
	 */
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
    
    /**
     * Verifica se os inputs foram preenchidos e cadastra um novo Fornecedor com os valores inseridos
     * @param event
     */
    @FXML
    void salvaCadastroFornecedor(ActionEvent event) {
    	
    	String nome = inputFornecedorCadastro.getText();
		String cnpj = inputCNPJCadastro.getText();
		String endereco = inputEnderecoCadastro.getText();
	    
	    if (nome == "" || cnpj == "" || endereco == "") {
	    	
    		msgErro.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	} else {
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		Facade.cadastrarFornecedor(codigo, nome, cnpj, endereco);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }
	
}
