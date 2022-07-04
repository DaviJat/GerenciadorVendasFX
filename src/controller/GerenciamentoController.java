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

/**
 * Classe Controller do Menu de Gerenciamentos
 * @author Davi
 *
 */
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

    /**
     * Abre tela de menu de Usuários
     * @param event
     * @throws IOException
     */
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
    
    /**
     * Abre tela de Menu de Fornecedores
     * @param event
     * @throws IOException
     */
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
    
    /**
     * Abre tela de menu de Produtos
     * @param event
     * @throws IOException
     */
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
    
    /**
     * Abre tela de menu de Itens
     * @param event
     * @throws IOException
     */
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
    
    /**
     * Abre tela de menu de Vendas
     * @param event
     * @throws IOException
     */
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
    
    /**
     * Abre tela de menu de Clientes
     * @param event
     * @throws IOException
     */
    @FXML
    void abrirMenuClientes(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ClienteMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Itens");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de menu de Relatórios
     * @param event
     * @throws IOException
     */
    @FXML
    void abrirMenuRelatorios(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/RelatorioMenuView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Relatórios");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Volta para a Tela de Login
     * @param event
     * @throws IOException
     */
    @FXML
    void sair(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}
