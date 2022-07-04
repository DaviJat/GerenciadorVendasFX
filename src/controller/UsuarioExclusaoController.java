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
 * Classe Controller da Exclusão de Usuários
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
     * Exclui o Usuário através do código digitado pelo usuário, se for um código válido
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
     * Valida o código de Usuário inserido pelo usuário, retorna o nome do Usuário, e desbloqueia o botão de excluir, se o código digitado for válido
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
    		
    		msgErro.setText("Usuário não encontrado");
    		
    	}

    }


}
