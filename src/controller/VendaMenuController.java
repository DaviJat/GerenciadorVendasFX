package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    private TableColumn<?, ?> colunaCliente;

    @FXML
    private TableColumn<?, ?> colunaCodigo;

    @FXML
    private TableColumn<?, ?> colunaData;

    @FXML
    private TableColumn<?, ?> colunaFormaPagamento;

    @FXML
    private TableColumn<?, ?> colunaHora;

    @FXML
    private TableColumn<?, ?> colunaItens;

    @FXML
    private TableColumn<?, ?> colunaPreco;

    @FXML
    private TableView<?> tabelaVendas;

    @FXML
    void atualizarLista(ActionEvent event) {

    }

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

    @FXML
    void editarVenda(ActionEvent event) {

    }

    @FXML
    void excluirVenda(ActionEvent event) {

    }

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
