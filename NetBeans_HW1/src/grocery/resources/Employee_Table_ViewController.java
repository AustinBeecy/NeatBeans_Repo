/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author black
 */
public class Employee_Table_ViewController implements Initializable {
    Connection conn; 
    Statement stmt; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        OracleInterface oracle = new OracleInterface(); 
         conn = oracle.getConnection();
         stmt = oracle.getStatement();

//
//            ResultSet rs;
//        try {
//            rs = stmt.executeQuery("select * from Employee");
//       
//            TableView<Employee> table = new TableView<>();
//            ObservableList<Employee> data = FXCollections.observableArrayList();
//
//            while (rs.next()) {
//                Employee.id = rs.getString("Emp_ID");
//                Employee.name = rs.getString("Emp_Name");
//                Employee.phone = rs.getString("Emp_Phone");
//                Employee.address = rs.getString("Emp_Address");
//                Employee.salary = rs.getInt("Emp_Salary");
//                Employee.shiftTime = rs.getString("Shift_Time");
//
//                System.out.println(Employee.id);
//                System.out.println(Employee.name);
//                System.out.println(Employee.phone);
//                System.out.println(Employee.address);
//                System.out.println(Employee.salary);
//                System.out.println(Employee.shiftTime);
//
//                data.add(new Employee(
//                        rs.getString("Emp_ID"), 
//                        rs.getString("Emp_Name"), 
//                        rs.getString("Emp_Phone"),
//                        rs.getString("Emp_Address"),
//                        rs.getInt("Emp_Salary"),
//                        rs.getString("Shift_Time")
//                ));
//        }
//             } catch (SQLException ex) {
//            Logger.getLogger(Employee_Table_ViewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
    
}
