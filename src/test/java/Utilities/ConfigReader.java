package Utilities;

import org.apache.commons.math3.fraction.ProperBigFractionFormat;
import net.datafaker.Faker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static Faker faker;
    private static final String configFilePath = "src/test/resources/configuration.properties";
    private static String dynmicEmail;
    private static String dynmicPassword;

    static {
        try{
            FileInputStream file = new FileInputStream(configFilePath);
            properties.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("configuration.properties dosyası okunamadı"+ e);
        }
    }

    public static String getRandomEmail(){
        dynmicEmail = faker.internet().emailAddress();
        return dynmicEmail;
    }

    public static String getRandomPassword(){
        dynmicPassword =  faker.internet().password();
        return dynmicPassword;
    }

    public static String getGenerateEmail(){
        if (dynmicEmail == null){
            return getRandomEmail();
        }
        return dynmicEmail;
    }

    public static String getGeneratePassword(){
        if (dynmicPassword == null){
            return getRandomPassword();
        }
        return dynmicPassword;
    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key){
        return Integer.parseInt(properties.getProperty(key));
    }

}
