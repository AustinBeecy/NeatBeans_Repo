
package grocery.resources;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Scene controller class allows for switching between scenes on button press
 */
public class SceneController {
    private Stage stage; 
    private Scene scene; 
    private Parent root; 
    
    // SwitchScene is called in different places with an ActionEvent and desired fxml screen to switch to for that button press
    public void switchScene(ActionEvent event, String fxml) {
       
        Parent root;
        try {
                root = FXMLLoader.load(getClass().getResource(fxml)); // Gets the FXML resource
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); // Displays new scene
                
        } catch (IOException ex) {
            Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
