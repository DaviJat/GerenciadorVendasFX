package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Venda;

/**
 * Classe Controller da Exclusão de Venda
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
     * Exclui a Venda através do código digitado pelo usuário, se for um código válido
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
    		
    		msgErro.setText("Venda não encontrada");
    		
    	}
    	
    }

}
