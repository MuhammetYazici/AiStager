package Utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class BaseDriver {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static void setBrowser(){threadBrowserName.set(ConfigReader.getProperty("browser"));}

    public static WebDriver getDriver(){
        if (threadDriver.get()==null){
            if (threadBrowserName.get()==null){
                threadBrowserName.set("chrome");
            }

            switch (threadBrowserName.get().toLowerCase()){
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
                    threadDriver.set(firefoxDriver);
                    break;
                case "safari":
                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    SafariDriver safariDriver = new SafariDriver(safariOptions);
                    threadDriver.set(safariDriver);
                    break;
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
                    threadDriver.set(chromeDriver);

            }

            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getIntProperty("pageLoadTimeOut")));
        }
        return threadDriver.get();
    }

    public static void quitDriver(){
        if (threadDriver.get() != null){
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }

}
