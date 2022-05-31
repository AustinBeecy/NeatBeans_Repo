
// Commit Test

package netbeans_hw1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Jd3ab
 */
public class NetBeans_HW1 extends Application{
       

    
  static Connection conn;
	
	 static Connection conOracle(String id, String pw) throws Exception {
        String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
        OracleDataSource ds = new OracleDataSource();   // use of OracleDriver is from this class
        ds.setURL(connectionString);
        return ds.getConnection(id, pw);
    }
    // start acting as main function
         
	@Override
	public void start(Stage primaryStage) throws Exception {
	// quering database and storing in result set	
		
		conn = conOracle("javauser", "javapass");// LOG IN WITH USER NAME AND PW
		String sqlSelect = "select * from employee";
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_UPDATABLE);
		
        ResultSet rs = stmt.executeQuery(sqlSelect);
        rs.next(); }
    
        //setting up all variables to match database with text fields and listeners
        // to keep track of changes
        
        
        
        
        
        public static void main(String[] args) {
        launch(args);
    }
    
}
