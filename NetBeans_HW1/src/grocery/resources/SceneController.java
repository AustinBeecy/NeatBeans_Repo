/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grocery.resources;

import java.awt.Desktop.Action;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jd3ab
 */
public class SceneController {
    private Stage stage; 
    private Scene scene; 
    private Parent root; 
    
    public void switchToWelcome(ActionEvent event, String fxml) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
}
