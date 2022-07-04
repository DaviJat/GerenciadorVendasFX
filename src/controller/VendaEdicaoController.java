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

/**
 * Classe Controller da Edi��o de Venda
 * @author Davi
 *
 */
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

    /**
     * Pega o c�digo da venda digitado pelo usu�rio, habilita e preenche os inputs com os dados da venda, se o c�digo for v�lido
     * @param event
     */
    @FXML
    void pesquisarCodigoVenda(ActionEvent event) {
    	
    	String codigo = inputCodigoVendaEdicao.getText();
    	
    	if (Facade.validaVenda(codigo)) {
    		
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
    		
    		int index = Facade.buscaVenda(codigo);
    		
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
    		
    		msgErro.setText("Venda n�o encontrada");
    		
    	}
    	
    }
    
    /**
     * Verifica se todos os inputs foram preenchidos, e salva as altera��es feitas na venda
     * @param event
     */
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
    		
        	if (data == null || hora == "" || preco == "" || formaPagamento == "") {
        		
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErroHora.setText("");
        		msgErro.setText("Preencha todos os campos!");
        		
        	} else if (precoFormatado < 0 || horaFormatada == null) {
    	    	
        		msgErro.setText("");
        		msgErroPreco.setText("");
        		msgErroHora.setText("");
        		
        		if (precoFormatado < 0) {
        			msgErroPreco.setText("Valor Inv�lido");
        		} else if (horaFormatada == null) {
        			msgErroHora.setText("Hora Inv�lida");
        		} 
        		
        	}  else {
        		
        		String dataString = data.toString();
        		
        		Facade.editarVenda(codigo, horaFormatada, dataString, precoFormatado, formaPagamento);
        		
        		Stage stage = (Stage)btnSalvar.getScene().getWindow();
        	    stage.close();
        	    
        	}
        	
    	} else {
    		
    		msgErro.setText("");
    		msgErro.setText("Digite o c�digo da Venda");
    		
    	}
    	
    }

}
