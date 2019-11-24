package DAO;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBQuery {
    
    private Connection con;      

    public DBQuery() {
        con = connectDB();
    }

    public DBQuery(Connection con) {
        this.con = con;
    }

    public Connection connectDB() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/realbtl?useSSL=false";
        String username = "root";
        String password = "0963063105";
        try {            
            con = DriverManager.getConnection(url, username, password);
        } catch ( SQLException  e) {
            
        }
        return con;
    }    
    
        
    public ResultSet query(String sql) throws SQLException {  // chi nhan ve ket qua           
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);        
        return resultSet;
    }
    
    public void setConnection(Connection con) {
        this.con = con;
    }
    
    public Connection getConnection() {
        return con;
    }
}
