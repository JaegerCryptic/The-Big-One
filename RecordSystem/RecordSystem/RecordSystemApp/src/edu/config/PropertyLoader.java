/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.config;

/**
 *
 * @author Kyle
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static PropertyLoader propertyLoaderInstance;
    private final Properties properties = new Properties();
    
    
    private PropertyLoader() {
        loadProperties();
    }

    public static PropertyLoader getInstance() {
        synchronized (PropertyLoader.class) {
            if (propertyLoaderInstance == null) {
                propertyLoaderInstance = new PropertyLoader();
            }
        }
        return propertyLoaderInstance;
    }

    private void loadProperties() {
        
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    public String getProperty(String propertyName){
        return this.properties.get(propertyName) !=null ? this.properties.get(propertyName).toString(): "";
    }
}
