/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class ProductsController implements Initializable {


    @FXML
    private TableView<Product> product_table; 
    @FXML
    Button back_button;
    @FXML
    private TableColumn<Product, String> col_description; 
    @FXML 
    private TableColumn<Product, String> col_id; 
    @FXML 
    private TableColumn<Product, Double> col_price; 
    @FXML 
    private TableColumn<Product, String> col_name; 
    @FXML 
    private TableColumn<Product, String> col_supID; 
    @FXML 
    private TableColumn<Product, String> col_areaID;
    @FXML
    private TextField tf_id; 
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
    
   
     
    ObservableList<Product> plist = FXCollections.observableArrayList();
    Connection conn; 
    Statement stmt; 
    Product productToAdd; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SceneController sc = new SceneController(); 
        back_button.setOnAction(e -> sc.switchScene(e, "welcome.fxml"));
        cb_sup_id.getItems().addAll("Supp1", "Supp2"); // This is hard coded should be changed to a query to find all suppliers 
        cb_area_id.getItems().addAll("S1-1","S1-2","S1-3","S1-4","S1-5","S2-1","S2-2","S2-3","S2-4","S2-5","S2-6","S2-7","S2-8","S2-9" );// This is hard coded should be changed to a query to find all store areas  
        OracleInterface oracle = new OracleInterface(); 
         conn = oracle.getConnection();
         stmt = oracle.getStatement();
         ResultSet rs;
         
         String queryString = "select * from product where product.product_id in " +
            "(select inventory.product_id from inventory where inventory.area_id in " +
            "(select storeArea.area_id from storeArea where storeArea.store_id in " +
            "(select store_id from store where store.city = '" + Store.currentStore + "')))";
         
         
        try {
            rs = stmt.executeQuery(queryString);
            
            while (rs.next()){
                plist.add(new Product(rs.getString("PRODUCT_ID"), rs.getString("PRODUCT_NAME"), rs.getDouble("PRICE_PAID"), rs.getString("PRODUCT_DESC"), rs.getString("SUPP_ID"), rs.getString("AREA_ID")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("productID"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_supID.setCellValueFactory(new PropertyValueFactory<>("supID"));
        col_areaID.setCellValueFactory(new PropertyValueFactory<>("areaID"));
        product_table.setItems(plist);
    }
    public void onSubmit(){
        
        System.out.println(tf_id.getText());
        System.out.println(tf_name.getText());
        System.out.println(tf_description.getText());
        System.out.println(tf_price.getText());
        System.out.println(cb_sup_id.getValue());
        System.out.println(cb_area_id.getValue());
        
        /////USE THESE VALUES TO MAKE AN UPDATE QUERY THEN REFRESH THE SCENCE 
        // Then look up how to update table View
        
    }
}
