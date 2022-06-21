package model;

import java.util.ArrayList;
import java.util.Scanner;

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
	private boolean gerente;
	
	private static ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	
	/**
	 * Construtor do objeto da Classe Usuario
	 * @param codigo
	 * @param nome
	 * @param gerente
	 */
	public Usuario(String codigo, String nome, String senha, boolean gerente) {
		setCodigo(codigo);
		setNome(nome);
		setSenha(senha);
		setGerente(gerente);
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
	 * Getter do gerente
	 * @return gerente
	 */
	public boolean getGerente() {
		return this.gerente;
	}
	
	/**
	 * Setter gerente
	 * @param gerente
	 */
	public void setGerente(boolean gerente) {
		this.gerente = gerente;
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
	 * Recebe o codigo do Usuário e o novo nome, e edita no objeto da lista
	 * @param codigoString
	 * @param novoNome
	 */
	public static void editarNome(String codigoString, String novoNome) {
		
		int i = buscaUsuario(codigoString); 
		
		if (i != -1) {
			getListaUsuario().get(i).setNome(novoNome);
		}
	}
	
	/**
	 * Recebe o codigo do Usuário e o novo cargo, e edita no objeto da lista
	 * @param codigoString
	 * @param novoCargo
	 */
	public static void editarCargo(String codigoString, String novoCargo) {
		
		int i = buscaUsuario(codigoString); 
		
		if (i != -1) {
			switch (novoCargo) {
			case "1": 
				getListaUsuario().get(i).setGerente(true);
				break;
			case "2":
				getListaUsuario().get(i).setGerente(false);
				break;
			}
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
	 * Printa a lista de Usuários
	 */
	public static void listar() {
		for (Usuario usuario : getListaUsuario()) {
            System.out.println(
            		usuario.getCodigo() + "      / " + 
            		usuario.getNome() + " / " +
            		usuario.getGerente());
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
	public static String validaUsuario() {
		String codigoUsuario = null;
		
		@SuppressWarnings("resource")
		Scanner entradaUsuario = new Scanner(System.in);
		
		boolean validaUsuario = false;
		
		while (validaUsuario == false) {
			System.out.println("Código do Usuário: ");
			codigoUsuario = entradaUsuario.nextLine();
			int resultadoBusca = Usuario.buscaUsuario(codigoUsuario);
			if (resultadoBusca == -1) {
				System.out.println("Usuario Não Cadastrado: ");
			} else {
				validaUsuario = true;
			}
		}
		
		return codigoUsuario;
		
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
	
	/**
	 * Limpa lista de Usuário (Exclusiva para teste)
	 */
	public static void limpaListaUsuario() {
		listaUsuario.clear();
	}
}
