package com.assignment_5.user_story_1;

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

public class User_Story_2_AC_4 {
    WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @Test
    public void user_story_2_ac_4() throws InterruptedException {

            driver.get("https://login2.nextbasecrm.com/");
            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
            driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser"+ Keys.ENTER);
            Thread.sleep(3000);

        WebElement taskButton = driver.findElement(By.xpath("//div[@class='feed-add-post-form-variants']//span[@id='feed-add-post-form-tab-tasks']"));
        taskButton.click();
        Thread.sleep(3000);
        WebElement quotetext = driver.findElement(By.xpath("//div[@class='feed-add-post-form-but-wrap']//span[@id='bx-b-mention-task-form-lifefeed_task_form']"));
        quotetext.click();

        Assert.assertTrue(quotetext.isDisplayed(),"Text is not dispalyed verification failed!!!");


     
    }

    @AfterMethod
    public void closewindow(){

      driver.close();
    }



}
