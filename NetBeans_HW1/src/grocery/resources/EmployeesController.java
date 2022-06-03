/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grocery.resources;

import grocery.Employee;
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



public class EmployeesController implements Initializable {

    @FXML
    private TableView<Employee> emp_table;
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
    
    ObservableList<Employee> emps = FXCollections.observableArrayList();
    Connection conn;
    Statement stmt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SceneController sc = new SceneController(); 
        back_button.setOnAction(e -> sc.switchScene(e, "welcome.fxml"));
        OracleInterface oracle = new OracleInterface();
        conn = oracle.getConnection();
        stmt = oracle.getStatement();
        ResultSet rs;
        
//        String queryString = "select * from employee where employee.emp_id in" +
//        "(select position.emp_id from position where position.store_id in" +
//        "(select store_id from store where store.city = '" + Store.currentStore + "')))";
        

        try {
            rs = stmt.executeQuery("select * from Employee");
            while (rs.next()) {
                emps.add(new Employee(rs.getString("EMP_ID"), rs.getString("EMP_NAME"),  rs.getString("EMP_ADDRESS"), rs.getDouble("EMP_SALARY"), rs.getString("SHIFT_TIME")));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       for(Employee d: emps){
           d.printEmp();
     }
        
        col_emp_id.setCellValueFactory(new PropertyValueFactory<>("empID"));
        col_emp_name.setCellValueFactory(new PropertyValueFactory<>("empName"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_shiftTime.setCellValueFactory(new PropertyValueFactory<>("shift"));
        
        emp_table.setItems(emps);

    }
}

