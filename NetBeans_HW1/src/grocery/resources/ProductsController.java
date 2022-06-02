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
    @FXML 
    private TableColumn<Product, Double> col_name; 
    
    ObservableList<Product> plist = FXCollections.observableArrayList();
    Connection conn; 
    Statement stmt; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OracleInterface oracle = new OracleInterface(); 
         conn = oracle.getConnection();
         stmt = oracle.getStatement();
         ResultSet rs;
         String queryString = "select * from product where product.product_id in " +
            "(select inventory.product_id from inventory where inventory.area_id in " +
            "(select storeArea.area_id from storeArea where storeArea.store_id in " +
            "(select store_id from store where store.city = '" + Store.currentStore + "')))";
         System.out.println(queryString);
         
        try {
            rs = stmt.executeQuery(queryString);
            
            while (rs.next()){
                plist.add(new Product(rs.getString("PRODUCT_ID"), rs.getString("PRODUCT_NAME"), rs.getDouble("PRICE_PAID"), rs.getString("PRODUCT_DESC")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("productID"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        product_table.setItems(plist);
    }
}
