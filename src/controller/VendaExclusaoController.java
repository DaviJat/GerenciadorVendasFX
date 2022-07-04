package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Venda;

/**
 * Classe Controller da Exclus�o de Venda
 * @author Davi
 *
 */
public class VendaExclusaoController {

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField inputCodigoExclusao;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label msgErro;
    
    /**
     * Exclui a Venda atrav�s do c�digo digitado pelo usu�rio, se for um c�digo v�lido
     * @param event
     */
    @FXML
    void excluirUsuario(ActionEvent event) {
    	
    	String codigo = inputCodigoExclusao.getText();
    	
    	if (Venda.validaVenda(codigo)) {
    		
    		Facade.excluirVenda(codigo);
    		
    		Stage stage = (Stage)btnExcluir.getScene().getWindow();
    	    stage.close();
    		
    	} else {
    		
    		msgErro.setText("Venda n�o encontrada");
    		
    	}
    	
    }

}
