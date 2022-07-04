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
import model.Cliente;
import model.Geral;
import model.Item;
import model.Produto;

/**
 * Classe Controller do Cadastro de Venda
 * @author Davi
 *
 */
public class VendaCadastroController {
	
	/**
	 * Valor inicial do código do cliente
	 */
	static int contadorCodigo = 0;
	
	/**
	 * Gera o próximo código a ser utilizado no cadastro
	 */
	public static void geraCodigo() {
		contadorCodigo ++;
	}
	
	/**
	 * Lista com os objetos (Item) que vão compor as vendas
	 */
	ArrayList<Item> listaItens = new ArrayList<Item>();
	
	/**
	 * Lista com o nome dos Itens
	 */
	ArrayList<String> listaNomesItens = new ArrayList<String>();
	
	/**
	 * Variável para compor o valor da venda, que terá seu valor inserido automaticamente através da soma do preço de todos os
	 * Itens da venda
	 */
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
    private DatePicker inputDataCadastro;

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
    
    /**
     * Reinicia os dados utilizados no cadastro, para não pegar os dados de uma venda anterior 
     */
    @FXML
    public void initialize() {
    	listaNomesItens.clear();
    	listaItens.clear();
    	precoTotal = 0;
    	inputPrecoCadastro.setText("0.00");
    }
    
    /**
     * Recebe o código de um item para adicionar a venda, após validar, vasculha a lista de produtos e altera o valor do seu estoque
     * com base nos produtos do item, ao adicionar esse item a venda a quantidade do produto no estoque é removido, não sendo recomendado
     * fechar a tela sem salvar a venda.
     * @param event
     */
    @FXML
    void adicionarItem(ActionEvent event) {
    	
    	String codigoItem = inputCodigoItemCadastro.getText();
    	
    	if (codigoItem == "") {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		msgErro.setText("Digite o código do Item");
    		
    	} else if (Facade.validaItem(codigoItem) == false) {
    		
    		inputNomeItemCadastro.setText("");
    		msgErroItem.setText("Código Inválido");
    		
    	} else {
    			
			int index = Facade.buscaItem(codigoItem);
		
		
			Item item = Item.getItem(index);
			
			ArrayList<Produto> listaProdutos = item.getListaProdutosItem();
			ArrayList<String> listaQuantidades = item.getListaQuantidadesProdutos();
			
			for(Produto produto : listaProdutos){
				
				double quantidade = Double.parseDouble(listaQuantidades.get(index));
				
				if((quantidade <= produto.getEstoque()) == false) {
				
					msgErro.setText("");
		    		msgErroPreco.setText("");
		    		msgErroData.setText("");
		    		msgErroHora.setText("");
		    		msgErroCliente.setText("");
		    		msgErroItem.setText("");
		    		msgErro.setText("Não existem produtos suficientes no estoque para produzir este item");
				
				} else {
					
					int indexItem = Facade.buscaItem(codigoItem);
					listaItens.add(Item.getItem(indexItem));
					
					double precoItem = Item.retornaPrecoItem(codigoItem);
					
					precoTotal += precoItem;
					
					String nomeItem = Item.getItem(indexItem).getNome();
					
					listaNomesItens.add(nomeItem);
		    		
		    		inputNomeItemCadastro.setText("");
		    		inputCodigoItemCadastro.setText("");
		    		inputCodigoItemCadastro.setEditable(true);
		    		inputPrecoCadastro.setText(Double.toString(precoTotal));
					
					Produto.removerEstoque(produto, listaQuantidades.get(index));
					
				}
			}
		}
	}
    	
    /**
     * Pesquisa o código do cliente que vai ser associado a venda, valida, e retorna o nome desse cliente
     * @param event
     */
    @FXML
    void pesquisarCodigoCliente(ActionEvent event) {
    	
    	String codigoCliente = inputCodigoClienteCadastro.getText();
    	
    	if (Facade.validaCliente(codigoCliente)) {
    		
    		msgErroCliente.setText("");
    		
    		ArrayList<Cliente> listaClientes = Cliente.getListaCliente();
    		
    		int index = Facade.buscaCliente(codigoCliente);
    		
    		inputNomeClienteCadastro.setText(listaClientes.get(index).getNome());
    		
    	} else {
    		inputNomeClienteCadastro.setText("");
    		msgErroCliente.setText("Código Inválido");
    	}
    	
    }
    
    /**
     * Pesquisa o código do item que vai ser adicionado a venda, valida, e retorna o nome desse item
     * @param event
     */
    @FXML
    void pesquisarCodigoItem(ActionEvent event) {
    	
    	String codigoItem = inputCodigoItemCadastro.getText();
    	
    	if (Facade.validaItem(codigoItem)) {
    		
    		msgErroCliente.setText("");
    		
    		ArrayList<Item> listaItens = Item.getListaItem();
    		
    		int index = Facade.buscaItem(codigoItem);
    		
    		inputNomeItemCadastro.setText(listaItens.get(index).getNome());
    		
    	} else {
    		inputNomeItemCadastro.setText("");
    		msgErroItem.setText("Código Inválido");
    	}
    	
    }
    
    /**
     * Verifica se os inputs foram preenchidos e validados gera um código e cadastra uma nova venda
     * @param event
     */
    @FXML
    void salvaRegistroVenda(ActionEvent event) {
    	
    	LocalDate data = inputDataCadastro.getValue();
		String hora = inputHoraCadastro.getText();
		String preco = inputPrecoCadastro.getText();
		String formaPagamento = inputFormaPagamentoCadastro.getText();
		String nomeCliente = inputNomeClienteCadastro.getText();
		
		double precoFormatado = Geral.validaDouble(preco);
		String horaFormatada = Geral.validaHora(hora);
	    
    	if (data == null || hora == "" || preco == "" || formaPagamento == "" || nomeCliente == "") {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	} else if (precoFormatado < 0 || horaFormatada == null) {
	    	
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroData.setText("");
    		msgErroHora.setText("");
    		msgErroCliente.setText("");
    		msgErroItem.setText("");
    		
    		if (horaFormatada == null) {
    			msgErroHora.setText("Hora inválida");
    		} else if (precoFormatado < 0) {
    			msgErroPreco.setText("Valor Inválido");
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
    		
    		String dataString = data.toString();
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		Facade.cadastrarVenda(codigo, dataString, horaFormatada, precoFormatado, formaPagamento, nomeCliente, listaNomesItens, listaItens);	
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }

}
