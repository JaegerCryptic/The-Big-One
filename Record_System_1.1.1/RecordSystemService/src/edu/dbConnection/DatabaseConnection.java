
package edu.dbConnection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection(Properties contextProperties) {

        Connection databaseConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
                        databaseConnection = DriverManager.getConnection(
                                contextProperties.getProperty("DB_URL"), contextProperties.getProperty("DB_USER"), contextProperties.getProperty("DB_PASSWORD"));
                        
        } catch (Exception e) {
            System.out.println(e);
        }

        return databaseConnection;
    }
}
