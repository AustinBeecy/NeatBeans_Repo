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

/*
 * The SwitchScene class sets the main FXML screen and stage
*/
public class SwitchScene1 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException, Exception {

        Parent root = FXMLLoader.load(getClass().getResource("resources/storePick.fxml")); //Sets main fxml screen
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store Selection");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}




