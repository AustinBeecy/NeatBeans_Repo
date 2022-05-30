// Commit Test
package netbeans_hw1;

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
 * @author Jd3ab
 */
public class DatabaseConnect extends Application {

//    Connection dbConn;
//    Statement commStmt;
//    ResultSet dbResults;

    Statement stmt;
    static Connection conn;

    static Connection conOracle(String id, String pw) throws Exception {
        String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
        OracleDataSource ds = new OracleDataSource();   // use of OracleDriver is from this class
        ds.setURL(connectionString);
        return ds.getConnection(id, pw);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // quering database and storing in result set
        conn = conOracle("emp", "emp");// LOG IN WITH USER NAME AND PW
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery("select * from Employee");

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
        //   @Override
        //    public void start (Stage primaryStage) throws Exception {
        //        
        //    }
        //         
        //    
        //    public void sendDBCommand(String sqlQuery)
        //    {
        //        // Set up your connection strings
        //        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        //        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        //        String userID = "javauser"; // Change to YOUR Oracle username
        //        String userPASS = "javapass"; // Change to YOUR Oracle password
        //        OracleDataSource ds;
        //        
        //        // Clear Box Testing - Print each query to check SQL syntax
        //        //  sent to this method.
        //        // You can comment this line out when your program is finished
        //        System.out.println(sqlQuery);
        //        
        //        // Lets try to connect
        //        try
        //        {
        //            // instantiate a new data source object
        //            ds = new OracleDataSource();
        //            // Where is the database located? Web? Local?
        //            ds.setURL(URL);
        //            // Send the user/pass and get an open connection.
        //            dbConn = ds.getConnection(userID,userPASS);
        //            // When we get results
        //            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
        //            //   will see our resultset update in real time.
        //            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
        //            //   data in our database by using the .update____() methods of
        //            //   the ResultSet class - TableView controls are impacted by
        //            //   this setting as well.
        //            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //            // We send the query to the DB. A ResultSet object is instantiated
        //            //  and we are returned a reference to it, that we point to from
        //            // dbResults.
        //            // Because we declared dbResults at the datafield level
        //            // we can see the results from anywhere in our Class.
        //            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
        //            // The results are stored in a ResultSet structure object
        //            // pointed to by the reference variable dbResults
        //            // Because we declared this variable globally above, we can use
        //            // the results in any method in the class.
        //        }
        //        catch (SQLException e)
        //        {
        //            System.out.println(e.toString());
        //        }
        //    }
    public static void main(String[] args) {
        launch(args);
    }

}
