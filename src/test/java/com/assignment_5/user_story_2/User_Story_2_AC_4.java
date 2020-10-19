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


            WebElement task = driver.findElement(By.xpath("//div[@id='feed-add-post-form-tab']//span[@id='feed-add-post-form-tab-tasks']"));
            task.click();
            Thread.sleep(3000);

           WebElement Quotetext = driver.findElement(By.xpath("//span[@id='bx-b-quote-task-form-lifefeed_task_form']"));
           Thread.sleep(3000);
            Quotetext.click();
   //     WebElement blockquote =  driver.findElement(By.xpath("//blockquote[@class='bxhtmled-quote']"));
        //   blockquote.sendKeys("If everyone is moving forward together, then success takes care of itself.");
        //    blockquote.submit();
        //blockquote[@class='bxhtmled-quote']

        Assert.assertTrue(Quotetext.isDisplayed(),"Text is not dispalyed verification failed!!!");


        //   WebElement Quote = driver.findElement(By.xpath("//body[@contenteditable='true']/blockquote"));
       //   Quote.click();

         //   WebElement iframe = driver.findElement(By.id("bx-editor-iframe"));
           // driver.switchTo().frame(iframe);

    //      WebElement iframe = driver.findElement(By.xpath("bx-editor-iframe"));
      //      driver.switchTo().frame(iframe);
        //    driver.switchTo().frame(2);

    }

    @AfterMethod
    public void closewindow(){

      driver.close();
    }



}
