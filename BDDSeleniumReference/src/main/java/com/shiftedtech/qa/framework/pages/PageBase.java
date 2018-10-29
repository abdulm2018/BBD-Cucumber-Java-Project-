package com.shiftedtech.qa.framework.pages;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void highlight(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
            delayFor(200);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(2000);
        }
    }

    protected void delayFor(int timeinMili) {
        try {
            Thread.sleep(timeinMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        delayFor(3000);
    }

    protected void verifyTitle(String title) {
        assertEquals(title, driver.findElement(By.xpath("//title")).getText());
    }
}
