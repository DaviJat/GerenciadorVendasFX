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
import model.Fornecedor;

/**
 * Classe Controller do Menu de Fornecedores
 * @author Davi
 *
 */
public class FornecedorMenuController {
	
	@FXML
    private Button btnAtualizaLista;

    @FXML
    private Button btnCadastrarFornecedor;

    @FXML
    private Button btnEditarFornecedor;

    @FXML
    private Button btnExcluirFornecedor;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Fornecedor, String> colunaCNPJ;

    @FXML
    private TableColumn<Fornecedor, String> colunaCodigo;

    @FXML
    private TableColumn<Fornecedor, String> colunaEndereco;

    @FXML
    private TableColumn<Fornecedor, String> colunaNome;

    @FXML
    private TableView<Fornecedor> tabelaFornecedores;
    
    ObservableList<Fornecedor> listaFornecedores = FXCollections.observableArrayList(Fornecedor.getListaFornecedor());
    
    /**
     * Insere os Fornecedores na tabela na inicialização da tela
     */
    @FXML
    public void initialize() {
    	
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
        colunaCNPJ.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("endereco"));

        tabelaFornecedores.setItems(listaFornecedores);
    }
    
    /**
     * Atualiza tabela de Fornecedores
     * @param event
     */
    @FXML
    void atualizarLista(ActionEvent event) {
    	listaFornecedores.clear();
    	
    	listaFornecedores = FXCollections.observableArrayList(Fornecedor.getListaFornecedor());
    	
    	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
        colunaCNPJ.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("endereco"));
    	
        tabelaFornecedores.setItems(listaFornecedores);
    }
    
    /**
     * Volta para a tela de Menu de Gerenciamentos
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
     * Abre tela de Cadastro de Fornecedores
     * @param event
     * @throws IOException
     */
    @FXML
    void cadastrarFornecedor(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/FornecedorCadastroView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Edição de Fornecedores
     * @param event
     * @throws IOException
     */
    @FXML
    void editarFornecedor(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/FornecedorEdicaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Edição");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Exclusão de Fornecedores
     * @param event
     * @throws IOException
     */
    @FXML
    void excluirFornecedor(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/FornecedorExclusaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Exclusão");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}
