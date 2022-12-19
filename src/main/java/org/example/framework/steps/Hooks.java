package org.example.framework.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.framework.managers.DriverManager;
import org.example.framework.managers.InitManager;
import org.example.framework.managers.TestPropManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    private final DriverManager driverManager = DriverManager.getDriverManager();


    @Before
    public void before(){
        InitManager.initFramework();
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty("base.url"));
    }

    @After
    public void after(Scenario scenario){
        String screenshotName = scenario.getName().replaceAll(" ","_");
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driverManager.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",screenshotName);
        }
        InitManager.quitFramework();
    }
}
