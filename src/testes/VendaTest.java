package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Item;
import model.Venda;

public class VendaTest {

	@Test
	public void testeInstanciandoVenda() {
		
		Venda.limpaListaVenda();
		
		ArrayList<String> nomesItens = new ArrayList<String>();
		ArrayList<Item> itens = new ArrayList<Item>();
		
		Venda novaVenda = new Venda("1", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		assertTrue(novaVenda instanceof Venda);
	}
	
	@Test
	public void testeAdicionarVendaLista() {
		
		Venda.limpaListaVenda();
		
		ArrayList<String> nomesItens = new ArrayList<String>();
		ArrayList<Item> itens = new ArrayList<Item>();
		
		Venda novaVenda = new Venda("1", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda);
		
		Venda novaVenda2 = new Venda("2", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda2);
		
		ArrayList<Venda> itemLista = Venda.getListaVenda();
		
		assertTrue(itemLista.get(0) == novaVenda);
	}
	
	@Test
	public void testeAdicionarSegundaVendaLista() {
		
		Venda.limpaListaVenda();
		
		ArrayList<String> nomesItens = new ArrayList<String>();
		ArrayList<Item> itens = new ArrayList<Item>();
		
		Venda novaVenda = new Venda("1", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda);
		
		Venda novaVenda2 = new Venda("2", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda2);
		
		ArrayList<Venda> itemLista = Venda.getListaVenda();
		
		assertTrue(itemLista.get(1) == novaVenda2);
	}
	
	@Test
	public void testeEditarVendaLista() {
		
		Venda.limpaListaVenda();
		
		ArrayList<String> nomesItens = new ArrayList<String>();
		ArrayList<Item> itens = new ArrayList<Item>();
			
		Venda novaVenda = new Venda("1", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda);
		
		Venda.editar("1", "02/02/2003", "20:00:00", 100.00, "Débito");
		
		ArrayList<Venda> itemLista = Venda.getListaVenda();
		
		Venda VendaEditado = itemLista.get(0);
		
		assertTrue(VendaEditado.getData() != "Queijo Duplo");
	}
	
	@Test
	public void testeExcluirVendaLista() {
		
		Venda.limpaListaVenda();
		
		ArrayList<String> nomesItens = new ArrayList<String>();
		ArrayList<Item> itens = new ArrayList<Item>();
		
		Venda novaVenda = new Venda("1", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda);
		
		Venda novaVenda2 = new Venda("2", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda2);
		
		Venda novaVenda3 = new Venda("3", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);;
		
		Venda.registrar(novaVenda3);
		
		Venda.excluir("2");
		Venda.excluir("1");
		Venda.excluir("3");
		
		ArrayList<Venda> itemLista = Venda.getListaVenda();
		
		assertTrue(itemLista.isEmpty());
	}
	
	@Test
	public void testeBuscarVenda() {
		
		Venda.limpaListaVenda();
		
		ArrayList<String> nomesItens = new ArrayList<String>();
		ArrayList<Item> itens = new ArrayList<Item>();
		
		Venda novaVenda = new Venda("1", "02/02/2002", "20:00:00", 100.00, "Débito", "Carlos Cliente", nomesItens, itens);
		
		Venda.registrar(novaVenda);
		
		int i = Venda.buscaVenda("1");
		
		ArrayList<Venda> itemLista = Venda.getListaVenda();
		
		Venda itemBuscado= itemLista.get(i);
		
		assertTrue(itemBuscado == novaVenda);
	}

}
