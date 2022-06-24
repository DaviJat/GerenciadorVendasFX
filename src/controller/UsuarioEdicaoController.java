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

public class UsuarioEdicaoController {
	
	ObservableList<String> listaCargos = FXCollections.observableArrayList("Gerente", "Funcionário");
	
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
    
    @FXML
    void initialize() {
    	
    	selectCargoEdicao.setItems(listaCargos);
    	
    }

    @FXML
    void pesquisarCodigoUsuario(ActionEvent event) {
    	
    	String codigo = inputCodigoEdicao.getText();
    	
    	if (Usuario.validaUsuario(codigo)) {
    		
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
    		
    		int index = Usuario.buscaUsuario(codigo);
    		
    		String nome = listaUsuarios.get(index).getNome();
    		String senha = listaUsuarios.get(index).getSenha();
    		String cargo = listaUsuarios.get(index).getCargo();
    		
    		inputUsuarioEdicao.setText(nome);
    		inputSenhaEdicao.setText(senha);
    		selectCargoEdicao.setValue(cargo);
    		btnSalvar.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Usuário não encontrado");
    		
    	}
    }

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
	    		
	    		Usuario.editar(codigo, nome, senha, cargo);
	    		
	    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
	    	    stage.close();
	    	    
	    	}
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o código do Usuário!");
    		
    	}
    	
    }

}
