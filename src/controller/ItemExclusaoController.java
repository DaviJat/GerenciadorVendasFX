package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Item;

public class ItemExclusaoController {

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnPesquisaCodigoItem;

    @FXML
    private TextField inputCodigoExclusao;

    @FXML
    private TextField inputNomeItem;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label msgErro;

    @FXML
    void excluirProduto(ActionEvent event) {
    	
    	if (inputCodigoExclusao.getText() != "") {
    		
    		String codigo = inputCodigoExclusao.getText();
    		
    		Facade.excluirItem(codigo);
    		
    		Stage stage = (Stage)btnExcluir.getScene().getWindow();
    	    stage.close();
    		
    	}

    }

    @FXML
    void pesquisarCodigoItem(ActionEvent event) {
    	
    	String codigo = inputCodigoExclusao.getText();
    	
    	if (Facade.validaItem(codigo)) {
    		
    		msgErro.setText("");
    		
    		ArrayList<Item> listaItem = Item.getListaItem();
    		
    		int index = Facade.buscaItem(codigo);
    		
    		inputNomeItem.setText(listaItem.get(index).getNome());
    		
    		inputCodigoExclusao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoItem.setDisable(true);
    		btnExcluir.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Item não encontrado");
    		
    	}

    }

}
