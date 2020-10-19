package com.assignment_5.user_story_1;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_1_AC_1 {
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/?login=yes");

    }

    @Test//1.	Users should be able to click on the upload files icon to upload files and images from local disks.
    public void fileUpload() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        WebElement Message = driver.findElement(By.xpath("//span[.='Message']"));
        Message.click();
        Thread.sleep(1000);

        WebElement uploadFile = driver.findElement(By.id("bx-b-uploadfile-blogPostForm"));
        uploadFile.click();

        WebElement uploadFileAndImages = driver.findElement(By.xpath("//div[@class='diskuf-uploader']"));
        //uploadFileAndImages.sendKeys("C:Users\\Resho\\Desktop\\Automation Task Photo\\Task5.4.jpg");
        uploadFileAndImages.click();
        Thread.sleep(3000);
        driver.quit();

    }
    //Users can add Deadline, Time Planning by using date pickers.

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




}
