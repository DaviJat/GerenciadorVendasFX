package model;

import java.util.ArrayList;

/**
 * Classe para instanciar objetos do tipo Usuario, e realizar as funções de
 * gerenciamento desse objeto
 * @author Davi
 */
public class Usuario {
	
	/** 
	 * Atributos da classe Usuário
	 */
	private String codigo;
	private String nome;
	private String senha;
	private String cargo;
	
	private static ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	
	/**
	 * Construtor do objeto da Classe Usuario
	 * @param codigo
	 * @param nome
	 * @param cargo
	 */
	public Usuario(String codigo, String nome, String senha, String cargo) {
		setCodigo(codigo);
		setNome(nome);
		setSenha(senha);
		setCargo(cargo);
	}
	
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
	 * Getter que retorna a senha
	 * @return senha
	 */
	public String getSenha() {
		return this.senha;
	}
	
	/**
	 * Setter da senha
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Getter do cargo
	 * @return cargo
	 */
	public String getCargo() {
		return this.cargo;
	}
	
	/**
	 * Setter cargo
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Getter da listaUsuario
	 * @return
	 */
	public static ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	
	/**
	 * Setter listaUsuario
	 * @param listaUsuario
	 */
	public static void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		Usuario.listaUsuario = listaUsuario;
	}
	

	/**
	 * Recebe objeto com os valores e insere na listaUsuario
	 * @param novoUsuario
	 */
	public static void cadastrar(Usuario novoUsuario) {
	
		getListaUsuario().add(novoUsuario); 
	}
	
	/**
	 * Recebe o codigo do Usuário e os novos dados, e edita no objeto da lista
	 * @param codigoString
	 * @param novoNome
	 * @param novaSenha
	 * @param novoCargo
	 */
	public static void editar(String codigoString, String novoNome, String novaSenha, String novoCargo) {
		
		int i = buscaUsuario(codigoString); 
		
		if (i != -1) {
			getListaUsuario().get(i).setNome(novoNome);
			getListaUsuario().get(i).setSenha(novaSenha);
			getListaUsuario().get(i).setCargo(novoCargo);
		}
	}
	
	/**
	 * Recebe o codigo do Usuário, e exclui da lista
	 * @param codigoString
	 */
	public static void excluir(String codigoString) {
		
		int i = buscaUsuario(codigoString);
		
		if (i != -1) {
			getListaUsuario().remove(i);
		}
	}
	
	/**
	 * Recebe um código de usuário e encontra o index do objeto com esse código,
	 * na lista
	 * @param codigo
	 * @return indice
	 */
	public static int buscaUsuario(String codigo) {
		int indice = 0; 
		for(Usuario u : getListaUsuario()){
		    if (u.getCodigo().equals(codigo)) {
		    	return indice; 
		    }                  
		    indice++;
		}
		return -1; 
	}
	
	/**
	 * Loop que verifica se foi encontrado um usuário com o código digitado
	 * @return 
	 */
	public static boolean validaUsuario(String codigoUsuario) {
		
		boolean validaUsuario = false;
		
		int resultadoBusca = Usuario.buscaUsuario(codigoUsuario);
		
		if (resultadoBusca == -1) {
			validaUsuario = false;
		} else {
			validaUsuario = true;
		}
		
		return validaUsuario;
	}
	
	/**
	 * Função para validar o login de um usuário no main
	 * @param codigo
	 * @param senha
	 * @return
	 */
	public static boolean validaUsuarioLogin(String codigo, String senha) {
		for(Usuario u : getListaUsuario()){
		    if (u.getCodigo().equals(codigo) && u.getSenha().equals(senha)) {
		    	return true; 
		    }             
		}
		return false; 
	}
}
