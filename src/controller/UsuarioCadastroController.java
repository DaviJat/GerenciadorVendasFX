package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

public class UsuarioCadastroController {
	
	static int contadorCodigo = 1;
	
	public static void geraCodigo() {
		contadorCodigo ++;
	}
	
	ObservableList<String> listaCargos = FXCollections.observableArrayList("Gerente", "Usuário");
    
    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputSenhaCadastro;

    @FXML
    private TextField inputUsuarioCadastro;
    
    @FXML
    private ChoiceBox<String> selectCargoUsuario;
    
    @FXML
    void initialize() {
    	
    	selectCargoUsuario.setItems(listaCargos);
    	
    }
    
    @FXML
    void salvaCadastroUsuario(ActionEvent event) {
		
		geraCodigo();
		
		String codigo = Integer.toString(contadorCodigo);
		String nome = inputUsuarioCadastro.getText();
		String senha = inputSenhaCadastro.getText();
		String gerente = selectCargoUsuario.getSelectionModel().getSelectedItem();
		
		Usuario novoUsuario = new Usuario(codigo, nome, senha, gerente);
		Usuario.cadastrar(novoUsuario);
		
		Stage stage = (Stage)btnSalvar.getScene().getWindow();
	    stage.close();
		  	
    }

}
