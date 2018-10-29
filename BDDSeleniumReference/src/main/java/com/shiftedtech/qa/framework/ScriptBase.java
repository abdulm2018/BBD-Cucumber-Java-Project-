package com.shiftedtech.qa.framework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ScriptBase {

    private static final int DEFAULT_IMPLICITY_WAIT_TIME = 30;
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("********* Before Class ************");
    }

    @Before
    public void setUp() {
        System.out.println("********* Before ************");
        //https://github.com/bonigarcia/webdrivermanager
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        // For Firefox driver
        //FirefoxDriverManager.getInstance().setup();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITY_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(loadDataFromPropertiesFile("url"));
    }

    @After
    public void tearDown() {
        System.out.println("********* After ************");
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("********* After Class ************");
    }

    protected String loadDataFromPropertiesFile(String string) {
        final String file = System.getProperty("user.dir") + "/src/main/resources/resources.properties";
        Properties prop = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(file);
            // load a properties file
            prop.load(input);
            return prop.getProperty(string);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
