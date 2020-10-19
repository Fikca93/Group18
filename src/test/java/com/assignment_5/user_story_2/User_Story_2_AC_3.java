package com.assignment_5.user_story_2;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_3 {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[.='Task']")).click();
    }

    @Test//Users should be able to click on the upload files icon to upload files and pictures from select documents from bitrix24, and create files to upload.
    public void US2AC3() throws InterruptedException {

        //Click "Upload file" icon
        driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-task-form-lifefeed_task_form']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys("C:\\Users\\a9329\\Desktop\\myfile.txt");

        WebElement actlyResul = driver.findElement(By.xpath("//span[.='myfile.txt']"));

        Assert.assertTrue(actlyResul.isDisplayed());

    }
}
