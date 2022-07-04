package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({UsuarioTest.class, FornecedorTest.class, ProdutoTest.class, ItemTest.class, VendaTest.class, ClienteTest.class})
public class AllTests {

}
