package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Geral;
import model.Produto;

/**
 * Classe Controller do Cadastro de Itens
 * @author Davi
 *
 */
public class ItemCadastroController {
	
	/**
	 * Lista com os objetos(produtos) salvos em cada objeto da Classe Item
	 */
	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	/**
	 * Lista com a Quantidades dos produtos salvos no objeto da Classe Item
	 */
	ArrayList<String> listaQuantidades = new ArrayList<String>();
	
	/**
	 * Lista que armazena Texto unindo o nome do produto e sua quantidade (Utilizado para preencher a coluna de Produtos da tabela de Itens)
	 */
	ArrayList<String> listaProdutosQuantidades = new ArrayList<String>();
	
	/**
	 * Valor inicial do código do item
	 */
	static int contadorCodigo = 0;
	
	/**
	 * Gera o próximo código a ser utilizado no cadastro
	 */
	public static void geraCodigo() {
		contadorCodigo ++;
	}

	@FXML
    private Button btnAdicionarProduto;

    @FXML
    private Button btnPesquisaCodigoProduto;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField inputCategoriaCadastro;

    @FXML
    private TextField inputCodigoProdutoCadastro;

    @FXML
    private TextField inputDescricaoCadastro;

    @FXML
    private TextField inputItemCadastro;

    @FXML
    private TextField inputNomeProdutoCadastro;

    @FXML
    private TextField inputPrecoCadastro;

    @FXML
    private TextField inputQuantidadeProdutoCadastro;

    @FXML
    private Label labelCodigoProduto;

    @FXML
    private Label msgErro;

    @FXML
    private Label msgErroPreco;

    @FXML
    private Label msgErroProduto;

    @FXML
    private Label msgErroQuantidade;
    
    /**
     * Limpa as listas para não puxar valores de cadastros de itens anteriores
     */
    @FXML
    public void initialize() {
        listaProdutos.clear();
        listaQuantidades.clear();
    }

    /**
     * Verifica se os inputs foram preenchidos e se o código do produto é válido, com isso insere o produto na lista de produtos do Item
     * e a quantidade necessária desse produto na confecção do item
     * @param event
     */
    @FXML
    void adicionarProduto(ActionEvent event) {
    	
    	String quantidadeProduto = inputQuantidadeProdutoCadastro.getText();
    	String codigoProduto = inputCodigoProdutoCadastro.getText();
    	
    	double quantidadeFormatada = Geral.validaDouble(quantidadeProduto);
    	
    	if (quantidadeProduto == "" || codigoProduto == "") {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		msgErro.setText("Digite o código do produto e sua quantidade");
    		
    	} else if (quantidadeFormatada < 0) {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		msgErroQuantidade.setText("Valor Inválido");
    	
    	} else {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		
    		int indexProduto = Facade.buscaProduto(codigoProduto);
			listaProdutos.add(Produto.getProduto(indexProduto));
			
			listaQuantidades.add(quantidadeProduto);
			
			String nomeProduto = Produto.getProduto(indexProduto).getNome();
			
			String stringNomeQuantidadeProduto = nomeProduto + " (" + quantidadeProduto + " kg)";
			listaProdutosQuantidades.add(stringNomeQuantidadeProduto);
    		
    		
    		inputQuantidadeProdutoCadastro.setText("");
    		inputNomeProdutoCadastro.setText("");
    		inputCodigoProdutoCadastro.setText("");
    		inputCodigoProdutoCadastro.setEditable(true);
    	}
    	
    	
    }
    
    /**
     * Pesquisa o código do produto, válida, e mostra o nome do produto para o usuário verificar
     * @param event
     */
    @FXML
    void pesquisarCodigoProduto(ActionEvent event) {
    	
    	String codigoProduto = inputCodigoProdutoCadastro.getText();
    	
    	if (Facade.validaProduto(codigoProduto)) {
    		
    		msgErroProduto.setText("");
    		
    		ArrayList<Produto> listaProdutos = Produto.getListaProduto();
    		
    		int index = Facade.buscaProduto(codigoProduto);
    		
    		inputNomeProdutoCadastro.setText(listaProdutos.get(index).getNome());
    		
    	} else {
    		inputNomeProdutoCadastro.setText("");
    		msgErroProduto.setText("Item não encontrado");
    	}
    	
    }
    
    /**
     * Salva o cadastro do item se os inputs forem preenchidos corretamentes, e se for adicionado pelo menos um produto
     * na composição desse Item
     * @param event
     */
    @FXML
    void salvaCadastroItem(ActionEvent event) {
    	
    	String nome = inputItemCadastro.getText();
		String preco = inputPrecoCadastro.getText();
		String descricao = inputDescricaoCadastro.getText();
		String categoria = inputCategoriaCadastro.getText();
		
		double precoFormatado = Geral.validaDouble(preco);
	    
    	if (nome == "" || preco == "" || descricao == "" || categoria == "") {
    		
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		msgErro.setText("Preencha todos os campos!");
    		
    	} else if (precoFormatado < 0) {

    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		msgErroPreco.setText("Valor Inválido");
    		
    	} else if (listaProdutos.isEmpty()) {
	    	
    		msgErro.setText("");
    		msgErroPreco.setText("");
    		msgErroQuantidade.setText("");
    		msgErroProduto.setText("");
    		msgErro.setText("Insira pelo menos um produto!");
    		
    	}  else {
    		
    		geraCodigo();
    		String codigo = Integer.toString(contadorCodigo);
    		
    		Facade.cadastrarItem(codigo, nome, precoFormatado, descricao, categoria, listaProdutosQuantidades, listaProdutos, listaQuantidades);
    		
    		Stage stage = (Stage)btnSalvar.getScene().getWindow();
    	    stage.close();
    	    
    	}

    }

}
