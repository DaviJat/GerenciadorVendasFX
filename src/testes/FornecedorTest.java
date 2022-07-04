package testes;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.Fornecedor;

public class FornecedorTest {
	
	@Test
	public void testeInstanciandoFornecedor() {
		
		Fornecedor.limpaLista();
		
		Fornecedor novoFornecedor = new Fornecedor("1", "Nestle", "123456789", "Rua");
		
		assertTrue(novoFornecedor instanceof Fornecedor);
	}
	
	@Test
	public void testeAdicionarFornecedorLista() {
		
		Fornecedor.limpaLista();
		
		Fornecedor novoFornecedor = new Fornecedor("1", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor);
		
		Fornecedor novoFornecedor2 = new Fornecedor("2", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor2);
		
		ArrayList<Fornecedor> fornecedorLista = Fornecedor.getListaFornecedor();
		
		assertTrue(fornecedorLista.get(0) == novoFornecedor);
	}
	
	@Test
	public void testeAdicionarSegundoFornecedorLista() {
		
		Fornecedor.limpaLista();
		
		Fornecedor novoFornecedor = new Fornecedor("1", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor);
		
		Fornecedor novoFornecedor2 = new Fornecedor("2", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor2);
		
		ArrayList<Fornecedor> fornecedorLista = Fornecedor.getListaFornecedor();
		
		assertTrue(fornecedorLista.get(1) == novoFornecedor2);
	}
	
	@Test
	public void testeEditarFornecedorLista() {
		
		Fornecedor.limpaLista();
			
		Fornecedor novoFornecedor = new Fornecedor("1", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor);
		
		Fornecedor.editar("1", "NestleEditado", "123456789", "Rua");
		
		ArrayList<Fornecedor> fornecedorLista = Fornecedor.getListaFornecedor();
		
		Fornecedor FornecedorEditado = fornecedorLista.get(0);
		
		assertTrue(FornecedorEditado.getNome() != "Nestle");
	}
	
	@Test
	public void testeExcluirFornecedorLista() {
		
		Fornecedor.limpaLista();
		
		Fornecedor novoFornecedor = new Fornecedor("1", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor);
		
		Fornecedor novoFornecedor2 = new Fornecedor("2", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor2);
		
		Fornecedor novoFornecedor3 = new Fornecedor("3", "Nestle", "123456789", "Rua");
		
		Fornecedor.cadastrar(novoFornecedor3);
		
		Fornecedor.excluir("2");
		Fornecedor.excluir("1");
		Fornecedor.excluir("3");
		
		ArrayList<Fornecedor> fornecedorLista = Fornecedor.getListaFornecedor();
		
		assertTrue(fornecedorLista.isEmpty());
	}
	
	@Test
	public void testeBuscarFornecedor() {
		
		Fornecedor.limpaLista();
		
		Fornecedor novoFornecedor = new Fornecedor("1", "Nestle", "123456789", "Rua");

		Fornecedor.cadastrar(novoFornecedor);
		
		int i = Fornecedor.buscaFornecedor("1");
		
		ArrayList<Fornecedor> fornecedorLista = Fornecedor.getListaFornecedor();
		
		Fornecedor fornecedorBuscado= fornecedorLista.get(i);
		
		assertTrue(fornecedorBuscado == novoFornecedor);
	}
	
}
