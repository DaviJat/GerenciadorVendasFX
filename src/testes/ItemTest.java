package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Item;
import model.Produto;

public class ItemTest {

	@Test
	public void testeInstanciandoItem() {
		
		Item.limpaListaItem();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> quantidades = new ArrayList<String>();
		ArrayList<String> produtosQuantidades = new ArrayList<String>();
		
		Item novoItem = new Item("1", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		assertTrue(novoItem instanceof Item);
	}
	
	@Test
	public void testeAdicionarItemLista() {
		
		Item.limpaListaItem();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> quantidades = new ArrayList<String>();
		ArrayList<String> produtosQuantidades = new ArrayList<String>();
		
		Item novoItem = new Item("1", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem);
		
		Item novoItem2 = new Item("2", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem2);
		
		ArrayList<Item> itemLista = Item.getListaItem();
		
		assertTrue(itemLista.get(0) == novoItem);
	}
	
	@Test
	public void testeAdicionarSegundoItemLista() {
		
		Item.limpaListaItem();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> quantidades = new ArrayList<String>();
		ArrayList<String> produtosQuantidades = new ArrayList<String>();
		
		Item novoItem = new Item("1", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem);
		
		Item novoItem2 = new Item("2", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem2);
		
		ArrayList<Item> itemLista = Item.getListaItem();
		
		assertTrue(itemLista.get(1) == novoItem2);
	}
	
	@Test
	public void testeEditarItemLista() {
		
		Item.limpaListaItem();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> quantidades = new ArrayList<String>();
		ArrayList<String> produtosQuantidades = new ArrayList<String>();
			
		Item novoItem = new Item("1", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem);
		
		Item.editar("1", "Queijo DuploEditado", 12.00, "Dois Queijos", "Queijos");
		
		ArrayList<Item> itemLista = Item.getListaItem();
		
		Item ItemEditado = itemLista.get(0);
		
		assertTrue(ItemEditado.getNome() != "Queijo Duplo");
	}
	
	@Test
	public void testeExcluirItemLista() {
		
		Item.limpaListaItem();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> quantidades = new ArrayList<String>();
		ArrayList<String> produtosQuantidades = new ArrayList<String>();
		
		Item novoItem = new Item("1", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem);
		
		Item novoItem2 = new Item("2", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem2);
		
		Item novoItem3 = new Item("3", "Queijo Duplo", 12.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem3);
		
		Item.excluir("2");
		Item.excluir("1");
		Item.excluir("3");
		
		ArrayList<Item> itemLista = Item.getListaItem();
		
		assertTrue(itemLista.isEmpty());
	}
	
	@Test
	public void testeBuscarItem() {
		
		Item.limpaListaItem();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> quantidades = new ArrayList<String>();
		ArrayList<String> produtosQuantidades = new ArrayList<String>();
		
		Item novoItem = new Item("1", "Queijo Duplo", 25.00, "Dois Queijos", "Queijos", produtosQuantidades, produtos, quantidades);
		
		Item.cadastrar(novoItem);
		
		int i = Item.buscaItem("1");
		
		ArrayList<Item> itemLista = Item.getListaItem();
		
		Item itemBuscado= itemLista.get(i);
		
		assertTrue(itemBuscado == novoItem);
	}

}
