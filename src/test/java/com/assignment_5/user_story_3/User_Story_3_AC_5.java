package com.assignment_5.user_story_3;

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

public class User_Story_3_AC_5 {
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
    public void UserStory3_AC5() throws InterruptedException {
        WebElement EventTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        EventTab.click();
        Thread.sleep(2000);
        WebElement VisualEditorIcon = driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm_calendar']"));
        VisualEditorIcon.click();
        // WebElement iframe = driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));
        // driver.switchTo().frame(iframe);
        WebElement TextBarEditor=driver.findElement(By.xpath("(//div[@class='bxhtmled-toolbar'])[2]"));
        Assert.assertTrue(TextBarEditor.isDisplayed(),TextBarEditor+" is not displayed!!");
    }
    @AfterMethod
    public void teardown(){
        driver.manage().window().maximize();
        //driver.quit();
    }
}


