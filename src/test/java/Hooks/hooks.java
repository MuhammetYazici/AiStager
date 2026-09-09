package Hooks;

import Utilities.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.math3.analysis.function.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;


public class hooks {
    private static final Logger LOGGER = LogManager.getLogger(hooks.class);

    @Before
    public void setup(Scenario scenario){
        try{
            String browserFromXMl =
                    Reporter
                            .getCurrentTestResult()
                            .getTestContext()
                            .getCurrentXmlTest()
                            .getParameter("browser");


            if (browserFromXMl != null){
                BaseDriver.setBrowser(browserFromXMl);
            }else {
                BaseDriver.setBrowser();
            }
        }catch (Throwable ex) {                // Throwable : Exception ve Error olarak iki hata dalını da kapsıyor
            BaseDriver.setBrowser();           // TestNG context yok → config dosyasına düş
        }

        BaseDriver.getDriver();                // Tarayıcıyı aç

        LOGGER.info("Scenario Started: {} | Browser: {}",
                scenario.getName(), BaseDriver.getBrowserName());
    }

    @After
    public void after(Scenario scenario){
        if (scenario.isFailed() && BaseDriver.getDriver() instanceof TakesScreenshot){
            TakesScreenshot ts = (TakesScreenshot) BaseDriver.getDriver();
            byte[] yer = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(yer,"image/png",scenario.getName());
            LOGGER.error("Scenario Failed: {}", scenario.getName());
        }else {
            LOGGER.info("Scenario Passed: {}",scenario.getName());
        }
        BaseDriver.quitDriver();
        LOGGER.info("Driver closed.");
    }

}
