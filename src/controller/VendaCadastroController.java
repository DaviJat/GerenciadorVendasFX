package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.Geral;
import model.Item;
import model.Produto;
import model.Venda;

public class VendaCadastroController {
	
	static int contadorCodigo = 0;
	
	public static void geraCodigo() {
		contadorCodigo ++;
	}
	
	ArrayList<Item> listaItens = new ArrayList<Item>();
	ArrayList<String> listaNomesItens = new ArrayList<String>();
	double precoTotal;

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
    public void initialize() {
    	listaNomesItens.clear();
    	listaItens.clear();
    	precoTotal = 0;
    	inputPrecoCadastro.setText("0.00");
    }

    @FXML
    void adicionarItem(ActionEvent event) {
    	
    	String nomeItem = inputNomeItemCadastro.getText();
    	
    	if (nomeItem == "") {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		msgErro.setText("Selecione um produto e digite a quantidade");
    		
    	} else {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		
    		String codigoItem = inputCodigoItemCadastro.getText();
    		
    		int indexItem = Item.buscaItem(codigoItem);
			listaItens.add(Item.getItem(indexItem));
			
			double precoItem = Item.retornaPrecoItem(codigoItem);
			
			precoTotal += precoItem;
			
			listaNomesItens.add(nomeItem);
    		
    		inputNomeItemCadastro.setText("");
    		inputCodigoItemCadastro.setText("");
    		inputCodigoItemCadastro.setEditable(true);
    		inputPrecoCadastro.setText(Double.toString(precoTotal));
    	}
    	
    	
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
    		msgErroCliente.setText("C�digo Inv�lido");
    	}
    	
    }

    @FXML
    void pesquisarCodigoItem(ActionEvent event) {
    	
    	String codigoItem = inputCodigoItemCadastro.getText();
    	
    	if (Item.validaItem(codigoItem)) {
    		
    		msgErroCliente.setText("");
    		
    		ArrayList<Item> listaItens = Item.getListaItem();
    		
    		int index = Item.buscaItem(codigoItem);
    		
    		inputNomeItemCadastro.setText(listaItens.get(index).getNome());
    		
    	} else {
    		inputNomeItemCadastro.setText("");
    		msgErroItem.setText("C�digo Inv�lido");
    	}
    	
    }

    @FXML
    void salvaRegistroVenda(ActionEvent event) {
    	
    	String data = inputDataCadastro.getText();
		String hora = inputHoraCadastro.getText();
		String preco = inputPrecoCadastro.getText();
		String formaPagamento = inputFormaPagamentoCadastro.getText();
		String nomeCliente = inputNomeClienteCadastro.getText();
		
		double precoFormatado = Geral.validaDouble(preco);
		String dataFormatada = Geral.validaData(data);
		String horaFormatada = Geral.validaHora(hora);
	    
    	if (data == "" || hora == "" || preco == "" || formaPagamento == "" || nomeCliente == "") {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	} else if (precoFormatado < 0 || dataFormatada == null || horaFormatada == null) {
	    	
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		
    		if (dataFormatada == null) {
    			msgErroData.setText("Data inv�lida");
    		} else if (horaFormatada == null) {
    			msgErroHora.setText("Hora inv�lida");
    		} else if (precoFormatado < 0) {
    			msgErroPreco.setText("Valor Inv�lido");
    		}
    		
    	} else if (listaNomesItens.isEmpty()){
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		msgErro.setText("Insira pelo menos um Item!");
    		
    	} else {
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		for(Item item : listaItens){
				
				ArrayList<Produto> listaProdutos = item.getListaProdutosItem();
				ArrayList<String> listaQuantidades = item.getListaQuantidadesProdutos();
				
				int indice = 0;
				
				for(Produto produto : listaProdutos){
					
					Produto.removerEstoque(produto, listaQuantidades.get(indice));
					indice ++;
					
				}
			}
    		
    		Venda novaVenda = new Venda(codigo, dataFormatada, horaFormatada, precoFormatado, formaPagamento, nomeCliente, listaNomesItens, listaItens);
    		Venda.registrar(novaVenda);
    		
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }

}