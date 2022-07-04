package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Geral;
import model.Item;

/**
 * Classe Controller da Edição de Itens
 * @author Davi
 *
 */
public class ItemEdicaoController {

	@FXML
    private Button btnPesquisaCodigoItem;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCategoriaEdicao;

    @FXML
    private TextField inputCodigoItemEdicao;

    @FXML
    private TextField inputDescricaoEdicao;

    @FXML
    private TextField inputNomeItemEdicao;

    @FXML
    private TextField inputPrecoEdicao;

    @FXML
    private Label labelCategoria;

    @FXML
    private Label labelCodigoItem;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label labelNomeItem;

    @FXML
    private Label labelPreco;

    @FXML
    private Label msgErro;

    @FXML
    private Label msgErroPreco;

    /**
     * Pega o código do item digitado pelo usuário, habilita e preenche os inputs com os dados do cliente, se o código for válido
     * @param event
     */
    @FXML
    void pesquisarCodigoItem(ActionEvent event) {
    	
    	String codigo = inputCodigoItemEdicao.getText();
    	
    	if (Facade.validaItem(codigo)) {
    		
    		msgErro.setText("");
    		
    		inputNomeItemEdicao.setDisable(false);
    		inputPrecoEdicao.setDisable(false);
    		inputCategoriaEdicao.setDisable(false);
    		inputDescricaoEdicao.setDisable(false);
    		
    		labelNomeItem.setDisable(false);
    		labelPreco.setDisable(false);
    		labelCategoria.setDisable(false);
    		labelDescricao.setDisable(false);
    		
    		inputCodigoItemEdicao.setDisable(true);
    		labelCodigoItem.setDisable(true);
    		
    		btnPesquisaCodigoItem.setDisable(true);
    		 
    		ArrayList<Item> listaItens = Item.getListaItem();
    		
    		int index = Facade.buscaItem(codigo);
    		
    		String nomeItem = listaItens.get(index).getNome();
    		double preco = listaItens.get(index).getPreco();
    		String categoria = listaItens.get(index).getCategoria();
    		String descricao = listaItens.get(index).getDescricao();
    		
    		inputNomeItemEdicao.setText(nomeItem);
    		inputPrecoEdicao.setText(Double.toString(preco));
    		inputCategoriaEdicao.setText(categoria);
    		inputDescricaoEdicao.setText(descricao);
    		
    		btnSalvar.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Item não encontrado");
    		
    	}

    }
    
    /**
     * Verifica se os inputs foram preenchidos com valores válidos e salva o Item com os novos dados
     * @param event
     */
    @FXML
    void salvaCadastroItem(ActionEvent event) {
    	
    	if (inputCodigoItemEdicao.getText() != "") {
    		
    		String codigo = inputCodigoItemEdicao.getText();
    		String nomeItem = inputNomeItemEdicao.getText();
    		String preco = inputPrecoEdicao.getText();
    		String categoria = inputCategoriaEdicao.getText();
    		String descricao = inputDescricaoEdicao.getText();
    		
    		double precoFormatado = Geral.validaDouble(preco);
    	    
        	if (nomeItem == "" || preco == "" || categoria == "" || descricao == "") {
        		
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErro.setText("Preencha todos os campos!");
        		
        	} else if (precoFormatado < 0) {
    	    	
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErroPreco.setText("Valor Inválido");
        		
        	}  else {
        		
        		Facade.editarItem(codigo, nomeItem, precoFormatado, categoria, descricao);
        		
        		Stage stage = (Stage)btnSalvar.getScene().getWindow();
        	    stage.close();
        	    
        	}
        	
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o código do Item!");
    		
    	}

    }

}
