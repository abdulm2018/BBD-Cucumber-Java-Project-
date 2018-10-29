package com.shiftedtech.qa.steps;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.util.concurrent.TimeUnit;


public class StepBase {
    protected WebDriver driver = null;
    protected ApplicationBase heatclinic = null;

    public StepBase() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
}
