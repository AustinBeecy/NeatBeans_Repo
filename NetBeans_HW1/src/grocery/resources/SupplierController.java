package grocery.resources;

import grocery.Supplier;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class SupplierController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Supplier> supplier_table; 
    @FXML
    Button back_button;
    @FXML
    private TableColumn<Supplier, String> col_supp_id; 
    @FXML 
    private TableColumn<Supplier, String> col_supp_name; 
    @FXML 
    private TableColumn<Supplier, String> col_supp_address; 
    @FXML 
    private TableColumn<Supplier, String> col_con_name; 
    @FXML 
    private TableColumn<Supplier, String> col_con_phone; 
    @FXML 
    private TableColumn<Supplier, String> col_con_email;
    
    // TextFields to use for implementation of adding entries
    @FXML
    private TextField tf_id; 
    @FXML
    private TextField tf_name; 
    @FXML
    private TextField tf_address; 
    @FXML
    private TextField tf_email; 
    @FXML
    private TextField tf_phone; 

    ObservableList<Supplier> slist = FXCollections.observableArrayList();
    Connection conn; 
    Statement stmt; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OracleInterface oracle = new OracleInterface(); 
        SceneController sc = new SceneController(); 
        back_button.setOnAction(e -> sc.switchScene(e, "welcome.fxml")); // Goes back to welcome screen
        
        conn = oracle.getConnection();
        stmt = oracle.getStatement();
        ResultSet rs;
        // Selects all suppliers within the current store
        String queryString = "select * from supplier where supplier.supp_id in " +
                "(select product.supp_id from product where product.area_id in" +
                "(select storeArea.area_id from storeArea where storeArea.store_id in" +
                "(select store_id from store where store.city = '" + Store.currentStore + "')))";
        System.out.println(queryString);
         
        try {
            rs = stmt.executeQuery(queryString);
            
            // Reads from database and adds into list
            while (rs.next()){
                slist.add(new Supplier(
                        rs.getString("SUPP_ID"), 
                        rs.getString("SUPP_NAME"), 
                        rs.getString("SUPP_ADDRESS"), 
                        rs.getString("SALES_CONTACT_NAME"), 
                        rs.getString("SALES_CONTACT_PHONE"), 
                        rs.getString("SALES_CONTACT_EMAIL")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        // Adds values into table cells
        col_supp_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_supp_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_supp_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_con_name.setCellValueFactory(new PropertyValueFactory<>("contactName"));
        col_con_phone.setCellValueFactory(new PropertyValueFactory<>("contactPhone"));
        col_con_email.setCellValueFactory(new PropertyValueFactory<>("contactEmail"));
        supplier_table.setItems(slist);
    }
}

    

