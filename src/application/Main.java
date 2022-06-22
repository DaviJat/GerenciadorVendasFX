/***
Autor: Davi Jatobá Galdino
Componente Curricular: MI - Programação II
Concluido em: 20/06/2022
Declaro que este código foi elaborado por mim de forma individual e não contêm nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
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
