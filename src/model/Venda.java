package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe para instanciar objetos do tipo Venda, e realizar as funções de
 * gerenciamento desse objeto
 * @author Davi
 *
 */
public class Venda {
	
	/**
	 * Atributos da classe Venda
	 */
	private String codigo;
	private String data;
	private String hora;
	private double precoTotal;
	private String formaPagamento;
	private String nomeCliente;
	private ArrayList<String> listaNomesItensVenda;
	private ArrayList<Item> listaItensVenda;
	
	public static ArrayList<Venda> listaVenda = new ArrayList<Venda>();


	//Methods
	
	/**
	 * Construtor do objeto da Classe Venda
	 * @param codigo
	 * @param data
	 * @param hora
	 * @param precoTotal
	 * @param formaPagamento
	 * @param itens
	 */
	public Venda(String codigo, String data, String hora, double precoTotal,
			     String formaPagamento, String nomeCliente, ArrayList<String> nomesItens, ArrayList<Item> itens) {
		
		setCodigo(codigo);
		setData(data);
		setHora(hora);
		setPrecoTotal(precoTotal);
		setFormaPagamento(formaPagamento);
		setNomeCliente(nomeCliente);
		setListaNomesItensVenda(nomesItens);
		setListaItensVenda(itens);
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
	 * Getter que retorna a data
	 * @return data
	 */
	public String getData() {
		return data;
	}
	
	/** 
	 * Setter da data
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Getter que retorna a hora
	 * @return hora
	 */
	public String getHora() {
		return hora;
	}

	/** 
	 * Setter da hora
	 * @param hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * Getter que retorna o precoTotal
	 * @return precoTotal
	 */
	public double getPrecoTotal() {
		return precoTotal;
	}
	
	/** 
	 * Setter do precoTotal
	 * @param precoTotal
	 */
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	/**
	 * Getter que retorna o formaPagamento
	 * @return formaPagamento
	 */
	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	/** 
	 * Setter do formaPagamento
	 * @param formaPagamento
	 */
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public ArrayList<String> getListaNomesItensVenda() {
		return listaNomesItensVenda;
	}

	public void setListaNomesItensVenda(ArrayList<String> listaNomesItensVenda) {
		this.listaNomesItensVenda = listaNomesItensVenda;
	}
	
	public ArrayList<Item> getListaItensVenda() {
		return listaItensVenda;
	}

	public void setListaItensVenda(ArrayList<Item> listaItensVenda) {
		this.listaItensVenda = listaItensVenda;
	}
	
	/**
	 * Getter que retorna a listaVenda
	 * @return listaVenda
	 */
	public static ArrayList<Venda> getListaVenda() {
		return listaVenda;
	}
	
	//Fim Get/Set
	
	
	/**
	 * Recebe objeto com os valores e insere na listaVenda
	 * @param novaVenda
	 */
	public static void registrar(Venda novaVenda) {
	
		listaVenda.add(novaVenda); 
	}
	
	/**
	 * Recebe o codigo do Venda e a nova data, e edita no objeto da lista
	 * @param codigoString
	 * @param novaData
	 */
	public static void editarData(String codigoString, String novaData) {
		
		int i = buscaVenda(codigoString); 
		
		if (i != -1) {
			listaVenda.get(i).setData(novaData);
		}
	}
	
	/**
	 * Recebe o codigo do Venda e a nova hora, e edita no objeto da lista
	 * @param codigoString
	 * @param novaHora
	 */
	public static void editarHora(String codigoString, String novaHora) {
		
		int i = buscaVenda(codigoString); 
		
		if (i != -1) {
			listaVenda.get(i).setHora(novaHora);
		}
	}
	
	/**
	 * Recebe o codigo do Venda e o novo preco total, e edita no objeto da lista
	 * @param codigoString
	 * @param novoPrecoTotal
	 */
	public static void editarPrecoTotal(String codigoString, String novoPrecoTotalString) {
		
		double novoPrecoTotal = Double.parseDouble(novoPrecoTotalString);
		
		int i = buscaVenda(codigoString); 
		
		if (i != -1) {
			listaVenda.get(i).setPrecoTotal(novoPrecoTotal);
		}
	}
	
	/**
	 * Recebe o codigo do Venda e o novo preco total, e edita no objeto da lista
	 * @param codigoString
	 * @param novaFormaPagamento
	 */
	public static void editarFormaPagamento(String codigoString, String novaFormaPagamento) {
		
		int i = buscaVenda(codigoString); 
		
		if (i != -1) {
			listaVenda.get(i).setFormaPagamento(novaFormaPagamento);
		}
	}
	
	/**
	 * Recebe o codigo do Venda, e exclui da lista
	 * @param codigoString
	 */
	public static void excluir(String codigoString) {
		
		int i = buscaVenda(codigoString); 
		
		if (i != -1) {
			listaVenda.remove(i);
		}
	}
	
	/**
	 * Recebe um código de Venda e encontra o index do objeto com esse código,
	 * na lista
	 * @param codigo
	 * @return indice
	 */
	public static int buscaVenda(String codigo) {
		int indice = 0; 
		for(Venda u : listaVenda){
		    if (u.getCodigo().equals(codigo)) {
		    	return indice; 
		    }                  
		    indice++;
		}
		return -1; 
	}
	
	/**
	 * Loop que verifica se foi encontrado uma Venda com o código digitado
	 * @return 
	 */
	public static String validaVenda() {
		String codigoVenda = null;
		
		@SuppressWarnings("resource")
		Scanner entradaVenda = new Scanner(System.in);
		
		boolean validaVenda = false;
		
		while (validaVenda == false) {
			System.out.println("Código da Venda: ");
			codigoVenda = entradaVenda.nextLine();
			int resultadoBusca = Venda.buscaVenda(codigoVenda);
			if (resultadoBusca == -1) {
				System.out.println("Venda Não Cadastrada: ");
			} else {
				validaVenda = true;
			}
		}
		
		return codigoVenda;
		
	}
	
	/**
	 * Limpa lista de Venda (Exclusiva para teste)
	 */
	public static void limpaListaVenda() {
		listaVenda.clear();
	}

}

