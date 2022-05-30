package netbeans_hw1;

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
    
    Stage window;
    Scene scene1, scene2, stores, storeOptions; 
    
    @Override
    public void start (Stage primaryStage) throws Exception {
        window = primaryStage;
        
        // Store Scene 
        // Rund SQL query to get store locations
        // gnerate lables from SQL Query with a for loop 
        ArrayList<Label> storeLabels = new ArrayList<Label>(); 
        storeLabels.add(new Label("City 1")); // will be replaced with sql results
        storeLabels.add(new Label("City 2")); // will be replaced with sql results
        
        // same replace buttons with sql results in for loop 
        ArrayList<Button> storeButtons = new ArrayList<Button>(); 
        storeButtons.add(new Button("City Location 1")); // replace with sql results
        storeButtons.add(new Button("City Location 2")); // replace with sql results 
        
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
        storeOptionsButtons.add(new Button("Employes"));
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
