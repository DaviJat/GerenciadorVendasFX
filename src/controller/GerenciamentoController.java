package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GerenciamentoController {

    @FXML
    private Button btnFornecedores;

    @FXML
    private Button btnItens;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnRelatorios;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Button btnVendas;
    
    @FXML
    private Button btnClientes;

    
    @FXML
    void menuUsuarios(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/UsuarioMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Usu�rio");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}