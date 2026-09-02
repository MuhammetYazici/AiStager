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
    public Logger logger = LogManager.getLogger(this.getClass());

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
                BaseDriver.setBrowser();
            }
        }catch (Exception r){
            System.out.println(r);
        }
    }

    @After
    public void after(Scenario scenario){
        if (scenario.isFailed() && BaseDriver.getDriver() instanceof TakesScreenshot){
            TakesScreenshot ts = (TakesScreenshot) BaseDriver.getDriver();
            byte[] yer = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(yer,"image/png","screenshot");
        }
        BaseDriver.quitDriver();
    }

}
