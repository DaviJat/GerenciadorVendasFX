package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Usuario;

/**
 * Classe Controller do Menu de Usu�rios
 * @author Davi
 *
 */
public class UsuarioMenuController{
	
	@FXML
    private Button btnCadastrarUsuario;

    @FXML
    private Button btnEditarUsuario;

    @FXML
    private Button btnExcluirUsuario;

    @FXML
    private Button btnAtualizaLista;
	
    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<Usuario> tabelaUsuarios;
    
    @FXML
    private TableColumn<Usuario, String> colunaCargo;

    @FXML
    private TableColumn<Usuario, String> colunaCodigo;

    @FXML
    private TableColumn<Usuario, String> colunaNome;
    
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList(Usuario.getListaUsuario());
    
    /**
     * Insere os Usu�rios na tabela na inicializa��o da tela
     */
    @FXML
    public void initialize() {
    	
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("cargo"));

        tabelaUsuarios.setItems(listaUsuarios);
    }
    
    /**
     * Abre tela de Cadastro de Usu�rios
     * @param event
     * @throws IOException
     */
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
    
    /**
     * Abre tela de Edi��o de Usu�rios
     * @param event
     * @throws IOException
     */
    @FXML
    void editarUsuario(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/UsuarioEdicaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Edi��o");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Exclus�o de Usu�rios
     * @param event
     * @throws IOException
     */
    @FXML
    void excluirUsuario(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/UsuarioExclusaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Exclus�o");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Atualiza tabela de Usu�rios
     * @param event
     */
    @FXML
    void atualizarLista(ActionEvent event) {
    	listaUsuarios.clear();
    	
    	listaUsuarios = FXCollections.observableArrayList(Usuario.getListaUsuario());
    	
    	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("cargo"));
    	
    	tabelaUsuarios.setItems(listaUsuarios);
    	
    }
    
    /** 
     * Volta para o menu de Gerenciamentos
     * @param event
     * @throws IOException
     */
    @FXML
    void bntVoltar(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/GerenciamentoView.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Menu Gerenciamento");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
}
