package com.shiftedtech.qa.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HeatClinicLoginPage extends PageBase {

    @FindBy(how = How.NAME,using = "j_username")
    protected WebElement userIdTextbox;

    @FindBy(name = "j_password")
    protected WebElement passwordTextbox;

    @FindBy(css = ".login_button.big.red")
    protected WebElement loginButton;

    public HeatClinicLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void emailId(String userId){
        userIdTextbox.sendKeys(userId);
    }

    public void passsword(String password){
        passwordTextbox.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginButton.click();
    }

    public void login(String userId, String password){
        userIdTextbox.sendKeys(userId);
        passwordTextbox.sendKeys(password);
        loginButton.click();
    }

    public void error(){
        WebElement error = driver.findElement(By.cssSelector(".error>p>span"));
        Assert.assertTrue(error.isDisplayed());
    }

}
