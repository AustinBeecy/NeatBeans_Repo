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

    Statement stmt;
    static Connection conn;

    static Connection conOracle(String id, String pw) throws Exception {
        String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
        OracleDataSource ds = new OracleDataSource();
        ds.setURL(connectionString);
        return ds.getConnection(id, pw);
    }

    Stage window = new Stage();

    @Override
    public void start(Stage primaryStage) throws IOException, Exception {

        Parent root = FXMLLoader.load(getClass().getResource("resources/storePick.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Store Selection");
        window.show();

        conn = conOracle("javauser", "javapass");
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        try {
            ResultSet rs = stmt.executeQuery("select * from Employee");
            TableView<Employee> table = new TableView<>();
            ObservableList<Employee> data = FXCollections.observableArrayList();

            while (rs.next()) {
                Employee.id = rs.getString("Emp_ID");
                Employee.name = rs.getString("Emp_Name");
                Employee.phone = rs.getString("Emp_Phone");
                Employee.address = rs.getString("Emp_Address");
                Employee.salary = rs.getInt("Emp_Salary");
                Employee.shiftTime = rs.getString("Shift_Time");

                System.out.println(Employee.id);
                System.out.println(Employee.name);
                System.out.println(Employee.phone);
                System.out.println(Employee.address);
                System.out.println(Employee.salary);
                System.out.println(Employee.shiftTime);

                data.add(new Employee(
                        rs.getString("Emp_ID"), 
                        rs.getString("Emp_Name"), 
                        rs.getString("Emp_Phone"),
                        rs.getString("Emp_Address"),
                        rs.getInt("Emp_Salary"),
                        rs.getString("Shift_Time")
                ));
        }

//            // Text fields
//            TextField id = new TextField();
//            id.setMaxWidth(column1.getPrefWidth());
//            id.setPromptText("EMP ID");
//            
//            TextField name = new TextField();
//            name.setMaxWidth(column2.getPrefWidth());
//            name.setPromptText("EMP NAME");


            //******** Maybe could be used??
//            Button button = new Button("Add");
//         
//            button.setOnAction(e -> {
//              data.add(new Employee(Employee.id, Employee.name));
//               Employee.id.clear();
//               Employee.name.clear();
//            });



//            HBox hbox = new HBox(5);
//            hbox.getChildren().addAll(id, name);
//            VBox vbox = new VBox(5);
//            vbox.getChildren().addAll(label, table, hbox);
//            vbox.setPadding(new Insets(10, 0, 0, 10));
//            
//            Scene scene = new Scene(new Group());
//            ((Group)scene.getRoot()).getChildren().addAll(vbox);
//            
//            primaryStage.setScene(scene);
//            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public Stage getWindow() throws IOException {
        return this.window;
    }

    public static void main(String[] args) {
        launch(args);
    }
}




