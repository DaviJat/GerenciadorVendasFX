/***
Autor: Davi Jatob� Galdino
Componente Curricular: MI - Programa��o II
Concluido em: 20/06/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
**/

package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Fornecedor;
import model.Produto;
import model.Usuario;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Usuario novoUsuario = new Usuario("1", "Administrador", "adm", "Administrador");
		Usuario.cadastrar(novoUsuario);
		
		Fornecedor novoFornecedor = new Fornecedor("1", "Piracanjuba", "88888888", "Rua Argentina");
		Fornecedor.cadastrar(novoFornecedor);
		
		Fornecedor novoFornecedor2 = new Fornecedor("2", "Sadia", "99999999", "Rua Brasil");
		Fornecedor.cadastrar(novoFornecedor2);
		
		Produto novoProduto = new Produto("1", "Queijo", 30.0, "10/10/2022", 1000.00, "Piracanjuba");
		Produto.cadastrar(novoProduto);
		
		Produto novoProduto2 = new Produto("2", "Presunto", 20.0, "10/10/2022", 500.00, "Sadia");
		Produto.cadastrar(novoProduto2);
			
		FXMLLoader fxmlload = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));

        Parent root = fxmlload.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
