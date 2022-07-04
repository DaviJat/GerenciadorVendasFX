package model;

import java.util.ArrayList;


/**
 * Classe para instanciar objetos do tipo Fornecedor, e realizar as funções de
 * gerenciamento desse objeto
 * @author Davi
 */
public class Fornecedor {
	
	/** 
	 * Atributos da classe Fornecedor
	 */
	private String codigo;
	private String nome;
	private String cnpj;
	private String endereco;
	
	private static ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
	
	//Methods
	
	/**
	 * Construtor do objeto da Classe Fornecedor
	 * @param codigo
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 */
	public Fornecedor(String codigo, String nome, String cnpj, String endereco) {
		setCodigo(codigo);
		setNome(nome);
		setCnpj(cnpj);
		setEndereco(endereco);
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
	 * Getter que retorna o cnpj
	 * @return cnpj
	 */
	public String getCnpj() {
		return this.cnpj;
	}
	
	/** 
	 * Setter do cnpj
	 * @param cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	/**
	 * Getter que retorna o endereco
	 * @return endereco
	 */
	public String getEndereco() {
		return this.endereco;
	}
	
	/** 
	 * Setter do endereco
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * Getter que retorna a listaFornecedor
	 * @return listaFornecedor
	 */
	public static ArrayList<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}
	
	//Fim Get/Set
	
	/**
	 * Recebe objeto com os valores e insere na listaFornecedor
	 * @param novoFornecedor
	 */
	public static void cadastrar(Fornecedor novoFornecedor) {
	
		listaFornecedor.add(novoFornecedor);
	}
	
	/**
	 * Recebe o codigo do Fornecedor e os novos dados, e edita no objeto da lista
	 * @param codigoString
	 * @param novoNome
	 */
	public static void editar(String codigoString, String novoNome, String novoCnpj, String novoEndereco) {
		
		int i = buscaFornecedor(codigoString);
		
		if (i != -1) {
			listaFornecedor.get(i).setNome(novoNome);
			listaFornecedor.get(i).setCnpj(novoCnpj);
			listaFornecedor.get(i).setEndereco(novoEndereco);
		}
	}
	
	/**
	 * Recebe o codigo do Fornecedor, e exclui da lista
	 * @param codigoString
	 */
	public static void excluir(String codigoString) {
		
		int i = buscaFornecedor(codigoString);
		
		if (i != -1) {
			listaFornecedor.remove(i);
		}
	}
	
	/**
	 * Recebe um código de Fornecedor e encontra o index do objeto com esse código,
	 * na lista
	 * @param codigo
	 * @return 
	 */
	public static int buscaFornecedor(String codigo) {
		int indice = 0; 
		for(Fornecedor u : listaFornecedor){
		    if (u.getCodigo().equals(codigo)) {
		    	return indice; 
		    }                  
		    indice++;
		}
		return -1;
	}
	
	/**
	 * Loop que verifica se foi encontrado um fornecedor com o código digitado
	 * @return 
	 */
	public static boolean validaFornecedor(String codigoFornecedor) {
		
		boolean validaFornecedor = false;
		
		int resultadoBusca = Fornecedor.buscaFornecedor(codigoFornecedor);
		
		if (resultadoBusca == -1) {
			validaFornecedor = false;
		} else {
			validaFornecedor = true;
		}
		
		return validaFornecedor;
		
	}
	
	/**
	 * Limpa lista de Fornecedor (Exclusiva para teste)
	 */
	public static void limpaLista() {
		listaFornecedor.clear();
	}
	

}
