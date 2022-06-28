package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Geral;
import model.Produto;

public class ItemCadastroController {
	
	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	ArrayList<String> listaQuantidades = new ArrayList<String>();

	@FXML
    private Button btnAdicionarProduto;

    @FXML
    private Button btnPesquisaCodigoProduto;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCategoriaCadastro;

    @FXML
    private TextField inputCodigoProdutoCadastro;

    @FXML
    private TextField inputDescricaoCadastro;

    @FXML
    private TextField inputItemCadastro;

    @FXML
    private TextField inputNomeProdutoCadastro;

    @FXML
    private TextField inputPrecoCadastro;

    @FXML
    private TextField inputQuantidadeProdutoCadastro;

    @FXML
    private Label labelCodigoProduto;

    @FXML
    private Label msgErro;

    @FXML
    private Label msgErroPreco;

    @FXML
    private Label msgErroProduto;

    @FXML
    private Label msgErroQuantidade;


    @FXML
    void adicionarProduto(ActionEvent event) {
    	
    	String nomeProduto = inputNomeProdutoCadastro.getText();
    	String quantidadeProduto = inputQuantidadeProdutoCadastro.getText();
    	
    	double quantidadeFormatada = Geral.validaDouble(quantidadeProduto);
    	
    	if (quantidadeProduto == "" || nomeProduto == "") {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		msgErro.setText("Selecione um produto e digite a quantidade");
    		
    	} else if (quantidadeFormatada < 0) {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		msgErroQuantidade.setText("Valor Inválido");
    	
    	} else {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		
    		String codigoProduto = inputCodigoProdutoCadastro.getText();
    		
    		int indexProduto = Produto.buscaProduto(codigoProduto);
			listaProdutos.add(Produto.getProduto(indexProduto));
			
			listaQuantidades.add(quantidadeProduto);
    		
    		
    		inputQuantidadeProdutoCadastro.setText("");
    		inputNomeProdutoCadastro.setText("");
    		inputCodigoProdutoCadastro.setText("");
    		inputCodigoProdutoCadastro.setEditable(true);
    		System.out.println(listaQuantidades);
    		System.out.println(listaProdutos);
    	}
    	
    	
    }

    @FXML
    void pesquisarCodigoProduto(ActionEvent event) {
    	
    	String codigoProduto = inputCodigoProdutoCadastro.getText();
    	
    	if (Produto.validaProduto(codigoProduto)) {
    		
    		msgErroProduto.setText("");
    		
    		ArrayList<Produto> listaProdutos = Produto.getListaProduto();
    		
    		int index = Produto.buscaProduto(codigoProduto);
    		
    		inputNomeProdutoCadastro.setText(listaProdutos.get(index).getNome());
    		
    		inputCodigoProdutoCadastro.setEditable(false);
    		
    	} else {
    		inputNomeProdutoCadastro.setText("");
    		msgErroProduto.setText("Item não encontrado");
    	}
    	
    }

    @FXML
    void salvaCadastroItem(ActionEvent event) {

    }

}
