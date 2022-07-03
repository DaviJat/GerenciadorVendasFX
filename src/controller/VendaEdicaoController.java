package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Geral;
import model.Venda;

public class VendaEdicaoController {

    @FXML
    private Button btnPesquisaCodigoVenda;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCodigoVendaEdicao;

    @FXML
    private DatePicker inputDataEdicao;

    @FXML
    private TextField inputFormaPagamentoEdicao;

    @FXML
    private TextField inputHoraEdicao;

    @FXML
    private TextField inputPrecoVendaEdicao;

    @FXML
    private Label labelCodigoVenda;

    @FXML
    private Label labelData;

    @FXML
    private Label labelFormaPagamento;

    @FXML
    private Label labelHora;

    @FXML
    private Label labelPrecoVenda;

    @FXML
    private Label msgErro;

    @FXML
    private Label msgErroHora;

    @FXML
    private Label msgErroPreco;

    @FXML
    void pesquisarCodigoVenda(ActionEvent event) {
    	
    	String codigo = inputCodigoVendaEdicao.getText();
    	
    	if (Venda.validaVenda(codigo)) {
    		
    		msgErro.setText("");
    		
    		inputDataEdicao.setDisable(false);
    		inputHoraEdicao.setDisable(false);
    		inputPrecoVendaEdicao.setDisable(false);
    		inputFormaPagamentoEdicao.setDisable(false);
    		
    		labelData.setDisable(false);
    		labelHora.setDisable(false);
    		labelPrecoVenda.setDisable(false);
    		labelFormaPagamento.setDisable(false);
    		
    		inputCodigoVendaEdicao.setDisable(true);
    		labelCodigoVenda.setDisable(true);
    		
    		btnPesquisaCodigoVenda.setDisable(true);
    		 
    		ArrayList<Venda> listaVendas = Venda.getListaVenda();
    		
    		int index = Venda.buscaVenda(codigo);
    		
    		String dataString = listaVendas.get(index).getData();
    		String hora = listaVendas.get(index).getHora();
    		double preco = listaVendas.get(index).getPrecoTotal();
    		String formaPagamento = listaVendas.get(index).getFormaPagamento();
    		
    		LocalDate data = LocalDate.parse(dataString);
    		
    		inputDataEdicao.setValue(data);
    		inputHoraEdicao.setText(hora);
    		inputPrecoVendaEdicao.setText(Double.toString(preco));
    		inputFormaPagamentoEdicao.setText(formaPagamento);
    		
    		btnSalvar.setDisable(false);
    		
    	} else {
    		
    		msgErro.setText("Venda não encontrada");
    		
    	}
    	
    }

    @FXML
    void salvaCadastroVenda(ActionEvent event) {
    	
    	if (inputCodigoVendaEdicao.getText() != "") {
    		
    		String codigo = inputCodigoVendaEdicao.getText();
    		LocalDate data = inputDataEdicao.getValue();
    		String hora = inputHoraEdicao.getText();
    		String preco = inputPrecoVendaEdicao.getText();
    		String formaPagamento = inputFormaPagamentoEdicao.getText();
    		
    		double precoFormatado = Geral.validaDouble(preco);
    		String horaFormatada = Geral.validaHora(hora);
    		
    		String dataString = data.toString();
    	    
        	if (dataString == "" || hora == "" || preco == "" || formaPagamento == "") {
        		
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErroHora.setText("");
        		msgErro.setText("Preencha todos os campos!");
        		
        	} else if (precoFormatado < 0 || horaFormatada == null) {
    	    	
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErroHora.setText("");
        		
        		if (precoFormatado < 0) {
        			msgErroPreco.setText("Valor Inválido");
        		} else if (horaFormatada == null) {
        			msgErroHora.setText("Hora Inválida");
        		} 
        		
        	}  else {
        		
        		Venda.editar(codigo, horaFormatada, dataString, precoFormatado, formaPagamento);
        		
        		Stage stage = (Stage)btnSalvar.getScene().getWindow();
        	    stage.close();
        	    
        	}
        	
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o código da Venda");
    		
    	}
    	
    }

}
