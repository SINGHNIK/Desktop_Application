/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikhil
 */
public class DbConnection {
      Connection conn = null;
    public static Connection Connect() {
      
        try {
            String url = "jdbc:mysql://localhost:3306/feedback";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Success");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
            
        }
            
    }

}
