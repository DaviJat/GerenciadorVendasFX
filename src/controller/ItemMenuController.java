package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    private TableColumn<?, ?> colunaCategoria;

    @FXML
    private TableColumn<?, ?> colunaCodigo;

    @FXML
    private TableColumn<?, ?> colunaDescricao;

    @FXML
    private TableColumn<?, ?> colunaNome;

    @FXML
    private TableColumn<?, ?> colunaPreco;

    @FXML
    private TableColumn<?, ?> colunaProdutos;

    @FXML
    private TableColumn<?, ?> colunaQuantidades;

    @FXML
    private TableView<?> tabelaItens;

    @FXML
    void atualizarLista(ActionEvent event) {

    }

    @FXML
    void bntVoltar(ActionEvent event) {

    }

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

    @FXML
    void editarItem(ActionEvent event) {

    }

    @FXML
    void excluirItem(ActionEvent event) {

    }

}
