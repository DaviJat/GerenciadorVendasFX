package model;

import java.util.ArrayList;


/**
 * Classe para instanciar objetos do tipo Cliente, e realizar as funções de
 * gerenciamento desse objeto
 * @author Davi
 */
public class Cliente {
	
	/** 
	 * Atributos da classe Cliente
	 */
	private String codigo;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	
	private static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	
	//Methods
	
	/**
	 * Construtor do objeto da Classe Cliente
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param telefone
	 */
	public Cliente(String codigo, String nome, String cpf, String email, String telefone) {
		setCodigo(codigo);
		setNome(nome);
		setCpf(cpf);
		setEmail(email);
		setTelefone(telefone);
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
	 * Getter que retorna o cpf
	 * @return cpf
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/** 
	 * Setter do cpf
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Getter que retorna o email
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/** 
	 * Setter do email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter que retorna o telefone
	 * @return telefone
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/** 
	 * Setter do email
	 * @param email
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Getter que retorna a listaCliente
	 * @return listaCliente
	 */
	public static ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	//Fim Get/Set
	
	/**
	 * Recebe objeto com os valores e insere na listaCliente
	 * @param novoCliente
	 */
	public static void cadastrar(Cliente novoCliente) {
	
		listaCliente.add(novoCliente);
	}
	
	/**
	 * Recebe o codigo do Cliente e o novo nome, e edita no objeto da lista
	 * @param codigoString
	 * @param novoNome
	 */
	public static void editar(String codigoString, String novoNome, String novoCpf, String novoEmail, String novoTelefone) {
		
		int i = buscaCliente(codigoString);
		
		if (i != -1) {
			listaCliente.get(i).setNome(novoNome);
			listaCliente.get(i).setCpf(novoCpf);
			listaCliente.get(i).setEmail(novoEmail);
			listaCliente.get(i).setTelefone(novoTelefone);
		}
	}
	
	/**
	 * Recebe o codigo do Cliente, e exclui da lista
	 * @param codigoString
	 */
	public static void excluir(String codigoString) {
		
		int i = buscaCliente(codigoString);
		
		if (i != -1) {
			listaCliente.remove(i);
		}
	}
	
	/**
	 * Recebe um código de Cliente e encontra o index do objeto com esse código,
	 * na lista
	 * @param codigo
	 * @return 
	 */
	public static int buscaCliente(String codigo) {
		int indice = 0; 
		for(Cliente u : listaCliente){
		    if (u.getCodigo().equals(codigo)) {
		    	return indice; 
		    }                  
		    indice++;
		}
		return -1;
	}
	
	/**
	 * Loop que verifica se foi encontrado um cliente com o código digitado
	 * @return 
	 */
	public static boolean validaCliente(String codigoCliente) {
		
		boolean validaCliente = false;
		
		int resultadoBusca = Cliente.buscaCliente(codigoCliente);
		
		if (resultadoBusca == -1) {
			validaCliente = false;
		} else {
			validaCliente = true;
		}
		
		return validaCliente;
		
	}

}
