package com.assignment_5.user_story_1;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_1_AC_3 {
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

        driver.get("https://login2.nextbasecrm.com/");

        String email= "helpdesk18@cybertekschool.com";
        String password="UserUser";

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@class='login-btn'] ")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message'] ")).click();
        driver.findElement(By.xpath("//span[@title='Link'] ")).click();

        String expectedText="Cybertek School";//expected
        String email2="https://www.cybertekschool.com/";

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text'] ")).sendKeys(expectedText);
        driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href'] ")).sendKeys(email2);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='undefined'] ")).click();

        Thread.sleep(3000);



        driver.switchTo().frame(0);
        String actuallyResult = driver.findElement(By.xpath("//a[.='"+expectedText+"']")).getText();
        driver.switchTo().parentFrame();

        Assert.assertEquals(expectedText,actuallyResult);



    }


    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
        driver.close();







    }
}
