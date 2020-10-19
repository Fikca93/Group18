package com.assignment_5.user_story_3;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_3_AC_4 {


    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void us3_AC4_quote() throws InterruptedException {

        // before method
        String helpDeskUserName = "Helpdesk18@cybertekschool.com";
        String pass = "UserUser";

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys(helpDeskUserName);
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(pass);
        WebElement loginSubmitBox = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginSubmitBox.click();
        Thread.sleep(1000);
        //click on Activity Stream button
        WebElement buttonActivityStream = driver.findElement(By.xpath("//a[@title='Activity Stream']/span[1]"));
        buttonActivityStream.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // click on Event tab
        WebElement eventTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        eventTab.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // actual test
        //click on quote icon
        WebElement quoteIcon = driver.findElement(By.xpath("//span[@id='bx-b-quote-blogPostForm_calendar']/span"));
        quoteIcon.click();
        // switch to iframe
        WebDriver iframe = driver.switchTo().frame(1);
        //find element in the text message box
        WebElement quote = driver.findElement(By.xpath("//blockquote[@class='bxhtmled-quote']"));
        boolean actualResult = quote.isDisplayed();
        // verify element is displayed
        Assert.assertTrue(actualResult);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
