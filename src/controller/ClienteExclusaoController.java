package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;

/**
 * Classe Controller da Exclusão de Clientes
 * @author Davi
 *
 */
public class ClienteExclusaoController {

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnPesquisaCodigoCliente;

    @FXML
    private TextField inputCodigoExclusao;

    @FXML
    private TextField inputNomeCliente;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label msgErro;
    
    /**
     * Exclui o Cliente através do código digitado pelo usuário, se for um código válido
     * @param event
     */
    @FXML
    void excluirCliente(ActionEvent event) {
    	
    	if (inputCodigoExclusao.getText() != "") {
    		
    		String codigo = inputCodigoExclusao.getText();
    	
    		Facade.excluirCliente(codigo);
    		
    		Stage stage = (Stage)btnExcluir.getScene().getWindow();
    	    stage.close();
    		
    	}

    }
    
    /**
     * Valida o código de Cliente inserido pelo usuário, retorna o nome do Cliente, e desbloqueia o botão de excluir, se o código digitado for válido
     * @param event
     */
    @FXML
    void pesquisarCodigoCliente(ActionEvent event) {
    	
    	String codigo = inputCodigoExclusao.getText();
    	
    	if (Facade.validaCliente(codigo)) {
    		
    		msgErro.setText("");
    		
    		ArrayList<Cliente> listaCliente = Cliente.getListaCliente();
    		
    		int index = Facade.buscaCliente(codigo);
    		
    		inputNomeCliente.setText(listaCliente.get(index).getNome());
    		
    		inputCodigoExclusao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoCliente.setDisable(true);
    		btnExcluir.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Cliente não encontrado");
    		
    	}


    }

}
