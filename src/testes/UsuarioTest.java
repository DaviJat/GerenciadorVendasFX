package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Usuario;

public class UsuarioTest {

	@Test
	public void testeInstanciandoUsuario() {
		
		Usuario.limpaListaUsuario();
		
		Usuario novoUsuario = new Usuario("1", "Davi", "senha", "Gerente");
		
		assertTrue(novoUsuario instanceof Usuario);
	}
	
	@Test
	public void testeAdicionarUsuarioLista() {
		
		Usuario.limpaListaUsuario();
		
		Usuario novoUsuario = new Usuario("1", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario);
		
		Usuario novoUsuario2 = new Usuario("2", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario2);
		
		
		ArrayList<Usuario> usuarioLista = Usuario.getListaUsuario();
		
		assertTrue(usuarioLista.get(0) == novoUsuario);
	}
	
	@Test
	public void testeAdicionarSegundoUsuarioLista() {
		
		Usuario.limpaListaUsuario();
		
		Usuario novoUsuario = new Usuario("1", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario);
		
		Usuario novoUsuario2 = new Usuario("2", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario2);
		
		ArrayList<Usuario> usuarioLista = Usuario.getListaUsuario();
		
		assertTrue(usuarioLista.get(1) == novoUsuario2);
	}
	
	@Test
	public void testeEditarUsuarioLista() {
		
		Usuario.limpaListaUsuario();
			
		Usuario novoUsuario = new Usuario("1", "Davi", "senha", "Gerente");;
		
		Usuario.cadastrar(novoUsuario);
		
		Usuario.editar("1", "Carlos", "senha", "Gerente");
		
		ArrayList<Usuario> usuarioLista = Usuario.getListaUsuario();
		
		Usuario UsuarioEditado = usuarioLista.get(0);
		
		assertTrue(UsuarioEditado.getNome() != "Davi");
	}
	
	@Test
	public void testeExcluirUsuarioLista() {
		
		Usuario.limpaListaUsuario();
		
		Usuario novoUsuario = new Usuario("1", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario);
		
		Usuario novoUsuario2 = new Usuario("2", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario2);
		
		Usuario novoUsuario3 = new Usuario("3", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario3);
		
		Usuario.excluir("2");
		Usuario.excluir("1");
		Usuario.excluir("3");
		
		ArrayList<Usuario> usuarioLista = Usuario.getListaUsuario();
		
		assertTrue(usuarioLista.isEmpty());
	}
	
	@Test
	public void testeBuscarUsuario() {
		
		Usuario.limpaListaUsuario();
		
		Usuario novoUsuario = new Usuario("1", "Davi", "senha", "Gerente");
		
		Usuario.cadastrar(novoUsuario);
		
		int i = Usuario.buscaUsuario("1");
		
		ArrayList<Usuario> usuarioLista = Usuario.getListaUsuario();
		
		Usuario usuarioBuscado= usuarioLista.get(i);
		
		assertTrue(usuarioBuscado == novoUsuario);
	}

}
