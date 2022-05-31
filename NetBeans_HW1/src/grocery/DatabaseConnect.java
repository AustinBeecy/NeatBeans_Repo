
package grocery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 */

public class DatabaseConnect extends Application {

    Statement stmt;
    static Connection conn;

    static Connection conOracle(String id, String pw) throws Exception {
        String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
        OracleDataSource ds = new OracleDataSource();   
        ds.setURL(connectionString);
        return ds.getConnection(id, pw);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        conn = conOracle("emp", "emp");
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from Employee");

        String id = null;
        String first = null;
        String last = null;
        int salary = 0;
        String title = null;

        try {

            // Read in first values
            if (rs.next()) {
                id = rs.getString("Emp_ID");
                System.out.println(id);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
