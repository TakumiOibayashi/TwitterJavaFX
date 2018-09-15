package application;
	
import javax.sound.midi.ControllerEventListener;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	Stage stage;
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			//BlockController controller = (BlockController)loader.getController();
			//controller.setThisStage(stage);
			} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
