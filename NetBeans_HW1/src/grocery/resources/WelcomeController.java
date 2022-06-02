/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grocery.resources;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Jd3ab
 */
public class WelcomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Text currentStore = null; 
    SceneController sc = new SceneController(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setCurrentStore(); 
        System.out.println(currentStore);
    }    
    public void setCurrentStore(){
        this.currentStore.setText(Store.currentStore);
    }
  
}
