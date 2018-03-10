package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * A main class that use to initiate the program.
 * @author Theeruth Borisuth
 *
 */
public class Main extends Application {

	
	
	@Override
	public void start(Stage primaryStage) {
		try {
	
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Length Converter");
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			System.out.println("Exception creating scene: "+ e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
