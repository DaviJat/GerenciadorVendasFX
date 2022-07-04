package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Fornecedor;

/**
 * Classe Controller da Exclusão de Fornecedores
 * @author Davi
 *
 */
public class FornecedorExclusaoController {
	
	@FXML
    private Button btnExcluir;

    @FXML
    private Button btnPesquisaCodigoFornecedor;

    @FXML
    private TextField inputCodigoExclusao;

    @FXML
    private TextField inputNomeFornecedor;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label msgErro;
    
    /**
     * Exclui o Fornecedor através do código digitado pelo usuário, se for um código válido
     * @param event
     */
    @FXML
    void excluirFornecedor(ActionEvent event) {
    	
    	if (inputCodigoExclusao.getText() != "") {
    		
    		String codigo = inputCodigoExclusao.getText();
    		
    		Facade.excluirFornecedor(codigo);
    		
    		Stage stage = (Stage)btnExcluir.getScene().getWindow();
    	    stage.close();
    		
    	}


    }
    
    /**
     * Valida o código de Fornecedor inserido pelo usuário, retorna o nome do Fornecedor, e desbloqueia o botão de excluir, se o código digitado for válido
     * @param event
     */
    @FXML
    void pesquisarCodigoFornecedor(ActionEvent event) {
    	
    	String codigo = inputCodigoExclusao.getText();
    	
    	if (Facade.validaFornecedor(codigo)) {
    		
    		msgErro.setText("");
    		
    		ArrayList<Fornecedor> listaFornecedores = Fornecedor.getListaFornecedor();
    		
    		int index = Facade.buscaFornecedor(codigo);
    		
    		inputNomeFornecedor.setText(listaFornecedores.get(index).getNome());
    		
    		inputCodigoExclusao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoFornecedor.setDisable(true);
    		btnExcluir.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Fornecedor não encontrado");
    		
    	}

    }

}
