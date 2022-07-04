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
import model.Item;

/**
 * Classe Controller do Menu de Itens
 * @author Davi
 *
 */
public class ItemMenuController {

	@FXML
    private Button btnAtualizaLista;

    @FXML
    private Button btnCadastrarItem;

    @FXML
    private Button btnEditarItem;

    @FXML
    private Button btnExcluirItem;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Item, String> colunaCategoria;

    @FXML
    private TableColumn<Item, String> colunaCodigo;

    @FXML
    private TableColumn<Item, String> colunaDescricao;

    @FXML
    private TableColumn<Item, String> colunaNome;

    @FXML
    private TableColumn<Item, String> colunaPreco;

    @FXML
    private TableColumn<Item, String> colunaProdutos;

    @FXML
    private TableView<Item> tabelaItens;
    
    ObservableList<Item> listaItens = FXCollections.observableArrayList(Item.getListaItem());
    
    /**
     * Carrega os valores da tabela de itens na inicialização da tela
     */
    @FXML
    public void initialize() {
    	
    	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Item, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Item, String>("nome"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<Item, String>("preco"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Item, String>("descricao"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<Item, String>("categoria"));
        colunaProdutos.setCellValueFactory(new PropertyValueFactory<Item, String>("listaProdutosQuantidades"));

        tabelaItens.setItems(listaItens);
    }
    
    /**
     * Atualiza tabela de Itens
     * @param event
     */
    @FXML
    void atualizarLista(ActionEvent event) {
    	
    	listaItens.clear();
    	
    	listaItens = FXCollections.observableArrayList(Item.getListaItem());
    	
    	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Item, String>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Item, String>("nome"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<Item, String>("preco"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Item, String>("descricao"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<Item, String>("categoria"));
        colunaProdutos.setCellValueFactory(new PropertyValueFactory<Item, String>("listaProdutosQuantidades"));

        tabelaItens.setItems(listaItens);
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
    
    /**
     * Abre tela de Cadastro de Itens
     * @param event
     * @throws IOException
     */
    @FXML
    void cadastrarItem(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ItemCadastroView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de edição de Itens
     * @param event
     * @throws IOException
     */
    @FXML
    void editarItem(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ItemEdicaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Exlusão de Itens
     * @param event
     * @throws IOException
     */
    @FXML
    void excluirItem(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/ItemExclusaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Exclusão");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}
