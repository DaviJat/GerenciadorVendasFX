package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe Controller do Cadastro de Usuários
 * @author Davi
 *
 */
public class UsuarioCadastroController {
	
	/**
	 * Valor inicial do código do cliente
	 */
	static int contadorCodigo = 1;
	
	/**
	 * Gera o próximo código a ser utilizado no cadastro
	 */
	public static void geraCodigo() {
		contadorCodigo ++;
	}
	
	ObservableList<String> listaCargos = FXCollections.observableArrayList("Gerente", "Funcionário");
    
    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputSenhaCadastro;

    @FXML
    private TextField inputUsuarioCadastro;
    
    @FXML
    private ChoiceBox<String> selectCargoUsuario;
    
    @FXML
    private Label msgErro;
    
    /**
     * Carrega os cargos de Usuário para preencher a choice box, na inicialização da tela
     */
    @FXML
    void initialize() {
    	
    	selectCargoUsuario.setItems(listaCargos);
    	
    }
    
    /** 
     * Verifica se os dados foram preenchidos e salva o novo Usuário
     * @param event
     */
    @FXML
    void salvaCadastroUsuario(ActionEvent event) {
    	
		String nome = inputUsuarioCadastro.getText();
		String senha = inputSenhaCadastro.getText();
		String cargo = selectCargoUsuario.getSelectionModel().getSelectedItem();
	    
	    if (nome == "" || senha == "" || cargo == null) {
	    	
    		msgErro.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	} else {
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		Facade.cadastroUsuario(codigo, nome, senha, cargo);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}
		  	
    }

}
