package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException{
		showRoot(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	//メインウインドウを表示
    public void showRoot(Stage primaryStage) throws IOException{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Root.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TwitterJavaFX");
		primaryStage.show();
	}
    
  //ツイートウインドウを表示
    public void showTweet(Stage primaryStage) throws IOException{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Tweet.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TwitterJavaFX");
		primaryStage.show();
	}
    
    //アカウントブロックウインドウを表示
    public void showBlock(Stage primaryStage) throws IOException{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Block.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TwitterJavaFX");
		primaryStage.show();
	}

}
