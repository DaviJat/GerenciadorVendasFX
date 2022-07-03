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
    private TextField inputCodigoFornecedorCadastro;

    @FXML
    private TextField inputEstoqueCadastro;

    @FXML
    private TextField inputNomeFornecedorCadastro;

    @FXML
    private TextField inputPrecoCadastro;

    @FXML
    private TextField inputProdutoCadastro;

    @FXML
    private DatePicker inputValidadeCadastro;

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
    	
    	String codigoFornecedor = inputCodigoFornecedorCadastro.getText();
    	
    	if (Facade.validaFornecedor(codigoFornecedor)) {
    		
    		msgErroFornecedor.setText("");
    		
    		ArrayList<Fornecedor> listaFornecedores = Fornecedor.getListaFornecedor();
    		
    		int index = Facade.buscaFornecedor(codigoFornecedor);
    		
    		inputNomeFornecedorCadastro.setText(listaFornecedores.get(index).getNome());
    		
    	} else {
    		inputNomeFornecedorCadastro.setText("");
    		msgErroFornecedor.setText("Código Inválido");
    	}
    	 
    }

    @FXML
    void salvaCadastroProduto(ActionEvent event) {
    	
    	String nome = inputProdutoCadastro.getText();
		String preco = inputPrecoCadastro.getText();
		LocalDate validade = inputValidadeCadastro.getValue();
		String estoque = inputEstoqueCadastro.getText();
		String nomeFornecedor = inputNomeFornecedorCadastro.getText();
		
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
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		String validadeString = validade.toString();
    		
    		Facade.cadastrarProduto(codigo, nome, precoFormatado, validadeString, estoqueFormatado, nomeFornecedor);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }

}
