package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Fornecedor;
import model.Geral;
import model.Produto;

public class ProdutoCadastroController {
	
	static int contadorCodigo = 2;
	
	public static void geraCodigo() {
		contadorCodigo ++;
	}

	@FXML
    private Button btnPesquisaCodigoFornecedor;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCodigoFornecedor;

    @FXML
    private TextField inputEstoqueCadastro;

    @FXML
    private TextField inputNomeFornecedor;

    @FXML
    private TextField inputPrecoCadastro;

    @FXML
    private TextField inputProdutoCadastro;

    @FXML
    private TextField inputValidadeCadastro;

    @FXML
    private Label labelCodigoFornecedor;

    @FXML
    private Label labelNomeFornecedor;

    @FXML
    private Label msgErro;

    @FXML
    private Label msgErroEstoque;

    @FXML
    private Label msgErroPreco;

    @FXML
    private Label msgErroValidade;
    
    @FXML
    private Label msgErroFornecedor;

    @FXML
    void pesquisarCodigoFornecedor(ActionEvent event) {
    	
    	String codigoFornecedor = inputCodigoFornecedor.getText();
    	
    	if (Fornecedor.validaFornecedor(codigoFornecedor)) {
    		
    		msgErroFornecedor.setText("");
    		
    		ArrayList<Fornecedor> listaFornecedores = Fornecedor.getListaFornecedor();
    		
    		int index = Fornecedor.buscaFornecedor(codigoFornecedor);
    		
    		inputNomeFornecedor.setText(listaFornecedores.get(index).getNome());
    		
    	} else {
    		inputNomeFornecedor.setText("");
    		msgErroFornecedor.setText("Código Inválido");
    	}
    	 
    }

    @FXML
    void salvaCadastroProduto(ActionEvent event) {
    	
    	String nome = inputProdutoCadastro.getText();
		String preco = inputPrecoCadastro.getText();
		String validade = inputValidadeCadastro.getText();
		String estoque = inputEstoqueCadastro.getText();
		String nomeFornecedor = inputNomeFornecedor.getText();
		
		double precoFormatado = Geral.validaDouble(preco);
		double estoqueFormatado = Geral.validaDouble(estoque);
		String validadeFormatada = Geral.validaData(validade);
	    
    	if (precoFormatado < 0 || estoqueFormatado < 0 || validadeFormatada == null) {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroEstoque.setText("");
    		msgErroValidade.setText("");
    		
    		if (estoqueFormatado < 0) {
    			msgErroEstoque.setText("Valor Inválido");
    		} else if (precoFormatado < 0) {
    			msgErroPreco.setText("Valor Inválido");
    		} else if (validadeFormatada == null) {
    			msgErroValidade.setText("Data inválida");
    		}
    		
    	} else if (nome == "" || preco == "" || validade == "" || estoque == "" || nomeFornecedor == "") {
	    	
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroEstoque.setText("");
    		msgErroValidade.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	}  else {
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		Produto novoProduto = new Produto(codigo, nome, precoFormatado, validadeFormatada, estoqueFormatado, nomeFornecedor);
    		Produto.cadastrar(novoProduto);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }

}
