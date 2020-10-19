package com.assignment_5.user_story_1;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_1_AC_4 {
        WebDriver driver;

        @BeforeMethod
        public void setUpDriver() {
            driver = WebDriverFactory.getDriver("Chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        }

        @Test
        public void insertVideo() throws InterruptedException {

            driver.get("https://login2.nextbasecrm.com/");
            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
            driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser"+ Keys.ENTER);
            WebElement message = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
            message.click();
            Thread.sleep(1000);
            WebElement insertVideo = driver.findElement(By.xpath("//span[@title='Insert video']"));
            insertVideo.click();
            Thread.sleep(1000);
            WebElement videoSource = driver.findElement(By.xpath("//input[@placeholder='YouTube or Vimeo video URL']"));

            Thread.sleep(1000);
            videoSource.sendKeys("https://youtu.be/N-8QUdOdXls");

            Thread.sleep(3000);
            WebElement save = driver.findElement(By.xpath("//input[@value='Save']"));
            Thread.sleep(3000);
            save.click();
            WebElement messagesend = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
            Thread.sleep(3000);
            messagesend.click();
        }

        @AfterMethod
        public void closeWindow() {
            //   driver.close();
        }
}




