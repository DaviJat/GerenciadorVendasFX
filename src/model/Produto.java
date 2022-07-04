package model;

import java.util.ArrayList;

/**
 * Classe para instanciar objetos do tipo Produto, e realizar as funções de
 * gerenciamento desse objeto
 * @author Davi
 */
public class Produto {
	
	/**
	 * Atributos da classe Produto
	 */
	private String codigo;
	private String nome;
	private double preco;
	private String validade;
	private double estoque;
	private String nomeFornecedor;
	
	private static ArrayList<Produto> listaProduto = new ArrayList<Produto>();
	
	//Methods
	
	/**
	 * Construtor do objeto da Classe Produto
	 * @param codigo
	 * @param nome
	 * @param preco
	 * @param validade
	 */
	public Produto(String codigo, String nome, double preco, String validade, double estoque, String nomeFornecedor) {
		setCodigo(codigo);
		setNome(nome);
		setPreco(preco);
		setValidade(validade);
		setEstoque(estoque);
		setNomeFornecedor(nomeFornecedor);
	}
	
	//Inicio Get/Set
	
	/**
	 * Getter que retorna o codigo
	 * @return codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/** 
	 * Setter do codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Getter que retorna o nome
	 * @return nome
	 */
	public String getNome() {
		return this.nome;
	}
	
	/** 
	 * Setter do nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Getter que retorna o preco
	 * @return preco
	 */
	public double getPreco() {
		return this.preco;
	}
	
	/** 
	 * Setter do preco
	 * @param preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Getter que retorna a validade
	 * @return validade
	 */
	public String getValidade() {
		return this.validade;
	}
	
	/** 
	 * Setter da validade
	 * @param validade
	 */
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	/**
	 * Getter que retorna a quantidade em estoque
	 * @return estoque
	 */
	public double getEstoque() {
		return this.estoque;
	}
	
	/** 
	 * Setter do estoque
	 * @param estoque
	 */
	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}
	
	/**
	 * Getter que retorna o codigo do fornecedor
	 * @return nomeFornecedor
	 */
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}
	
	/** 
	 * Setter do nomeFornecedor
	 * @param nomeFornecedor
	 */
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	/**
	 * Getter que retorna um objeto produto escolhido 
	 * @param i
	 * @return produto
	 */
	static public Produto getProduto(int i) {
		Produto produto;
		produto = listaProduto.get(i);
		return produto;
	}
	
	/**
	 * Getter que retorna a listaProduto
	 * @return listaProduto
	 */
	public static ArrayList<Produto> getListaProduto() {
		return listaProduto;
	}
	
	//Fim Get/Set
	
	/**
	 * Recebe objeto com os valores e insere na listaProduto
	 * @param novoProduto
	 */
	public static void cadastrar(Produto novoProduto) {
	
		listaProduto.add(novoProduto); 
	}
	
	/**
	 * Recebe o codigo do Produto e os novos dados, e edita no objeto da lista
	 * @param codigoString
	 * @param novoNome
	 */
	public static void editar(String codigoString, String novoNome, double novoPreco, String novaValidade, double novoEstoque, String novoFornecedor) {
		
		int i = buscaProduto(codigoString); 
		
		if (i != -1) {
			listaProduto.get(i).setNome(novoNome);
			listaProduto.get(i).setPreco(novoPreco);
			listaProduto.get(i).setValidade(novaValidade);
			listaProduto.get(i).setEstoque(novoEstoque);
			listaProduto.get(i).setNomeFornecedor(novoFornecedor);
		}
	}
	
	/**
	 * Recebe o codigo do Produto, e exclui da lista
	 * @param codigoString
	 */
	public static void excluir(String codigoString) {
		
		int i = buscaProduto(codigoString); 
		
		if (i != -1) {
			listaProduto.remove(i);
		}
	}
	
	/**
	 * Recebe um código de Produto e encontra o index do objeto com esse código,
	 * na lista
	 * @param codigo
	 * @return
	 */
	public static int buscaProduto(String codigo) {
		int indice = 0; 
		for(Produto u : listaProduto){
		    if (u.getCodigo().equals(codigo)) {
		    	return indice; 
		    }                  
		    indice++;
		}
		return -1; 
	}
	
	/**
	 * Loop que verifica se foi encontrado um Produto com o código digitado
	 * @return 
	 */
	public static boolean validaProduto(String codigoProduto) {
		
		boolean validaProduto = false;
		
		int resultadoBusca = Produto.buscaProduto(codigoProduto);
		
		if (resultadoBusca == -1) {
			validaProduto = false;
		} else {
			validaProduto = true;
		}
		
		return validaProduto;
		
	}
	
	@SuppressWarnings("static-access")
	/**
	 * Função para remover do estoque a quantidade de cada produto de cada item da venda
	 * @param produtoVenda
	 * @param quantidade
	 */
	public static void removerEstoque(Produto produtoVenda, String quantidadeString) {
		
		double quantidade = Double.parseDouble(quantidadeString);
		
		int indice = 0;
        	
    	for(Produto produto : listaProduto) {
    		if (produto.equals(produtoVenda)) {
    			produto.listaProduto.get(indice).estoque -= quantidade;
    		}
    		indice ++;
    	}
	}
}
