package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

/**
 * Classe Controller da Exclus�o de Usu�rios
 * @author Davi
 *
 */
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
    private TextField inputNomeUsuario;

    @FXML
    private Label msgErro;
    
    /**
     * Exclui o Usu�rio atrav�s do c�digo digitado pelo usu�rio, se for um c�digo v�lido
     * @param event
     */
    @FXML
    void excluirUsuario(ActionEvent event) {
    	
    	if (inputCodigoExclusao.getText() != "") {
    		
    		String codigo = inputCodigoExclusao.getText();
    		
    		Facade.excluirUsuario(codigo);
    		
    		Stage stage = (Stage)btnExcluir.getScene().getWindow();
    	    stage.close();
    		
    	}

    }
   
    /**
     * Valida o c�digo de Usu�rio inserido pelo usu�rio, retorna o nome do Usu�rio, e desbloqueia o bot�o de excluir, se o c�digo digitado for v�lido
     * @param event
     */
    @FXML
    void pesquisarCodigoUsuario(ActionEvent event) {
    	
    	String codigo = inputCodigoExclusao.getText();
    	
    	if (Usuario.validaUsuario(codigo)) {
    		
    		msgErro.setText("");
    		
    		ArrayList<Usuario> listaUsuarios = Usuario.getListaUsuario();
    		
    		int index = Usuario.buscaUsuario(codigo);
    		
    		inputNomeUsuario.setText(listaUsuarios.get(index).getNome());
    		
    		inputCodigoExclusao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoUsuario.setDisable(true);
    		btnExcluir.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Usu�rio n�o encontrado");
    		
    	}

    }


}
