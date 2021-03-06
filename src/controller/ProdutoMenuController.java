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
import model.Produto;

/**
 * Classe Controller do Menu de Produtos
 * @author Davi
 *
 */
public class ProdutoMenuController {
	
	@FXML
    private Button btnAtualizaLista;

    @FXML
    private Button btnCadastrarProduto;

    @FXML
    private Button btnEditarProduto;

    @FXML
    private Button btnExcluirProduto;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Produto, String> colunaCodigo;

    @FXML
    private TableColumn<Produto, String> colunaEstoque;

    @FXML
    private TableColumn<Produto, String> colunaFornecedor;

    @FXML
    private TableColumn<Produto, String> colunaNome;

    @FXML
    private TableColumn<Produto, String> colunaPreco;

    @FXML
    private TableColumn<Produto, String> colunaValidade;

    @FXML
    private TableView<Produto> tabelaProdutos;
    
    ObservableList<Produto> listaProdutos = FXCollections.observableArrayList(Produto.getListaProduto());
    
    /**
     * Carrega tabela de produtos com os dados salvos, logo na inicialização da tela
     */
    @FXML
    public void initialize() {
    	
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<Produto, String>("preco"));
        colunaValidade.setCellValueFactory(new PropertyValueFactory<Produto, String>("validade"));
        colunaEstoque.setCellValueFactory(new PropertyValueFactory<Produto, String>("estoque"));
        colunaFornecedor.setCellValueFactory(new PropertyValueFactory<Produto, String>("nomeFornecedor"));

        tabelaProdutos.setItems(listaProdutos);
    }
    
    /**
     * Atualiza tabela de Produtos
     * @param event
     */
    @FXML
    void atualizarLista(ActionEvent event) {
    	
    	listaProdutos.clear();
    	
    	listaProdutos = FXCollections.observableArrayList(Produto.getListaProduto());
    	
    	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<Produto, String>("preco"));
        colunaValidade.setCellValueFactory(new PropertyValueFactory<Produto, String>("validade"));
        colunaEstoque.setCellValueFactory(new PropertyValueFactory<Produto, String>("estoque"));
        colunaFornecedor.setCellValueFactory(new PropertyValueFactory<Produto, String>("nomeFornecedor"));
    	
        tabelaProdutos.setItems(listaProdutos);
    }
    
    /**
     * Abre tela de Cadastro de Produtos
     * @param event
     * @throws IOException
     */
    @FXML
    void cadastrarProduto(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ProdutoCadastroView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Edição de Produtos
     * @param event
     * @throws IOException
     */
    @FXML
    void editarProduto(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ProdutoEdicaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Edição");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Exclusão de Produtos
     * @param event
     * @throws IOException
     */
    @FXML
    void excluirProduto(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ProdutoExclusaoView.fxml"));
    	Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Exclusão");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
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
