package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UsuarioMenuController{
	
	@FXML
    private Button btnCadastrarUsuario;

    @FXML
    private Button btnEditarUsuario;

    @FXML
    private Button btnExcluirUsuario;
	
    @FXML
    private Button btnVoltar;

    @FXML
    private Pane telaUsuario;
    
    @FXML
    void cadastrarUsuario(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/UsuarioCadastroView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void editarUsuario(ActionEvent event) {

    }

    @FXML
    void excluirUsuario(ActionEvent event) {

    }
    
    @FXML
    void bntVoltar(ActionEvent event) {

    }
    
}
