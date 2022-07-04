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
 * Classe Controller da Exclus�o de Clientes
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
     * Exclui o Cliente atrav�s do c�digo digitado pelo usu�rio, se for um c�digo v�lido
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
     * Valida o c�digo de Cliente inserido pelo usu�rio, retorna o nome do Cliente, e desbloqueia o bot�o de excluir, se o c�digo digitado for v�lido
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
    		
    		msgErro.setText("Cliente n�o encontrado");
    		
    	}


    }

}
