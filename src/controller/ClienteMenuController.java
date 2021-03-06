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
import model.Cliente;

/**
 * Classe Controller do Menu de Clientes
 * @author Davi
 *
 */
public class ClienteMenuController {

    @FXML
    private Button btnAtualizaLista;

    @FXML
    private Button btnCadastrarCliente;

    @FXML
    private Button btnEditarCliente;

    @FXML
    private Button btnExcluirCliente;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Cliente, String> colunaCPF;

    @FXML
    private TableColumn<Cliente, String> colunaCodigo;

    @FXML
    private TableColumn<Cliente, String> colunaEmail;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaTelefone;

    @FXML
    private TableView<Cliente> tabelaCliente;
    
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(Cliente.getListaCliente());
    
    /**
     * Insere os Clientes na tabela na inicialização da tela
     */
    @FXML
    public void initialize() {
    	
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        tabelaCliente.setItems(listaClientes);
    }
    /**
     * Atualiza tabela de Clientes
     * @param event
     */
    @FXML
    void atualizarLista(ActionEvent event) {
    	listaClientes.clear();
    	
    	listaClientes = FXCollections.observableArrayList(Cliente.getListaCliente());
    	
    	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        tabelaCliente.setItems(listaClientes);
    }
    
    /**
     * Volta para o Menu de Gerenciamentos
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
    
    /**
     * Abre tela de Cadastro de Clientes
     * @param event
     * @throws IOException
     */
    @FXML
    void cadastrarCliente(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ClienteCadastroView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Edição de Clientes
     * @param event
     * @throws IOException
     */
    @FXML
    void editarCliente(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ClienteEdicaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Edição");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * Abre tela de Exclusão de Clientes
     * @param event
     * @throws IOException
     */
    @FXML
    void excluirCliente(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ClienteExclusaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Exclusão");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}
