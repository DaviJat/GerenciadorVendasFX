package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Fornecedor;
import model.Item;
import model.Produto;
import model.Usuario;
import model.Venda;

public class Facade {
	
	/**
	 * Cria objeto Usuário com os valores inseridos e salva na lista de Usuários
	 * @param codigo
	 * @param nome
	 * @param senha
	 * @param cargo
	 */
	public static void cadastroUsuario(String codigo, String nome, String senha, String cargo) {
		Usuario novoUsuario = new Usuario(codigo, nome, senha, cargo);
		Usuario.cadastrar(novoUsuario);
	}
	
	/**
	 * Edita Usuário da lista de Usuários utilizando os valores inseridos
	 * @param codigo
	 * @param nome
	 * @param senha
	 * @param cargo
	 */
	public static void editarUsuario(String codigo, String nome, String senha, String cargo) {
		Usuario.editar(codigo, nome, senha, cargo);
	}
	
	/**
	 * Retorna indice do usuário na lista através do código
	 * @param codigo
	 * @return
	 */
	public static int buscaUsuario(String codigo) {
		int index = Usuario.buscaUsuario(codigo);
		return index;
	}
	
	/**
	 * Valida codigo do usuário recebido
	 * @param codigo
	 * @return
	 */
	public static boolean validaUsuario(String codigo) {
		boolean resultado = Usuario.validaUsuario(codigo);
		return resultado;
	}

	/**
	 * Exclui usuário com o código recebido
	 * @param codigo
	 */
	public static void excluirUsuario(String codigo) {
		Usuario.excluir(codigo);
	}
	
	/**
	 * Cria objeto Fornecedor com os valores inseridos e salva na lista de Fornecedores
	 * @param codigo
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 */
	public static void cadastrarFornecedor(String codigo, String nome, String cnpj, String endereco) {
		Fornecedor novoFornecedor = new Fornecedor(codigo, nome, cnpj, endereco);
		Fornecedor.cadastrar(novoFornecedor);
	}
	
	/**
	 * Valida codigo do fornecedor recebido
	 * @param codigo
	 * @return
	 */
	public static boolean validaFornecedor(String codigo) {
		boolean resultado = Fornecedor.validaFornecedor(codigo);
		return resultado;
	}
	
	/**
	 * Retorna indice do fornecedor na lista através do código
	 * @param codigo
	 * @return
	 */
	public static int buscaFornecedor(String codigo) {
		int index = Fornecedor.buscaFornecedor(codigo);
		return index;
	}
	
	/**
	 * Edita Fornecedor da lista de Fornecedores utilizando os valores inseridos
	 * @param codigo
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 */
	public static void editarFornecedor(String codigo, String nome, String cnpj, String endereco) {
		Fornecedor.editar(codigo, nome, cnpj, endereco);
	}
	
	/**
	 * Exclui fornecedor com o código recebido
	 * @param codigo
	 */
	public static void excluirFornecedor(String codigo) {
		Fornecedor.excluir(codigo);
	}
	
	/**
	 * Cria objeto Produto com os valores inseridos e salva na lista de Produtos
	 * @param codigo
	 * @param nome
	 * @param precoFormatado
	 * @param validadeString
	 * @param estoqueFormatado
	 * @param nomeFornecedor
	 */
	public static void cadastrarProduto(String codigo, String nome, double precoFormatado, String validadeString,
			double estoqueFormatado, String nomeFornecedor) {
		Produto novoProduto = new Produto(codigo, nome, precoFormatado, validadeString, estoqueFormatado, nomeFornecedor);
		Produto.cadastrar(novoProduto);
	}
	
	/**
	 * Valida codigo do produto recebido
	 * @param codigo
	 * @return
	 */
	public static boolean validaProduto(String codigo) {
		boolean resultado = Produto.validaProduto(codigo);
		return resultado;
	}
	
	/**
	 * Retorna indice do produto na lista através do código
	 * @param codigo
	 * @return
	 */
	public static int buscaProduto(String codigo) {
		int index = Produto.buscaProduto(codigo);
		return index;
	}

	/**
	 * Edita Produto da lista de Produtos utilizando os valores inseridos
	 * @param codigo
	 * @param nome
	 * @param precoFormatado
	 * @param validadeString
	 * @param estoqueFormatado
	 * @param nomeFornecedor
	 */
	public static void editarProduto(String codigo, String nome, double precoFormatado, String validadeString,
			double estoqueFormatado, String nomeFornecedor) {
		Produto.editar(codigo, nome, precoFormatado, validadeString, estoqueFormatado, nomeFornecedor);
	}
	
	/**
	 * Exclui produto com o código recebido
	 * @param codigo
	 */
	public static void excluirProduto(String codigo) {
		Produto.excluir(codigo);
	}
	
	/**
	 * Cria objeto Item com os valores inseridos e salva na lista de Itens
	 * @param codigo
	 * @param nome
	 * @param precoFormatado
	 * @param descricao
	 * @param categoria
	 * @param listaProdutosQuantidades
	 * @param listaProdutos
	 * @param listaQuantidades
	 */
	public static void cadastrarItem(String codigo, String nome, double precoFormatado, String descricao,
			String categoria, ArrayList<String> listaProdutosQuantidades, ArrayList<Produto> listaProdutos,
			ArrayList<String> listaQuantidades) {
		Item novoItem = new Item(codigo, nome, precoFormatado, descricao, categoria, listaProdutosQuantidades, listaProdutos, listaQuantidades);
		Item.cadastrar(novoItem);
	}
	
	/**
	 * Valida codigo do item recebido
	 * @param codigo
	 * @return
	 */
	public static boolean validaItem(String codigo) {
		boolean resultado = Item.validaItem(codigo);
		return resultado;
	}
	
	/**
	 * Retorna indice do item na lista através do código
	 * @param codigo
	 * @return
	 */
	public static int buscaItem(String codigo) {
		int index = Item.buscaItem(codigo);
		return index;
	}
	
	
	/**
	 * Edita Item da lista de Itens utilizando os valores inseridos
	 * @param codigo
	 * @param nomeItem
	 * @param precoFormatado
	 * @param categoria
	 * @param descricao
	 */
	public static void editarItem(String codigo, String nomeItem, double precoFormatado, String categoria,
			String descricao) {
		Item.editar(codigo, nomeItem, precoFormatado, categoria, descricao);
		
	}
	
	/**
	 * Exclui item com o código recebido
	 * @param codigo
	 */
	public static void excluirItem(String codigo) {
		Item.excluir(codigo);
	}

	/**
	 * Cria objeto Cliente com os valores inseridos e salva na lista de Clientes
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param telefone
	 */
	public static void cadastrarCliente(String codigo, String nome, String cpf, String email, String telefone) {
		Cliente novoCliente = new Cliente(codigo, nome, cpf, email, telefone);
		Cliente.cadastrar(novoCliente);
		
	}
	
	/**
	 * Valida codigo do cliente recebido
	 * @param codigo
	 * @return
	 */
	public static boolean validaCliente(String codigo) {
		boolean resultado = Cliente.validaCliente(codigo);
		return resultado;
	}
	
	/**
	 * Retorna indice do cliente na lista através do código
	 * @param codigo
	 * @return
	 */
	public static int buscaCliente(String codigo) {
		int index = Cliente.buscaCliente(codigo);
		return index;
	}
	
	/**
	 * Edita Cliente da lista de Cliente utilizando os valores inseridos
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param telefone
	 */
	public static void editarCliente(String codigo, String nome, String cpf, String email, String telefone) {
		Cliente.editar(codigo, nome, cpf, email, telefone);
	}
	
	/**
	 * Exclui cliente com o código recebido
	 * @param codigo
	 */
	public static void excluirCliente(String codigo) {
		Cliente.excluir(codigo);
	}

	/**
	 * Cria objeto Venda com os valores inseridos e salva na lista de Vendas
	 * @param codigo
	 * @param dataString
	 * @param horaFormatada
	 * @param precoFormatado
	 * @param formaPagamento
	 * @param nomeCliente
	 * @param listaNomesItens
	 * @param listaItens
	 */
	public static void cadastrarVenda(String codigo, String dataString, String horaFormatada, double precoFormatado,
			String formaPagamento, String nomeCliente, ArrayList<String> listaNomesItens, ArrayList<Item> listaItens) {
		Venda novaVenda = new Venda(codigo, dataString, horaFormatada, precoFormatado, formaPagamento, nomeCliente, listaNomesItens, listaItens);
		Venda.registrar(novaVenda);
		
	}
	
	/**
	 * Valida codigo da venda recebida
	 * @param codigo
	 * @return
	 */
	public static boolean validaVenda(String codigo) {
		boolean resultado = Venda.validaVenda(codigo);
		return resultado;
	}
	
	/**
	 * Retorna indice do venda na lista através do código
	 * @param codigo
	 * @return
	 */
	public static int buscaVenda(String codigo) {
		int index = Venda.buscaVenda(codigo);
		return index;
	}
	
	/**
	 * Edita Venda da lista de Vendas utilizando os valores inseridos
	 * @param codigo
	 * @param horaFormatada
	 * @param dataString
	 * @param precoFormatado
	 * @param formaPagamento
	 */
	public static void editarVenda(String codigo, String horaFormatada, String dataString, double precoFormatado,
			String formaPagamento) {
		Venda.editar(codigo, horaFormatada, dataString, precoFormatado, formaPagamento);
		
	}

	/**
	 * Exclui venda com o código recebido
	 * @param codigo
	 */
	public static void excluirVenda(String codigo) {
		Venda.excluir(codigo);
	}

}
