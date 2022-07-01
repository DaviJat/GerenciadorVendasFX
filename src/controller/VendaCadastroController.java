package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Cliente;

public class VendaCadastroController {
	
	static int contadorCodigo = 0;
	
	public static void geraCodigo() {
		contadorCodigo ++;
	}

    @FXML
    private Button btnAdicionarItem;

    @FXML
    private Button btnPesquisaCodigoCliente;

    @FXML
    private Button btnPesquisaCodigoItem;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCodigoClienteCadastro;

    @FXML
    private TextField inputCodigoItemCadastro;

    @FXML
    private TextField inputDataCadastro;

    @FXML
    private TextField inputFormaPagamentoCadastro;

    @FXML
    private TextField inputHoraCadastro;

    @FXML
    private TextField inputNomeClienteCadastro;

    @FXML
    private TextField inputNomeItemCadastro;

    @FXML
    private TextField inputPrecoCadastro;

    @FXML
    private Label labelCodigoProduto;

    @FXML
    private Label msgErro;

    @FXML
    private Label msgErroCliente;

    @FXML
    private Label msgErroData;

    @FXML
    private Label msgErroHora;

    @FXML
    private Label msgErroItem;

    @FXML
    private Label msgErroPreco;

    @FXML
    void adicionarItem(ActionEvent event) {
    	
    }

    @FXML
    void pesquisarCodigoCliente(ActionEvent event) {
    	
    	String codigoCliente = inputCodigoClienteCadastro.getText();
    	
    	if (Cliente.validaCliente(codigoCliente)) {
    		
    		msgErroCliente.setText("");
    		
    		ArrayList<Cliente> listaClientes = Cliente.getListaCliente();
    		
    		int index = Cliente.buscaCliente(codigoCliente);
    		
    		inputNomeClienteCadastro.setText(listaClientes.get(index).getNome());
    		
    	} else {
    		inputNomeClienteCadastro.setText("");
    		msgErroCliente.setText("Código Inválido");
    	}
    	
    }

    @FXML
    void pesquisarCodigoItem(ActionEvent event) {

    }

    @FXML
    void salvaRegistroVenda(ActionEvent event) {

    }

}
