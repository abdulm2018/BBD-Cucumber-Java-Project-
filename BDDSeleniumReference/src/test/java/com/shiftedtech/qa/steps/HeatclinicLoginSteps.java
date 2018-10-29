package com.shiftedtech.qa.steps;


import com.shiftedtech.qa.framework.utils.RobotService;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;



public class HeatclinicLoginSteps extends StepBase{
    RobotService robot = RobotService.getInstance();

    @Before
    public void setUp() {
        //https://github.com/bonigarcia/webdrivermanager
//        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
        //ChromeDriverManager.getInstance().setup();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        heatclinic = new ApplicationBase(driver);
    }
    @After
    public void teardown(Scenario scenario) {
        if(scenario.isFailed()){
            robot.takeScreenshot(System.getProperty("user.dir") + "/screenshots/");
        }
        driver.close();
        driver.quit();
        heatclinic = null;
    }

    @Given("^As a not validated user$")
    public void as_a_not_validated_user() throws Throwable {

    }

    @When("^Browse to the url \"([^\"]*)\"$")
    public void browse_to_the_url(String arg1) throws Throwable {
        driver.navigate().to(arg1);
    }

    @Then("^Heatclinic home page should show$")
    public void heatclinic_home_page_should_show() throws Throwable {
        heatclinic.homePage().verifyHomepageTitle();
    }

    @When("^User click login button$")
    public void user_click_login_button() throws Throwable {
        heatclinic.homePage().navigateToLoginPage();

    }

    @When("^Enter \"([^\"]*)\" as email address$")
    public void enter_as_email_address(String arg1) throws Throwable {
        heatclinic.loginPage().emailId(arg1);
    }

    @When("^Enter \"([^\"]*)\" as password$")
    public void enter_as_password(String arg1) throws Throwable {
        heatclinic.loginPage().passsword(arg1);
    }

    @When("^Click login$")
    public void click_login() throws Throwable {
        heatclinic.loginPage().clickLoginBtn();
    }

    @Then("^Invalid email or password message display$")
    public void invalid_email_or_password_message_display(){
        heatclinic.loginPage().error();

    }

    @Then("^Welcome message shows \"([^\"]*)\"$")
    public void welcome_message_shows(String arg1) throws Throwable {
        heatclinic.homePage().verifyMyAccountName(arg1);
    }
}
