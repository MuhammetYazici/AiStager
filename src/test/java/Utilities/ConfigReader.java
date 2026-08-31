package Utilities;

import org.apache.commons.math3.fraction.ProperBigFractionFormat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static final String configFilePath = "src/test/resources/configuration.properties";

    static {
        try{
            FileInputStream file = new FileInputStream(configFilePath);
            properties.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("configuration.properties dosyası okunamadı"+ e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key){
        return Integer.parseInt(properties.getProperty(key));
    }

}
