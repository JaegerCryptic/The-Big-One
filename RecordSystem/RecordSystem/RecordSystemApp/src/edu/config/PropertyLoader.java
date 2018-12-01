package edu.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static PropertyLoader propertyLoaderInstance;
    private final Properties properties = new Properties();

    private PropertyLoader() {
        loadProperties(null);
    }

    private PropertyLoader(File configFile) {
        loadProperties(configFile);
    }

    public static PropertyLoader getInstance() {
        synchronized (PropertyLoader.class) {
            if (propertyLoaderInstance == null) {
                propertyLoaderInstance = new PropertyLoader();
            }
        }
        return propertyLoaderInstance;
    }

    public static Properties getProperties(){
        return propertyLoaderInstance.properties; 
    }
    public static PropertyLoader getInstance(File configFile) {
        synchronized (PropertyLoader.class) {
            if (propertyLoaderInstance == null) {
                propertyLoaderInstance = new PropertyLoader(configFile);
            }
        }
        return propertyLoaderInstance;
    }

    private void loadProperties(File configFile) {

        InputStream input = null;

        try {

            input = new FileInputStream(configFile);

            properties.load(input);

            System.out.println("Loading properties from : " + configFile.getAbsolutePath());
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

    public String getProperty(String propertyName) {
        return this.properties.get(propertyName) != null ? this.properties.get(propertyName).toString() : "";
    }
}
