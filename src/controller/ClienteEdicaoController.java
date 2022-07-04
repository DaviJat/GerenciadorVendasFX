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
 * Classe controller da Edi��o de Clientes
 * @author Davi
 *
 */
public class ClienteEdicaoController {

    @FXML
    private Button btnPesquisaCodigoCliente;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputClienteEdicao;

    @FXML
    private TextField inputCodigoEdicao;

    @FXML
    private TextField inputCpfEdicao;

    @FXML
    private TextField inputEmailEdicao;

    @FXML
    private TextField inputTelefoneEdicao;

    @FXML
    private Label labelCliente;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label labelCpf;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label msgErro;
    
    /**
     * Pega o c�digo do cliente digitado pelo usu�rio, habilita e preenche os inputs com os dados do cliente, se o c�digo for v�lido
     * @param event
     */
    @FXML
    void pesquisarCodigoCliente(ActionEvent event) {
    	String codigo = inputCodigoEdicao.getText();
    	
    	if (Facade.validaCliente(codigo)) {
    		
    		msgErro.setText("");
    		
    		inputClienteEdicao.setDisable(false);
    		inputCpfEdicao.setDisable(false);
    		inputEmailEdicao.setDisable(false);
    		inputTelefoneEdicao.setDisable(false);
    		labelCliente.setDisable(false);
    		labelCpf.setDisable(false);
    		labelEmail.setDisable(false);
    		labelTelefone.setDisable(false);
    		
    		inputCodigoEdicao.setDisable(true);
    		labelCodigo.setDisable(true);
    		btnPesquisaCodigoCliente.setDisable(true);
    		 
    		ArrayList<Cliente> listaClientes = Cliente.getListaCliente();
    		
    		int index = Facade.buscaCliente(codigo);
    		
    		String nome = listaClientes.get(index).getNome();
    		String cpf = listaClientes.get(index).getCpf();
    		String email = listaClientes.get(index).getEmail();
    		String telefone = listaClientes.get(index).getTelefone();
    		
    		inputClienteEdicao.setText(nome);
    		inputCpfEdicao.setText(cpf);
    		inputEmailEdicao.setText(email);
    		inputTelefoneEdicao.setText(telefone);
    		btnSalvar.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Cliente n�o encontrado");
    		
    	}
    	
    }
    
    /**
     * Verifica se todos os inputs foram preenchidos, e salva as altera��es feitas no cliente
     * @param event
     */
    @FXML
    void salvaEdicaoCliente(ActionEvent event) {
    	
    	if (inputCodigoEdicao.getText() != "") {
    		
    		String codigo = inputCodigoEdicao.getText();
	    	String nome = inputClienteEdicao.getText();
			String cpf = inputCpfEdicao.getText();
			String email = inputEmailEdicao.getText();
			String telefone = inputTelefoneEdicao.getText();
		    
		    if (nome == "" || cpf == "" || email == "" || telefone == "") {
		    	
	    		msgErro.setText("");
	    		msgErro.setText("Preencha todos os campos!");
	    		
	    	} else {
	    		
	    		
	    		Facade.editarCliente(codigo, nome, cpf, email, telefone);
	    		
	    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
	    	    stage.close();
	    	    
	    	}
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o c�digo do Cliente!");
    		
    	}
    	
    }

}
