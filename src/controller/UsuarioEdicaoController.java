package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

/**
 * Classe Controller da Edi��o de Usu�rios
 * @author Davi
 *
 */
public class UsuarioEdicaoController {
	
	ObservableList<String> listaCargos = FXCollections.observableArrayList("Gerente", "Funcion�rio");
	
	@FXML
    private Label labelCargo;

    @FXML
    private Label labelUsuario;
    
    @FXML
    private Label labelSenha;
    
    @FXML
    private Label labelCodigo;
	
	@FXML
    private Button btnPesquisaCodigoUsuario;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCodigoEdicao;

    @FXML
    private TextField inputSenhaEdicao;

    @FXML
    private TextField inputUsuarioEdicao;

    @FXML
    private ChoiceBox<String> selectCargoEdicao;
    
    @FXML
    private Label msgErro;
    
    /**
     * Carrega os cargos de Usu�rio para preencher a choice box, na inicializa��o da tela
     */
    @FXML
    void initialize() {
    	
    	selectCargoEdicao.setItems(listaCargos);
    	
    }
    
    /**
     * Pega o c�digo do usuario digitado pelo usu�rio, habilita e preenche os inputs com os dados do usuario, se o c�digo for v�lido
     * @param event
     */
    @FXML
    void pesquisarCodigoUsuario(ActionEvent event) {
    	
    	String codigo = inputCodigoEdicao.getText();
    	
    	if (Facade.validaUsuario(codigo)) {
    		
    		msgErro.setText("");
    		
    		inputUsuarioEdicao.setDisable(false);
    		inputSenhaEdicao.setDisable(false);
    		selectCargoEdicao.setDisable(false);
    		labelUsuario.setDisable(false);
    		labelSenha.setDisable(false);
    		labelCargo.setDisable(false);
    		
    		inputCodigoEdicao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoUsuario.setDisable(true);
    		 
    		ArrayList<Usuario> listaUsuarios = Usuario.getListaUsuario();
    		
    		int index = Facade.buscaUsuario(codigo);
    		
    		String nome = listaUsuarios.get(index).getNome();
    		String senha = listaUsuarios.get(index).getSenha();
    		String cargo = listaUsuarios.get(index).getCargo();
    		
    		inputUsuarioEdicao.setText(nome);
    		inputSenhaEdicao.setText(senha);
    		selectCargoEdicao.setValue(cargo);
    		btnSalvar.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Usu�rio n�o encontrado");
    		
    	}
    }

    /**
     * Verifica se todos os inputs foram preenchidos, e salva as altera��es feitas no usu�rio
     * @param event
     */
    @FXML
    void salvaEdicaoUsuario(ActionEvent event) {
    	
    	if (inputCodigoEdicao.getText() != "") {
    		
    		String codigo = inputCodigoEdicao.getText();
	    	String nome = inputUsuarioEdicao.getText();
			String senha = inputSenhaEdicao.getText();
			String cargo = selectCargoEdicao.getSelectionModel().getSelectedItem();
		    
		    if (nome == "" || senha == "" || cargo == null) {
		    	
	    		msgErro.setText("");
	    		msgErro.setText("Preencha todos os campos!");
	    		
	    	} else {
	    		
	    		Facade.editarUsuario(codigo, nome, senha, cargo);
	    		
	    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
	    	    stage.close();
	    	    
	    	}
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o c�digo do Usu�rio!");
    		
    	}
    	
    }

}
