package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Fornecedor;
import model.Geral;
import model.Produto;

public class ProdutoEdicaoController {

    @FXML
    private Button btnPesquisaCodigoFornecedor;

    @FXML
    private Button btnPesquisaCodigoProduto;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCodigoFornecedorEdicao;

    @FXML
    private TextField inputCodigoProdutoEdicao;

    @FXML
    private TextField inputEstoqueEdicao;

    @FXML
    private TextField inputNomeFornecedorEdicao;

    @FXML
    private TextField inputPrecoEdicao;

    @FXML
    private TextField inputNomeProdutoEdicao;

    @FXML
    private DatePicker inputValidadeEdicao;

    @FXML
    private Label labelCodigoFornecedor;

    @FXML
    private Label labelCodigoProduto;

    @FXML
    private Label labelEstoque;

    @FXML
    private Label labelNomeFornecedor;

    @FXML
    private Label labelNomeProduto;

    @FXML
    private Label labelPreco;

    @FXML
    private Label labelValidade;

    @FXML
    private Label msgErro;

    @FXML
    private Label msgErroEstoque;

    @FXML
    private Label msgErroFornecedor;

    @FXML
    private Label msgErroPreco;

    @FXML
    private Label msgErroValidade;

    @FXML
    void pesquisarCodigoFornecedor(ActionEvent event) {
    	
    	String codigoFornecedor = inputCodigoFornecedorEdicao.getText();
    	
    	if (Fornecedor.validaFornecedor(codigoFornecedor)) {
    		
    		msgErroFornecedor.setText("");
    		
    		ArrayList<Fornecedor> listaFornecedores = Fornecedor.getListaFornecedor();
    		
    		int index = Fornecedor.buscaFornecedor(codigoFornecedor);
    		
    		inputNomeFornecedorEdicao.setText(listaFornecedores.get(index).getNome());
    		
    	} else {
    		inputNomeFornecedorEdicao.setText("");
    		msgErroFornecedor.setText("Código Inválido");
    	}

    }

    @FXML
    void pesquisarCodigoProduto(ActionEvent event) {
    	
    	String codigo = inputCodigoProdutoEdicao.getText();
    	
    	if (Produto.validaProduto(codigo)) {
    		
    		msgErro.setText("");
    		
    		inputNomeProdutoEdicao.setDisable(false);
    		inputPrecoEdicao.setDisable(false);
    		inputValidadeEdicao.setDisable(false);
    		inputEstoqueEdicao.setDisable(false);
    		inputCodigoFornecedorEdicao.setDisable(false);
    		inputNomeFornecedorEdicao.setDisable(false);
    		
    		labelNomeProduto.setDisable(false);
    		labelPreco.setDisable(false);
    		labelValidade.setDisable(false);
    		labelEstoque.setDisable(false);
    		labelCodigoFornecedor.setDisable(false);
    		labelNomeFornecedor.setDisable(false);
    		
    		btnPesquisaCodigoFornecedor.setDisable(false);
    		
    		inputCodigoProdutoEdicao.setDisable(true);
    		labelCodigoProduto.setDisable(true);
    		
    		btnPesquisaCodigoProduto.setDisable(true);
    		 
    		ArrayList<Produto> listaProdutos = Produto.getListaProduto();
    		
    		int index = Produto.buscaProduto(codigo);
    		
    		String nomeProduto = listaProdutos.get(index).getNome();
    		double preco = listaProdutos.get(index).getPreco();
    		String validadeString = listaProdutos.get(index).getValidade();
    		double estoque = listaProdutos.get(index).getEstoque();
    		String nomeFornecedor = listaProdutos.get(index).getNomeFornecedor();
    		
    		LocalDate validade = LocalDate.parse(validadeString);
    		
    		inputNomeProdutoEdicao.setText(nomeProduto);
    		inputNomeFornecedorEdicao.setText(nomeFornecedor);
    		inputPrecoEdicao.setText(Double.toString(preco));
    		inputValidadeEdicao.setValue(validade);
    		inputEstoqueEdicao.setText(Double.toString(estoque));
    		
    		btnSalvar.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Produto não encontrado");
    		
    	}
    	
    }

    @FXML
    void salvaCadastroProduto(ActionEvent event) {
    	
    	if (inputCodigoProdutoEdicao.getText() != "") {
    		
    		String codigo = inputCodigoProdutoEdicao.getText();
    		String nome = inputNomeProdutoEdicao.getText();
    		String preco = inputPrecoEdicao.getText();
    		LocalDate validade = inputValidadeEdicao.getValue();
    		String estoque = inputEstoqueEdicao.getText();
    		String nomeFornecedor = inputNomeFornecedorEdicao.getText();
    		
    		double precoFormatado = Geral.validaDouble(preco);
    		double estoqueFormatado = Geral.validaDouble(estoque);
    		
    	    
        	if (nome == "" || preco == "" || validade == null || estoque == "" || nomeFornecedor == "") {
        		
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErroEstoque.setText("");
        		msgErroValidade.setText("");
        		msgErro.setText("Preencha todos os campos!");
        		
        	} else if (precoFormatado < 0 || estoqueFormatado < 0) {
    	    	
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErroEstoque.setText("");
        		msgErroValidade.setText("");
        		
        		if (estoqueFormatado < 0) {
        			msgErroEstoque.setText("Valor Inválido");
        		} else if (precoFormatado < 0) {
        			msgErroPreco.setText("Valor Inválido");
        		} 
        		
        	}  else {
        		String validadeString = validade.toString();
        		
        		Produto.editar(codigo, nome, precoFormatado, validadeString, estoqueFormatado, nomeFornecedor);
        		
        		Stage stage = (Stage)btnSalvar.getScene().getWindow();
        	    stage.close();
        	    
        	}
        	
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o código do Produto!");
    		
    	}

    }

}
