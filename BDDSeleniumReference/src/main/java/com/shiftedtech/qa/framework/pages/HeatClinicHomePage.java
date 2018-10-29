 package com.shiftedtech.qa.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class HeatClinicHomePage extends PageBase{

    public HeatClinicHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Login")
    private WebElement loginLink;

    public void navigateToLoginPage(){
        loginLink.click();
        
    }

    public void verifyMyAccountName(String accountName){
        WebElement element = driver.findElement(By.cssSelector(".my-account"));
        highlight(element);
        String actualText = element.getText();
        assertEquals(accountName,actualText);
    }

    public void verifyHomepageTitle() {
        verifyTitle("");
    }
}
