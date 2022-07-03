package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Fornecedor;
import model.Item;
import model.Produto;
import model.Usuario;
import model.Venda;

public class Facade {
	
	// Usuario

	public static void cadastroUsuario(String codigo, String nome, String senha, String cargo) {
		Usuario novoUsuario = new Usuario(codigo, nome, senha, cargo);
		Usuario.cadastrar(novoUsuario);
	}

	public static void editarUsuario(String codigo, String nome, String senha, String cargo) {
		Usuario.editar(codigo, nome, senha, cargo);
	}

	public static int buscaUsuario(String codigo) {
		int index = Usuario.buscaUsuario(codigo);
		return index;
	}

	public static boolean validaUsuario(String codigo) {
		boolean resultado = Usuario.validaUsuario(codigo);
		return resultado;
	}

	public static void excluirUsuario(String codigo) {
		Usuario.excluir(codigo);
	}
	
	//Fornecedor

	public static void cadastrarFornecedor(String codigo, String nome, String cnpj, String endereco) {
		Fornecedor novoFornecedor = new Fornecedor(codigo, nome, cnpj, endereco);
		Fornecedor.cadastrar(novoFornecedor);
	}

	public static boolean validaFornecedor(String codigo) {
		boolean resultado = Fornecedor.validaFornecedor(codigo);
		return resultado;
	}

	public static int buscaFornecedor(String codigo) {
		int index = Fornecedor.buscaFornecedor(codigo);
		return index;
	}

	public static void editarFornecedor(String codigo, String nome, String cnpj, String endereco) {
		Fornecedor.editar(codigo, nome, cnpj, endereco);
	}
	
	public static void excluirFornecedor(String codigo) {
		Fornecedor.excluir(codigo);
	}
	
	// Produto
	
	public static void cadastrarProduto(String codigo, String nome, double precoFormatado, String validadeString,
			double estoqueFormatado, String nomeFornecedor) {
		Produto novoProduto = new Produto(codigo, nome, precoFormatado, validadeString, estoqueFormatado, nomeFornecedor);
		Produto.cadastrar(novoProduto);
	}

	public static boolean validaProduto(String codigo) {
		boolean resultado = Produto.validaProduto(codigo);
		return resultado;
	}

	public static int buscaProduto(String codigo) {
		int index = Produto.buscaProduto(codigo);
		return index;
	}

	public static void editarProduto(String codigo, String nome, double precoFormatado, String validadeString,
			double estoqueFormatado, String nomeFornecedor) {
		Produto.editar(codigo, nome, precoFormatado, validadeString, estoqueFormatado, nomeFornecedor);
	}

	public static void excluirProduto(String codigo) {
		Produto.excluir(codigo);
	}
	
	// Item
	
	public static void cadastrarItem(String codigo, String nome, double precoFormatado, String descricao,
			String categoria, ArrayList<String> listaProdutosQuantidades, ArrayList<Produto> listaProdutos,
			ArrayList<String> listaQuantidades) {
		Item novoItem = new Item(codigo, nome, precoFormatado, descricao, categoria, listaProdutosQuantidades, listaProdutos, listaQuantidades);
		Item.cadastrar(novoItem);
	}

	public static boolean validaItem(String codigo) {
		boolean resultado = Item.validaItem(codigo);
		return resultado;
	}

	public static int buscaItem(String codigo) {
		int index = Item.buscaItem(codigo);
		return index;
	}

	public static void editarItem(String codigo, String nomeItem, double precoFormatado, String categoria,
			String descricao) {
		Item.editar(codigo, nomeItem, precoFormatado, categoria, descricao);
		
	}

	public static void excluirItem(String codigo) {
		Item.excluir(codigo);
	}

	// Cliente
	
	public static void cadastrarCliente(String codigo, String nome, String cpf, String email, String telefone) {
		Cliente novoCliente = new Cliente(codigo, nome, cpf, email, telefone);
		Cliente.cadastrar(novoCliente);
		
	}

	public static boolean validaCliente(String codigo) {
		boolean resultado = Cliente.validaCliente(codigo);
		return resultado;
	}

	public static int buscaCliente(String codigo) {
		int index = Cliente.buscaCliente(codigo);
		return index;
	}

	public static void editarCliente(String codigo, String nome, String cpf, String email, String telefone) {
		Cliente.editar(codigo, nome, cpf, email, telefone);
	}

	public static void excluirCliente(String codigo) {
		Cliente.excluir(codigo);
	}

	// Venda
	
	public static void cadastrarVenda(String codigo, String dataString, String horaFormatada, double precoFormatado,
			String formaPagamento, String nomeCliente, ArrayList<String> listaNomesItens, ArrayList<Item> listaItens) {
		Venda novaVenda = new Venda(codigo, dataString, horaFormatada, precoFormatado, formaPagamento, nomeCliente, listaNomesItens, listaItens);
		Venda.registrar(novaVenda);
		
	}

	public static boolean validaVenda(String codigo) {
		boolean resultado = Venda.validaVenda(codigo);
		return resultado;
	}

	public static int buscaVenda(String codigo) {
		int index = Venda.buscaVenda(codigo);
		return index;
	}

	public static void editarVenda(String codigo, String horaFormatada, String dataString, double precoFormatado,
			String formaPagamento) {
		Venda.editar(codigo, horaFormatada, dataString, precoFormatado, formaPagamento);
		
	}

	public static void excluirVenda(String codigo) {
		Venda.excluir(codigo);
	}

}
