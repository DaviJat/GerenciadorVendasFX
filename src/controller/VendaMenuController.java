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
import model.Venda;

/**
 * Classe Controller do Menu de Vendas
 * @author Davi
 *
 */
public class VendaMenuController {

	@FXML
    private Button btnAtualizaLista;

    @FXML
    private Button btnEditarVenda;

    @FXML
    private Button btnExcluirVenda;

    @FXML
    private Button btnRegistrarVenda;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Venda, String> colunaCliente;

    @FXML
    private TableColumn<Venda, String> colunaCodigo;

    @FXML
    private TableColumn<Venda, String> colunaData;

    @FXML
    private TableColumn<Venda, String> colunaFormaPagamento;

    @FXML
    private TableColumn<Venda, String> colunaHora;

    @FXML
    private TableColumn<Venda, String> colunaItens;

    @FXML
    private TableColumn<Venda, String> colunaPreco;

    @FXML
    private TableView<Venda> tabelaVendas;
    
    ObservableList<Venda> listaVendas = FXCollections.observableArrayList(Venda.getListaVenda());
    
    /**
     * Insere as Vendas na tabela na inicialização da tela
     */
    @FXML
    public void initialize() {
    	
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<Venda, String>("codigo"));
        colunaCliente.setCellValueFactory(new PropertyValueFactory<Venda, String>("nomeCliente"));
        colunaData.setCellValueFactory(new PropertyValueFactory<Venda, String>("data"));
        colunaHora.setCellValueFactory(new PropertyValueFactory<Venda, String>("hora"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<Venda, String>("precoTotal"));
        colunaFormaPagamento.setCellValueFactory(new PropertyValueFactory<Venda, String>("formaPagamento"));
        colunaItens.setCellValueFactory(new PropertyValueFactory<Venda, String>("listaNomesItensVenda"));

        tabelaVendas.setItems(listaVendas);
    }
    
    /**
     * Atualizada Tabela de Vendas
     * @param event
     */
    @FXML
    void atualizarLista(ActionEvent event) {
    	
    	listaVendas.clear();
    	
    	listaVendas = FXCollections.observableArrayList(Venda.getListaVenda());
    	
    	colunaCodigo.setCellValueFactory(new PropertyValueFactory<Venda, String>("codigo"));
        colunaCliente.setCellValueFactory(new PropertyValueFactory<Venda, String>("nomeCliente"));
        colunaData.setCellValueFactory(new PropertyValueFactory<Venda, String>("data"));
        colunaHora.setCellValueFactory(new PropertyValueFactory<Venda, String>("hora"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<Venda, String>("precoTotal"));
        colunaFormaPagamento.setCellValueFactory(new PropertyValueFactory<Venda, String>("formaPagamento"));
        colunaItens.setCellValueFactory(new PropertyValueFactory<Venda, String>("listaNomesItensVenda"));

        tabelaVendas.setItems(listaVendas);
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
     * Abre tela de edição de Venda
     * @param event
     * @throws IOException
     */
    @FXML
    void editarVenda(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/VendaEdicaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Edição");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de Exclusão de Venda
     * @param event
     * @throws IOException
     */
    @FXML
    void excluirVenda(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/VendaExclusaoView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Exclusão");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * Abre tela de registro de Venda
     * @param event
     * @throws IOException
     */
    @FXML
    void registrarVenda(ActionEvent event) throws IOException {
    	Object root = FXMLLoader.load(getClass().getResource("/view/VendaCadastroView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}
