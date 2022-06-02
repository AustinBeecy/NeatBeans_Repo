/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grocery.resources;

import grocery.SwitchScene1;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author Jd3ab
 */
public class StorePickController implements Initializable {

    @FXML
    public GridPane gridPane;
    Statement stmt;
    static Connection conn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     
         try {
             // TODO
             OracleInterface oracle = new OracleInterface();
             conn = oracle.getConnection();
             stmt = oracle.getStatement();
             ResultSet store = stmt.executeQuery("select * from Store");
             int i = 1; 
             String welcomeFXML = "welcome.fxml";
             while(store.next()){
             Text text = new Text(store.getString("State"));
             // add styling to text
             Button button = new Button(store.getString("City"));
             // add Styling to button
             SceneController sc = new SceneController(); 
             button.setOnAction(e -> {
                
                 try {
                     Store.currentStore = button.getText();
                     sc.switchScene(e,welcomeFXML);
                 } catch (IOException ex) {
                     Logger.getLogger(StorePickController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             });
               
             gridPane.add(text, 1, i);
             i++;
             gridPane.add(button, 1, i);
             i++; 
             }
         } catch (Exception ex) {
             Logger.getLogger(StorePickController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
}