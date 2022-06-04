
package grocery.resources;

import grocery.Product;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/*
 * The Products Controller class contains everything for creating the product table and populating product data
 * Also includes feature of adding products into database
*/

public class ProductsController implements Initializable {

    // TableView and TableColumn setup using Product class
    @FXML
    private TableView<Product> product_table; 
    @FXML
    Button back_button;
    @FXML
    private TableColumn<Product, String> col_description; 
    @FXML 
    private TableColumn<Product, Integer> col_id; 
    @FXML 
    private TableColumn<Product, Double> col_price; 
    @FXML 
    private TableColumn<Product, String> col_name; 
    @FXML 
    private TableColumn<Product, String> col_supID; 
    @FXML 
    private TableColumn<Product, String> col_areaID;

    // Text fields for user entry to add row
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_price;
    @FXML
    private TextField tf_description;
    @FXML
    private ChoiceBox cb_sup_id; 
    @FXML
    private ChoiceBox cb_area_id; 
    
    int idCount = 1; // Count variable which will be incremented
     
    ObservableList<Product> plist = FXCollections.observableArrayList();
    Connection conn; 
    Statement stmt; 
    Product productToAdd; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Queries which are not currently in use 
        String findStoreID = "select Store_ID from Store where store.city = '" + Store.currentStore + "'";
        String allAreas = "select area_id from StoreArea where StoreArea.Store_ID = '" + findStoreID + "'";
        
        SceneController sc = new SceneController(); 
        back_button.setOnAction(e -> sc.switchScene(e, "welcome.fxml")); // Back button switches to previous screen
        cb_sup_id.getItems().addAll("Sup1", "Sup2", "Sup3", "Sup4", "Sup5"); // Specify all suppliers to populate drop down
        // "select supplier_id unique from supplier"

        cb_area_id.getItems().addAll("S1-4","S1-5","S1-8","S1-12","S2-4","S2-6","S2-11"); // Specify all area ids to populate drop down
        // "select area_id unique from storearea" 
        
        updateTable(); // Calls update table method
    }
    
  
    // This is called when submit button is pressed to add in new product
    public void onSubmit(){
        
        // INSERT statement for submit button. Includes idCount which increments to ensure that no id is being entered in twice
        String statement = "INSERT INTO Product (Product_ID, Product_Name, Area_ID, Supp_ID, Price_Paid, Product_Desc) VALUES (" + idCount + ", '" + tf_name.getText() +"', '" + cb_area_id.getValue() +"', '" + cb_sup_id.getValue() + "', " + tf_price.getText() + ", '" + tf_description.getText() + "')";
        System.out.println(statement);
        try{
            stmt.executeUpdate(statement); // Executes the SQL statement
            updateTable(); 
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void updateTable(){
        
         OracleInterface oracle = new OracleInterface(); 
         conn = oracle.getConnection();
         stmt = oracle.getStatement();
         plist.clear();
         ResultSet rs;
         getNextID(); // Calls nextID method
         
        // Loops through all rows in Product and reads in value from query to populate list
        try {
            rs = stmt.executeQuery("select * from product");
            while (rs.next()){
                plist.add(new Product(rs.getInt("PRODUCT_ID"), rs.getString("PRODUCT_NAME"), rs.getDouble("PRICE_PAID"), rs.getString("PRODUCT_DESC"), rs.getString("SUPP_ID"), rs.getString("AREA_ID")));
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        // Set all the values in the tables
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("productID"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_supID.setCellValueFactory(new PropertyValueFactory<>("supID"));
        col_areaID.setCellValueFactory(new PropertyValueFactory<>("areaID"));
        product_table.setItems(plist); 
        product_table.refresh();
    }
    
   public void getNextID(){
        OracleInterface oracle = new OracleInterface(); 
         conn = oracle.getConnection();
         stmt = oracle.getStatement();
         ResultSet rs;
         try {
            rs = stmt.executeQuery("select * from product");
            while (rs.next()){
               idCount = rs.getInt("PRODUCT_ID"); // Gets the product id and sets it to the int count
            }
            ++idCount; // Increments the ID to avoid duplicates
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
