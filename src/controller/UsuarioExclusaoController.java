package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

public class UsuarioExclusaoController {
	
	@FXML
    private Button btnExcluir;

    @FXML
    private Button btnPesquisaCodigoUsuario;

    @FXML
    private TextField inputCodigoExclusao;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label msgErro;

    @FXML
    void excluirUsuario(ActionEvent event) {
    	
    	if (inputCodigoExclusao.getText() != "") {
    		
    		String codigo = inputCodigoExclusao.getText();
    		
    		Usuario.excluir(codigo);
    		
    		Stage stage = (Stage)btnExcluir.getScene().getWindow();
    	    stage.close();
    		
    	}

    }

    @FXML
    void pesquisarCodigoUsuario(ActionEvent event) {
    	
    	String codigo = inputCodigoExclusao.getText();
    	
    	if (Usuario.validaUsuario(codigo)) {
    		
    		msgErro.setText("");
    		
    		inputCodigoExclusao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoUsuario.setDisable(true);
    		
    	} else {
    		
    		msgErro.setText("Usu�rio n�o encontrado");
    		
    	}

    }


}
