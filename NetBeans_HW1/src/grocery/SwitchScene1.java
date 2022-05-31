package grocery;

import static grocery.DatabaseConnect.conOracle;
import static grocery.NetBeans_HW1.conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author coolm
 */

public class SwitchScene1 extends Application {
    Statement stmt;
    static Connection conn;
    
    Stage window;
    Scene scene1, scene2, stores, storeOptions; 
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        conn = conOracle("emp", "emp");
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet employee = stmt.executeQuery("select * from Employee");
        ResultSet store = stmt.executeQuery("select * from Store");

        try {

            // Read in first values
//            if (employee.next()) {
//                System.out.println(employee.getString("Emp_ID"));
//            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        window = primaryStage;

        // Store Scene 
        // Run SQL query to get store locations
        // generate lables from SQL Query with a for loop 
        ArrayList<Label> storeLabels = new ArrayList<Label>();
        
        storeLabels.add(new Label("City 1")); // will be replaced with sql results
        storeLabels.add(new Label("City 2")); // will be replaced with sql results

        // same replace buttons with sql results in for loop 
        ArrayList<Button> storeButtons = new ArrayList<Button>();
        while (store.next()) {
            storeButtons.add(new Button(store.getString("City")));
        }
        
       // create layout for stores
        VBox storeLayout = new VBox(20);
        
        //populate stores layout with labels and buttons 
        for(int i = 0; i < storeLabels.size(); i++){
            storeLayout.getChildren().add(storeLabels.get(i));
            // for loop for buttons 
            storeLayout.getChildren().add(storeButtons.get(i));
            storeButtons.get(i).setOnAction(e -> window.setScene(scene2));
        }
        // create stores scene 
        stores = new Scene(storeLayout, 500, 300);
        
        //Create Label for store option
        Label welcomeLabel = new Label("Welcome!"); 
        // create buttons for store options 
        ArrayList<Button> storeOptionsButtons = new ArrayList<Button>(); 
        storeOptionsButtons.add(new Button("Employees"));
        storeOptionsButtons.add(new Button("Products"));
        storeOptionsButtons.add(new Button("Store Areas"));
        storeOptionsButtons.add(new Button("Suppliers"));
        storeOptionsButtons.add(new Button("Inventory"));
        //create layout for store options 
        VBox storeOptionsLayout = new VBox(20);
        storeOptionsLayout.getChildren().add(welcomeLabel);
        for(Button storeOptionsButton: storeOptionsButtons){
            storeOptionsLayout.getChildren().add(storeOptionsButton);
            storeOptionsButton.setOnAction(e -> window.setScene(stores));
        }
        //create scene 
        scene2 = new Scene(storeOptionsLayout, 500, 300);
        
        window.setScene(stores);
        window.setTitle("TITLE!");
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
