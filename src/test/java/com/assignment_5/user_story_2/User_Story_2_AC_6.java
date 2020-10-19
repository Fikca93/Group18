package com.assignment_5.user_story_2;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_6 {
    WebDriver driver;
    @BeforeMethod
    public void setDriver() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        WebElement UsernameInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        UsernameInputBox.sendKeys("helpdesk18@cybertekschool.com");
        WebElement PasswordInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        PasswordInputBox.sendKeys("UserUser"+ Keys.ENTER);
    }
    @Test
    public void UserStory2_AC6() throws InterruptedException {
        WebElement TaskTab =driver.findElement(By.xpath("//span[.='Task']/span"));
        TaskTab.click();
        WebElement LinkIcon =driver.findElement(By.xpath("(//div[@id='post-buttons-bottom'])[3]//i[1]"));
        LinkIcon.click();
        WebElement LinkInput =driver.findElement(By.xpath("//table[@class='bxhtmled-dialog-tbl bxhtmled-dialog-tbl-collapsed']//td//input[@id='linklifefeed_task_form-href']"));
        LinkInput.sendKeys("https://login2.nextbasecrm.com/");
        WebElement SaveButton = driver.findElement(By.xpath("//input[@id='undefined']"));
        Thread.sleep(2000);
        SaveButton.click();
        WebElement iframe = driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));
        driver.switchTo().frame(iframe);
        WebElement URL =driver.findElement(By.xpath("//a[@href='https://login2.nextbasecrm.com/']"));
        Assert.assertTrue(URL.isDisplayed(),"URL is not displayed.Verification failed!");
        driver.switchTo().defaultContent();
        //WebElement SendButton =driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        //SendButton.click();
    }


    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
        //driver.close();
    }
}
