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
    void abrirMenuUsuarios(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/UsuarioMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Usuário");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    @FXML
    void abrirMenuFornecedores(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/FornecedorMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Fornecedores");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    @FXML
    void abrirMenuProdutos(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ProdutoMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Produtos");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    @FXML
    void abrirMenuItens(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ItemMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Itens");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    @FXML
    void abrirMenuVendas(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/VendaMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Itens");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    @FXML
    void abrirMenuClientes(ActionEvent event) {

    }
    
    @FXML
    void abrirMenuRelatorios(ActionEvent event) {

    }
    
    @FXML
    void sair(ActionEvent event) {

    }

}
