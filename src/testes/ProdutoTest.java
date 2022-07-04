package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Produto;

public class ProdutoTest {

	@Test
	public void testeInstanciandoProduto() {
		
		Produto.limpaListaProduto();
		
		Produto novoProduto = new Produto("1", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		assertTrue(novoProduto instanceof Produto);
	}
	
	@Test
	public void testeAdicionarProdutoLista() {
		
		Produto.limpaListaProduto();
		
		Produto novoProduto = new Produto("1", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto);
		
		Produto novoProduto2 = new Produto("2", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto2);
		
		ArrayList<Produto> produtoLista = Produto.getListaProduto();
		
		assertTrue(produtoLista.get(0) == novoProduto);
	}
	
	@Test
	public void testeAdicionarSegundoProdutoLista() {
		
		Produto.limpaListaProduto();
		
		Produto novoProduto = new Produto("1", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto);
		
		Produto novoProduto2 = new Produto("2", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto2);
		
		ArrayList<Produto> produtoLista = Produto.getListaProduto();
		
		assertTrue(produtoLista.get(1) == novoProduto2);
	}
	
	@Test
	public void testeEditarProdutoLista() {
		
		Produto.limpaListaProduto();
			
		Produto novoProduto = new Produto("1", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto);
		
		Produto.editar("1", "QueijoEditado", 12.00, "15 dias", 100.00, "1");
		
		ArrayList<Produto> produtoLista = Produto.getListaProduto();
		
		Produto ProdutoEditado = produtoLista.get(0);
		
		assertTrue(ProdutoEditado.getNome() != "Queijo");
	}
	
	@Test
	public void testeExcluirProdutoLista() {
		
		Produto.limpaListaProduto();
		
		Produto novoProduto = new Produto("1", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto);
		
		Produto novoProduto2 = new Produto("2", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto2);
		
		Produto novoProduto3 = new Produto("3", "Queijo", 12.00, "15 dias", 100.00, "1");
		
		Produto.cadastrar(novoProduto3);
		
		Produto.excluir("2");
		Produto.excluir("1");
		Produto.excluir("3");
		
		ArrayList<Produto> produtoLista = Produto.getListaProduto();
		
		assertTrue(produtoLista.isEmpty());
	}
	
	@Test
	public void testeBuscarProduto() {
		
		Produto.limpaListaProduto();
		
		Produto novoProduto = new Produto("1", "Queijo", 12.00, "15 dias", 100.00, "1");

		Produto.cadastrar(novoProduto);
		
		int i = Produto.buscaProduto("1");
		
		ArrayList<Produto> produtoLista = Produto.getListaProduto();
		
		Produto produtoBuscado= produtoLista.get(i);
		
		assertTrue(produtoBuscado == novoProduto);
	}

}
