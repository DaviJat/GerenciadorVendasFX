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
import model.Usuario;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Usuario novoUsuario = new Usuario("1", "Administrador", "adm", "Administrador");
		Usuario.cadastrar(novoUsuario);
			
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
