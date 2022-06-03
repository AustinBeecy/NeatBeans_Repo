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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Employee_Table_ViewController implements Initializable {

    Connection conn;
    Statement stmt;

    @FXML
    TableView<Employee> table = new TableView<Employee>();

    @FXML
    private TableColumn<Employee, String> id;
    @FXML
    private TableColumn<Employee, String> name;
    @FXML
    private TableColumn<Employee, String> phone;
    @FXML
    private TableColumn<Employee, String> address;
    @FXML
    private TableColumn<Employee, Double> salary;
    @FXML
    private TableColumn<Employee, String> shiftTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        OracleInterface oracle = new OracleInterface();
        conn = oracle.getConnection();
        stmt = oracle.getStatement();
        ResultSet rs;

        ObservableList<Employee> data = FXCollections.observableArrayList();

        try {
            rs = stmt.executeQuery("select * from Employee");

            while (rs.next()) {

                data.add(new Employee(
                        rs.getString("Emp_ID"),
                        rs.getString("Emp_Name"),
                        rs.getString("Emp_Phone"),
                        rs.getString("Emp_Address"),
                        rs.getInt("Emp_Salary"),
                        rs.getString("Shift_Time")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Employee_Table_ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
//        address.setCellValueFactory(new PropertyValueFactory<>("address"));
//        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
//        shiftTime.setCellValueFactory(new PropertyValueFactory<>("shiftTime"));
        table.setItems(data);

    }

}
