package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Fornecedor;

public class FornecedorEdicaoController {
	
	@FXML
    private Button btnPesquisaCodigoFornecedor;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCnpjEdicao;

    @FXML
    private TextField inputCodigoEdicao;

    @FXML
    private TextField inputEnderecoEdicao;

    @FXML
    private TextField inputFornecedorEdicao;

    @FXML
    private Label labelCnpj;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label labelEndereco;

    @FXML
    private Label labelFornecedor;

    @FXML
    private Label msgErro;

    @FXML
    void pesquisarCodigoFornecedor(ActionEvent event) {
    	
    	String codigo = inputCodigoEdicao.getText();
    	
    	if (Fornecedor.validaFornecedor(codigo)) {
    		
    		msgErro.setText("");
    		
    		inputFornecedorEdicao.setDisable(false);
    		inputCnpjEdicao.setDisable(false);
    		inputEnderecoEdicao.setDisable(false);
    		labelEndereco.setDisable(false);
    		labelCnpj.setDisable(false);
    		labelFornecedor.setDisable(false);
    		
    		inputCodigoEdicao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoFornecedor.setDisable(true);
    		 
    		ArrayList<Fornecedor> listaFornecedores = Fornecedor.getListaFornecedor();
    		
    		int index = Fornecedor.buscaFornecedor(codigo);
    		
    		String nome = listaFornecedores.get(index).getNome();
    		String cnpj = listaFornecedores.get(index).getCnpj();
    		String endereco = listaFornecedores.get(index).getEndereco();
    		
    		inputFornecedorEdicao.setText(nome);
    		inputCnpjEdicao.setText(cnpj);
    		inputEnderecoEdicao.setText(endereco);
    		btnSalvar.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Fornecedor não encontrado");
    		
    	}

    }

    @FXML
    void salvaEdicaoFornecedor(ActionEvent event) {
    	
    		if (inputCodigoEdicao.getText() != "") {
    		
    		String codigo = inputCodigoEdicao.getText();
	    	String nome = inputFornecedorEdicao.getText();
			String cnpj = inputCnpjEdicao.getText();
			String endereco = inputCnpjEdicao.getText();
		    
		    if (nome == "" || cnpj == "" || endereco == "") {
		    	
	    		msgErro.setText("");
	    		msgErro.setText("Preencha todos os campos!");
	    		
	    	} else {
	    		
	    		Fornecedor.editar(codigo, nome, cnpj, endereco);
	    		
	    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
	    	    stage.close();
	    	    
	    	}
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o código do Fornecedor!");
    		
    	}

    }

}
