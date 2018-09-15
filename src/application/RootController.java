package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
 
public class RootController implements Initializable{

    @FXML
    private TextField txtName;
    @FXML
    private Label     lblAnswer;
    public ToggleGroup toggle1;
    int radio;
    Stage stage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
    }
    @FXML
    private void btnOK_onClick(MouseEvent aEvent) {
        System.out.println("btnOK_onClick");
        switch (radio) {
		case 1: System.out.println("ツイート"); break;
		case 2: System.out.println("ブロック"); 
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Block.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		break;
		default: break;
		}
    }
    @FXML
    private void mnuClose_onClick(ActionEvent event) {
        System.out.println("mnuClose_onClick");
        Platform.exit();
    }
    
    @FXML
    private void handleRadio1(ActionEvent event) {
        System.out.println("handleRadio1");
        radio = 1;
    }
    
    @FXML
    private void handleRadio2(ActionEvent event) {
        System.out.println("handleRadio2");
		stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        radio = 2;
    }
    
}
