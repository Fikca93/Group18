package com.assignment_5.user_story_2;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_2 {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("https://login2.nextbasecrm.com/");


    }

    @Test
    public void link_attachment_verification() throws InterruptedException {

        // driver.get("https://login2.nextbasecrm.com/");

        String email = "helpdesk18@cybertekschool.com";
        String password = "UserUser";

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@class='login-btn'] ")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='lhe_button_editor_task-form-lifefeed_task_form']")).click();

        WebElement actualResult= driver.findElement(By.xpath("//div[@id='bx-html-editor-tlbr-idPostFormLHE_blogPostForm']"));
        Assert.assertTrue(!actualResult.isDisplayed());

        driver.manage().window().maximize();

    }

}




