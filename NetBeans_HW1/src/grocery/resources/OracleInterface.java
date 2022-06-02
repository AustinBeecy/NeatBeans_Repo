/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grocery.resources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Jd3ab
 */
public class OracleInterface {
    
    private Connection conn ;
    static Statement stmt;
    
    OracleInterface(){
        try {
            conn = conOracle("javauser", "javapass");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(OracleInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection conOracle(String id, String pw) throws SQLException{
        String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
        OracleDataSource ds = new OracleDataSource();
        ds.setURL(connectionString);
        return ds.getConnection(id, pw);
    }
   
  public Connection getConnection(){
       return this.conn; 
   }
  public Statement getStatement(){
      return this.stmt; 
  }
}