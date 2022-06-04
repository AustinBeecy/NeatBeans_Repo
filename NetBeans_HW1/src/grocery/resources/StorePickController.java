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
 * StorePickController class contains implementation for the first screen the user will see
 */
public class StorePickController implements Initializable {

    @FXML
    public GridPane gridPane;
    Statement stmt;
    static Connection conn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            OracleInterface oracle = new OracleInterface();
            conn = oracle.getConnection();
            stmt = oracle.getStatement();
            ResultSet store = stmt.executeQuery("select * from Store"); // Query to select everything from store table
            int i = 1;
            String welcomeFXML = "welcome.fxml";
            while (store.next()) {
                Text text = new Text(store.getString("State")); // Create text that will pull state from database
                Button button = new Button(store.getString("City")); // Create button that will pull city from database
                
                SceneController sc = new SceneController(); 
                button.setOnAction(e -> {

                    Store.currentStore = button.getText(); // Sets the current store depending on which button is pressed
                    sc.switchScene(e, welcomeFXML); // Calls switchscene and switches to welcomeFXML
                });

                gridPane.add(text, 1, i); // Adds text and buttons to grid
                i++;
                gridPane.add(button, 1, i);
                i++;
            }
        } catch (Exception ex) {
            Logger.getLogger(StorePickController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
