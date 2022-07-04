package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Produto;

/**
 * Classe Controller da Exclusão de Produtos
 * @author Davi
 *
 */
public class ProdutoExclusaoController {

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnPesquisaCodigoProduto;

    @FXML
    private TextField inputCodigoExclusao;

    @FXML
    private TextField inputNomeProduto;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label msgErro;
    
    /**
     * Exclui o produto com o código digitado
     * @param event
     */
    @FXML
    void excluirProduto(ActionEvent event) {
    	
    	if (inputCodigoExclusao.getText() != "") {
    		
    		String codigo = inputCodigoExclusao.getText();
    		
    		Facade.excluirProduto(codigo);
    		
    		Stage stage = (Stage)btnExcluir.getScene().getWindow();
    	    stage.close();
    		
    	}
    	
    }
    
    /**
     * Valida o código do produto, retorna o nome do produto e habilita o botão de exclusão, se o código for válido
     * @param event
     */
    @FXML
    void pesquisarCodigoProduto(ActionEvent event) {
    	
    	String codigo = inputCodigoExclusao.getText();
    	
    	if (Facade.validaProduto(codigo)) {
    		
    		msgErro.setText("");
    		
    		ArrayList<Produto> listaProdutos = Produto.getListaProduto();
    		
    		int index = Facade.buscaProduto(codigo);
    		
    		inputNomeProduto.setText(listaProdutos.get(index).getNome());
    		
    		inputCodigoExclusao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoProduto.setDisable(true);
    		btnExcluir.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Produto não encontrado");
    		
    	}

    }

}
