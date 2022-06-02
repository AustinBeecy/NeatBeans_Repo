/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery.resources;

import grocery.Product;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author black
 */
public class ProductsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Product> product_table; 
    @FXML
    private TableColumn<Product, String> col_description; 
    @FXML 
    private TableColumn<Product, String> col_id; 
    @FXML 
    private TableColumn<Product, Double> col_price; 
    
    ObservableList<Product> plist = FXCollections.observableArrayList();
    Connection conn; 
    Statement stmt; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OracleInterface oracle = new OracleInterface(); 
         conn = oracle.getConnection();
         stmt = oracle.getStatement();
         ResultSet rs;
         
        try {
            rs = stmt.executeQuery("select * from product");
            
            while (rs.next()){
                plist.add(new Product(rs.getString("PRODUCT_NAME"), rs.getDouble("PRICE_PAID"), rs.getString("PRODUCT_DESC")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        product_table.setItems(plist);
    }
}
