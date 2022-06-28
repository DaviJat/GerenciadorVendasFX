package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe para instanciar objetos do tipo Item, e realizar as funções de
 * gerenciamento desse objeto
 * @author Davi
 *
 */
public class Item {
	
	
	/** 
	 * Atributos da classe Item
	 */
	private String codigo;
	private String nome;
	private double preco;
	private String descricao;
	private String categoria;
	private ArrayList<Produto> listaProdutosItem;
	private ArrayList<String> listaQuantidadesProdutos;
	
	private static ArrayList<Item> listaItem = new ArrayList<Item>();
	
	//Methods
	
	/**
	 * Construtor do objeto da Classe Item
	 * @param codigo
	 * @param nome
	 * @param preco
	 * @param descricao
	 * @param categoria
	 * @param produtos
	 * @param quantidades
	 */
	public Item(String codigo, String nome, double preco, String descricao,
			    String categoria, ArrayList<Produto> produtos, ArrayList<String> quantidades) {
		
		setCodigo(codigo);
		setNome(nome);
		setPreco(preco);
		setDescricao(descricao);
		setCategoria(categoria);
		setListaProdutosItem(produtos);
		setListaQuantidadesProdutos(quantidades);
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
	 * Getter que retorna a decricao
	 * @return decricao
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/** 
	 * Setter do decricao
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Getter que retorna a categoria
	 * @return categoria
	 */
	public String getCategoria() {
		return this.categoria;
	}
	
	/** 
	 * Setter do categoria
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Getter que retorna a listaProdutosItem
	 * @return listaProdutosItem
	 */
	public ArrayList<Produto> getListaProdutosItem() {
		return this.listaProdutosItem;
	}
	
	/** 
	 * Setter da listaProdutosItem
	 * @param listaProdutosItem
	 */
	public void setListaProdutosItem(ArrayList<Produto> listaProdutosItem) {
		this.listaProdutosItem = listaProdutosItem;
	}
	
	/**
	 * Getter que retorna a listaQuantidadesProdutos
	 * @return listaQuantidadesProdutos
	 */
	public ArrayList<String> getListaQuantidadesProdutos() {
		return this.listaQuantidadesProdutos;
	}
	
	/** 
	 * Setter da listaQuantidadesProdutos
	 * @param listaQuantidadesProdutos
	 */
	public void setListaQuantidadesProdutos(ArrayList<String> listaQuantidadesProdutos) {
		this.listaQuantidadesProdutos = listaQuantidadesProdutos;
	}
	
	/**
	 * Getter que retorna um objeto item escolhido 
	 * @param i
	 * @return item
	 */
	static public Item getItem(int i) {
		Item item;
		item = listaItem.get(i);
		return item;
	}
	
	/**
	 * Getter que retorna a listaItem
	 * @return listaItem
	 */
	public static ArrayList<Item> getListaItem() {
		return listaItem;
	}
	
	//Fim Get/Set
	
	/**
	 * Recebe objeto com os valores e insere na listaItem
	 * @param novoItem
	 */
	public static void cadastrar(Item novoItem) {
	
		listaItem.add(novoItem); //Adiciona na lista novoItem
	}
	
	/**
	 * Recebe o codigo do Item e o novo nome, e edita no objeto da lista
	 * @param codigoString
	 * @param novoNome
	 */
	public static void editarNome(String codigoString, String novoNome) {
		
		int i = buscaItem(codigoString);
		
		if (i != -1) {
			listaItem.get(i).setNome(novoNome);
		}
	}
	
	/**
	 * Recebe o codigo do Item e o novo preco, e edita no objeto da lista
	 * @param codigoString
	 * @param novoPreco
	 */
	public static void editarPreco(String codigoString, String novoPrecoString) {
		
		double novoPreco = Double.parseDouble(novoPrecoString);
		
		int i = buscaItem(codigoString);
		
		if (i != -1) {
			listaItem.get(i).setPreco(novoPreco);
		}
	}
	
	/**
	 * Recebe o codigo do Item e a nova Descricao, e edita no objeto da lista
	 * @param codigoString
	 * @param novaDescricao
	 */
	public static void editarDescricao(String codigoString, String novaDescricao) {
		
		int i = buscaItem(codigoString);
		
		if (i != -1) {
			listaItem.get(i).setDescricao(novaDescricao);
		}
	}
	
	/**
	 * Recebe o codigo do Item e a nova Categoria, e edita no objeto da lista
	 * @param codigoString
	 * @param novaCategoria
	 */
	public static void editarCategoria(String codigoString, String novaCategoria) {
		
		int i = buscaItem(codigoString);
		
		if (i != -1) {
			listaItem.get(i).setDescricao(novaCategoria);
		}
	}
	
	/**
	 * Recebe o codigo do Item, e exclui da lista
	 * @param codigoString
	 */
	public static void excluir(String codigoString) {
		
		int i = buscaItem(codigoString);
		
		if (i != -1) {
			listaItem.remove(i);
		}
	}
	
	/**
	 * Printa a lista de Items
	 */
	public static void listar() {
		for (Item item : listaItem) {
            
			ArrayList<String> nomesProdutos = Item
					.retornaNomesProdutos(item.getListaProdutosItem(), 
							item.getListaQuantidadesProdutos());
            
            System.out.println("| Codigo: "         + item.getCodigo()+  
			 				   " | Nome: "        + item.getNome() +  
			 				   " | Preço: R$"     + item.getPreco() +  
			 				   " | Descrição: "   + item.getDescricao() +  
			 				   " | Categoria: "   + item.getCategoria() +
			 				   " | Produtos: "    + nomesProdutos);
        }
	}
	
	/**
	 * Função que retorna lista com os nomes do produtos de um item e suas quantidades em gramas
	 * @param listaProdutosItem
	 * @param listaQuantitadesProdutos
	 * @return
	 */
	public static ArrayList<String> retornaNomesProdutos(ArrayList<Produto> listaProdutosItem, 
			ArrayList<String> listaQuantitadesProdutos) {
		
		ArrayList<String> nomesProdutos = new ArrayList<String>();
		
		int index = 0;
		
		for(Produto produto : listaProdutosItem){
			nomesProdutos.add(produto.getNome() + " " + listaQuantitadesProdutos.get(index) + "g");
			index ++;
		}
		
		return nomesProdutos;
	}
	
	/**
	 * Recebe um código de Item e encontra o index do objeto com esse código,
	 * na lista
	 * @param codigo
	 * @return 
	 */
	public static int buscaItem(String codigo) {
		int indice = 0; 
		for(Item u : listaItem){
		    if (u.getCodigo().equals(codigo)) {
		    	return indice; 
		    }                  
		    indice++;
		}
		return -1; 
	}
	
	/**
	 * Loop que verifica se foi encontrado um item com o código digitado
	 * @return 
	 */
	public static String validaItem() {
		String codigoItem = null;
		
		@SuppressWarnings("resource")
		Scanner entradaItem = new Scanner(System.in);
		
		boolean validaItem = false;
		
		while (validaItem == false) {
			System.out.println("Código do Item: ");
			codigoItem = entradaItem.nextLine();
			int resultadoBusca = Item.buscaItem(codigoItem);
			if (resultadoBusca == -1) {
				System.out.println("Item Não Cadastrado: ");
			} else {
				validaItem = true;
			}
		}
		
		return codigoItem;
		
	}
	
	/**
	 * Rentorna uma lista de produtos do item buscando pelo código do produto
	 * @param codigo
	 * @return
	 */
	public static ArrayList<Produto> retornaListaProdutos(String codigo){
		
		for (Item item : listaItem) {
			if (item.getCodigo().equals(codigo)) {
		    	return item.getListaProdutosItem(); 
		    }  	
		}
		return null;
	}
	
	/**
	 * Retorna uma lista com as quantidades de cada produto na lista de produtos dos itens buscando 
	 * pelo código
	 * @param codigo
	 * @return
	 */
	public static ArrayList<String> retornaListaQuantidades(String codigo){
		
		for (Item item : listaItem) {
			if (item.getCodigo().equals(codigo)) {
		    	return item.getListaQuantidadesProdutos(); 
		    }  	
		}
		return null;
	}
	
	/**
	 *Retorna uma lista com as quantidades de cada produto na lista de produtos dos itens
	 * @param contador
	 * @param listaQuantidades
	 * @return
	 */
	public static String retornaQuantidadeProduto(int contador, ArrayList<String> listaQuantidades){
	
	    String quantidades = listaQuantidades.get(contador);
	    return quantidades;
	
	}
	
	/**
	 * Faz uma busca através do código e retorna o preço do item
	 * @param codigo
	 * @return
	 */
	public static double retornaPrecoItem(String codigo) {
		int indice = Integer.parseInt(codigo) - 1;
		double preco = listaItem.get(indice).preco;
		return preco;
	}
	
	/**
	 * Faz uma busca através do código e retorna o nome do item
	 * @param codigo
	 * @return
	 */
	public static String retornaNomesItens(String codigo) {
		int indice = Integer.parseInt(codigo) - 1;
		String nomeItem = Item.listaItem.get(indice).nome;
		return nomeItem;
	}
	
	/**
	 * Faz uma busca através do código e retorna a categoria do item
	 * @param codigo
	 * @return
	 */
	public static String retornaCategoriasItens(String codigo) {
		int indice = Integer.parseInt(codigo) - 1;
		String categoriaItem = Item.listaItem.get(indice).categoria;
		return categoriaItem;
	}
	
	/**
	 * Limpa lista de Item (Exclusiva para teste)
	 */
	public static void limpaListaItem() {
		listaItem.clear();
	}
}

