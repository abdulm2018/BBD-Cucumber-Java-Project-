package com.shiftedtech.qa.steps;

import com.shiftedtech.qa.framework.pages.HeatClinicHomePage;
import com.shiftedtech.qa.framework.pages.HeatClinicLoginPage;
import org.openqa.selenium.WebDriver;


public class ApplicationBase {
    private WebDriver driver;
    private HeatClinicHomePage homePage = null;
    private HeatClinicLoginPage loginPage = null;

    public ApplicationBase(WebDriver driver) {
        this.driver = driver;
    }

    public HeatClinicHomePage homePage() {
        if(homePage == null){
            homePage = new HeatClinicHomePage(driver);
        }
        return homePage;
    }

    public HeatClinicLoginPage loginPage() {
        if(loginPage == null){
            loginPage = new HeatClinicLoginPage(driver);
        }
        return loginPage;
    }
}
