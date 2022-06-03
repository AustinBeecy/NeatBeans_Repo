/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grocery.resources;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    Text currentStore; 
    
    @FXML
    Button emp_button; 
    @FXML
    Button prod_button; 
    @FXML
    Button sa_button; 
    @FXML
    Button sup_button; 
    @FXML
    Button inv_button; 
    
    SceneController sc = new SceneController(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setCurrentStore(); 
        SceneController sc = new SceneController();
        emp_button.setOnAction(e -> sc.switchScene(e, "Employee_Table_View.fxml"));
        prod_button.setOnAction(e -> sc.switchScene(e, "products.fxml"));
        sa_button.setOnAction(e -> sc.switchScene(e, "store_area.fxml"));
        sup_button.setOnAction(e -> sc.switchScene(e, "supplier.fxml"));
        inv_button.setOnAction(e -> sc.switchScene(e, "inventory.fxml"));
    }    
    public void setCurrentStore(){
        this.currentStore.setText(Store.currentStore);
    }
  
}
