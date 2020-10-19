package com.assignment_5.user_story_2;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_7_2 {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void us2_AC_7_2_Checklist_Add_separator() throws InterruptedException {


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
        // click on Task tab
        WebElement taskTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        taskTab.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //CheckList field
        driver.findElement(By.xpath("//span[@class='tasks-task-mpf-link']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // separator button
        WebElement separatorButton = driver.findElement(By.xpath("//span[@class= 'js-id-checklist-is-add-separator task-dashed-link-inner']"));
        separatorButton.click();
        // find separator line is displayed
        WebElement separatorLine = driver.findElement(By.xpath("//div[@id='bx-component-scope-lifefeed_task_form-checklist']/div[2]/div[2]"));
        // verify separator line is displayed
        Assert.assertTrue(separatorButton.isDisplayed());


    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }






}
