/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery.resources;

import grocery.Inventory;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author black
 */
public class InventoryController implements Initializable {
/**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Inventory> inv_table; 
    @FXML
    Button back_button;
    @FXML
    private TableColumn<Inventory, String> col_area_id; 
    @FXML 
    private TableColumn<Inventory, String> col_prod_id; 
    @FXML 
    private TableColumn<Inventory, Integer> col_product_q; 

    
    ObservableList<Inventory> ilist = FXCollections.observableArrayList();
    Connection conn; 
    Statement stmt; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SceneController sc = new SceneController(); 
        back_button.setOnAction(e -> sc.switchScene(e, "welcome.fxml"));
        
        OracleInterface oracle = new OracleInterface(); 
         conn = oracle.getConnection();
         stmt = oracle.getStatement();
         ResultSet rs;
         String queryString = "select * from inventory where inventory.area_id in " +
                "(select storeArea.area_id from storeArea where storeArea.store_id in " +
                "(select store.store_id from store where store.city = '" + Store.currentStore + "'))";
         System.out.println(queryString);
         
        try {
            rs = stmt.executeQuery(queryString);
            
            while (rs.next()){
                ilist.add(new Inventory(rs.getString("AREA_ID"), rs.getString("PRODUCT_ID"), rs.getInt("PRODUCT_QUANT")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        col_area_id.setCellValueFactory(new PropertyValueFactory<>("areaID"));
        col_prod_id.setCellValueFactory(new PropertyValueFactory<>("productID"));
        col_product_q.setCellValueFactory(new PropertyValueFactory<>("productQuant"));
        inv_table.setItems(ilist);
    }
    
}
