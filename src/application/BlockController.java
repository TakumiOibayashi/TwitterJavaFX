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
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
 
public class BlockController implements Initializable{
 
    @FXML
    private TextField txtName;
    @FXML
    private Label lblAnswer;
    private Stage stage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    //「ブロック」ボタンを押してblock.pyを実行する
    @FXML
    private void btnBlock_onClick(MouseEvent aEvent) {
        System.out.println("btnBlock_onClick");
        
        try {
        	System.out.println("python実行前");
            ProcessBuilder builder = new ProcessBuilder("python", "/home/oiba/Python/Twitter/block.py",txtName.getText());
            System.out.println("python実行後");
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
    
    //「キャンセル」ボタンを押してメインウインドウに戻る
    @FXML
    private void btnCancel_onClick(ActionEvent event) throws IOException {
        System.out.println("btnCancel_onClick");
        Main mainWindow = new Main();
        stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        mainWindow.showRoot(stage);
    }
    
    //メニューバーの「閉じる」を押してウインドウを閉じる
    @FXML
    private void mnuClose_onClick(ActionEvent event) {
        System.out.println("mnuClose_onClick");
        Platform.exit();
    }
}
