/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dbConnection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aeron
 */
public class DatabaseConnection {

    public static Connection getConnection() {

        Connection databaseConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classroom_records", "root", "root123");
        } catch (Exception e) {
            System.out.println(e);
        }

        return databaseConnection;
    }
}
