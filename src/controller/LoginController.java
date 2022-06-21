package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;


public class LoginController {
	
	@FXML
    private Button btnLogin;

    @FXML
    private TextField inputSenhaLogin;

    @FXML
    private TextField inputUsuarioLogin;
    
    @FXML
    private Label msgErro;
    
    public static String usuarioLogado; 

    @FXML
    void login(ActionEvent event) throws IOException {
    	
    	String codigo = inputUsuarioLogin.getText();
    	String senha = inputSenhaLogin.getText();
    	
    	if (codigo == "" || senha == "") {
    		msgErro.setText("");
    		msgErro.setText("Preencha todos os campos!");
    	} else {
    		boolean validaLogin = Usuario.validaUsuarioLogin(codigo, senha);
    		if (validaLogin == true) {
    			msgErro.setText("");
    			msgErro.setText("Login inválido! Tente novamente");
    			msgErro.setVisible(true);
    		} else if (validaLogin == false) {
    			Object root = FXMLLoader.load(getClass().getResource("/view/GerenciamentoView.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene((Parent) root);
                stage.setTitle("Menu Gerenciamento");
                stage.setScene(scene);
                stage.show();
    		}
    	}
    }
}
