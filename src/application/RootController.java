package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
 
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
    private void btnOK_onClick(MouseEvent aEvent) throws IOException {
        System.out.println("btnOK_onClick");
        Main mainWindow = new Main();
        switch (radio) {
		case 1: System.out.println("ツイート"); break;
		case 2: System.out.println("ブロック"); mainWindow.showBlock(stage); break;
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
