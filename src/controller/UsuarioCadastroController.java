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
import model.Usuario;

public class UsuarioCadastroController {
	
	static int contadorCodigo = 1;
	
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
    
    @FXML
    void initialize() {
    	
    	selectCargoUsuario.setItems(listaCargos);
    	
    }
    
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
    		
    		Usuario novoUsuario = new Usuario(codigo, nome, senha, cargo);
    		Usuario.cadastrar(novoUsuario);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}
		  	
    }

}
