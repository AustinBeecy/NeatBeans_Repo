package grocery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

// For ID numbers, when CREATING a new record, always let the system create the ID number for the user. 
// Never let the User choose what ID number to type in for a new record (as this can cause DB disaster!).
// Try to never have the user type in an ID number for any kind of selection. Remember that when giving the user the choice to edit a record, 
// always present them with a list of records to select from FIRST, so that they can indicate what record (product, employee, etc.) to change, 
// then populate a data entry form with that info, allowing them to only change the 1 or 2 fields they want to edit, then save.
public class SwitchScene1 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException, Exception {

        Parent root = FXMLLoader.load(getClass().getResource("resources/Products.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store Selection");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}




