
package grocery.resources;

import grocery.Employee;
import java.awt.TextField;
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
import javafx.scene.control.cell.PropertyValueFactory;

/*
 * The Employee Controller class contains everything for creating the employee table and populating employee data
*/

public class Employee_Table_ViewController implements Initializable {

    Connection conn;
    Statement stmt;

    @FXML
    TableView<Employee> emp_table;
    @FXML
    Button back_button; 
    @FXML
    private TableColumn<Employee, String> col_emp_id;
    @FXML
    private TableColumn<Employee, String> col_emp_name;
    @FXML
    private TableColumn<Employee, String> col_address;
    @FXML
    private TableColumn<Employee, Double> col_salary;
    @FXML
    private TableColumn<Employee, String> col_shiftTime;
    
    // TextFields to use for implementation of adding entries
//    @FXML 
//    private TextField tf_name;
//    @FXML 
//    private TextField tf_address;
//    @FXML 
//    private TextField tf_salary;
//    @FXML 
//    private ChoiceBox cb_shift;

    
    ObservableList<Employee> emps = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SceneController sc = new SceneController(); 
        back_button.setOnAction(e -> sc.switchScene(e, "welcome.fxml")); // Back button to switch scene
        OracleInterface oracle = new OracleInterface();
        conn = oracle.getConnection();
        stmt = oracle.getStatement();
        ResultSet rs;
        
        // Pulls data from database into list
        try {
            rs = stmt.executeQuery("select * from Employee");
            while (rs.next()) {
                emps.add(new Employee(rs.getString("EMP_ID"), rs.getString("EMP_NAME"),  rs.getString("EMP_ADDRESS"), rs.getDouble("EMP_SALARY"), rs.getString("SHIFT_TIME")));   
            }

        } catch (SQLException ex) {
            Logger.getLogger(Employee_Table_ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Employee d: emps){
            d.printEmp();
        }
        
        // Set all values into the tables
        col_emp_id.setCellValueFactory(new PropertyValueFactory<>("empid"));
        col_emp_name.setCellValueFactory(new PropertyValueFactory<>("empname"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_shiftTime.setCellValueFactory(new PropertyValueFactory<>("shift"));
        emp_table.setItems(emps);
    }
   
}
