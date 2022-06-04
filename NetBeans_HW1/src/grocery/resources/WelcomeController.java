
package grocery.resources;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class WelcomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Text currentStore; 
    
    // Navigation buttons within Welcome screen for choosing what data to select
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
        // Switches scenes based on the button pressed
        setCurrentStore(); 
        SceneController sc = new SceneController();
        emp_button.setOnAction(e -> sc.switchScene(e, "Employee_Table_View.fxml"));
        prod_button.setOnAction(e -> sc.switchScene(e, "products.fxml"));
        sa_button.setOnAction(e -> sc.switchScene(e, "store_area.fxml"));
        sup_button.setOnAction(e -> sc.switchScene(e, "supplier.fxml"));
        inv_button.setOnAction(e -> sc.switchScene(e, "inventory.fxml"));
    }    
    public void setCurrentStore(){
        this.currentStore.setText(Store.currentStore); // Sets the current store based on the store selection
    }
  
}
