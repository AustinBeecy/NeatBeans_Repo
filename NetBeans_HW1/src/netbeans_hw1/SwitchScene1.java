package netbeans_hw1;

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
    Scene scene1, scene2;
    
    @Override
    public void start (Stage primaryStage) throws Exception {
        window = primaryStage;
        
        // Button 1
        Label label1 = new Label("Welcome!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));
        
        // Layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 500, 300);
        
        // Button 2
        Button button2 = new Button("Back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        
        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 500, 300);
        
        window.setScene(scene1);
        window.setTitle("TITLE!");
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
