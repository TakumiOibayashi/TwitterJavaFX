package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
 
public class SampleController implements Initializable{
 
    @FXML
    private TextField txtName;
    @FXML
    private Label     lblAnswer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
    }
    @FXML
    private void btnOK_onClick(MouseEvent aEvent) {
        System.out.println("btnOK_onClick");
        
        try {
        	
            ProcessBuilder builder = new ProcessBuilder("python", "/home/oiba/Python/Twitter/block.py",txtName.getText());
            Process process = builder.start();
 
            InputStream s = process.getInputStream();
            InputStreamReader stream = new InputStreamReader(s, "UTF-8");
            
            while (true) {
                int c = stream.read();
                if (c == -1) {
                    stream.close();
                    break;
                }
                System.out.print((char)c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        
        lblAnswer.setText(txtName.getText() + "を含むツイートをしたアカウントをブロックしました．");
    }
    @FXML
    private void mnuClose_onClick(ActionEvent event) {
        System.out.println("mnuClose_onClick");
        Platform.exit();
    }
}
