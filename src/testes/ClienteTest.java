package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Cliente;

public class ClienteTest {

	@Test
	public void testeInstanciandoCliente() {
		
		Cliente.limpaListaCliente();
		
		Cliente novoCliente = new Cliente("1", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		assertTrue(novoCliente instanceof Cliente);
	}
	
	@Test
	public void testeAdicionarClienteLista() {
		
		Cliente.limpaListaCliente();
		
		Cliente novoCliente = new Cliente("1", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente);
		
		Cliente novoCliente2 = new Cliente("2", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente2);
		
		
		ArrayList<Cliente> clienteLista = Cliente.getListaCliente();
		
		assertTrue(clienteLista.get(0) == novoCliente);
	}
	
	@Test
	public void testeAdicionarSegundoClienteLista() {
		
		Cliente.limpaListaCliente();
		
		Cliente novoCliente = new Cliente("1", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente);
		
		Cliente novoCliente2 = new Cliente("2", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente2);
		
		ArrayList<Cliente> clienteLista = Cliente.getListaCliente();
		
		assertTrue(clienteLista.get(1) == novoCliente2);
	}
	
	@Test
	public void testeEditarClienteLista() {
		
		Cliente.limpaListaCliente();
			
		Cliente novoCliente = new Cliente("1", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente);
		
		Cliente.editar("1", "Carlos", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		ArrayList<Cliente> clienteLista = Cliente.getListaCliente();
		
		Cliente ClienteEditado = clienteLista.get(0);
		
		assertTrue(ClienteEditado.getNome() != "Davi");
	}
	
	@Test
	public void testeExcluirClienteLista() {
		
		Cliente.limpaListaCliente();
		
		Cliente novoCliente = new Cliente("1", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente);
		
		Cliente novoCliente2 = new Cliente("2", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente2);
		
		Cliente novoCliente3 = new Cliente("3", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente3);
		
		Cliente.excluir("2");
		Cliente.excluir("1");
		Cliente.excluir("3");
		
		ArrayList<Cliente> clienteLista = Cliente.getListaCliente();
		
		assertTrue(clienteLista.isEmpty());
	}
	
	@Test
	public void testeBuscarCliente() {
		
		Cliente.limpaListaCliente();
		
		Cliente novoCliente = new Cliente("1", "Davi", "999.999.999-99", "teste@teste.com", "75 99999-9999");
		
		Cliente.cadastrar(novoCliente);
		
		int i = Cliente.buscaCliente("1");
		
		ArrayList<Cliente> clienteLista = Cliente.getListaCliente();
		
		Cliente clienteBuscado= clienteLista.get(i);
		
		assertTrue(clienteBuscado == novoCliente);
	}

}
