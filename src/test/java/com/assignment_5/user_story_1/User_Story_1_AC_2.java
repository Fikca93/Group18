package com.assignment_5.user_story_1;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//2. User should be able to add users from selecting contact from Email user.
public class User_Story_1_AC_2 {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");

    }

    @Test
    public void US1_AC2() throws InterruptedException {
        //BeforeMethod
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        //Click the "Message"
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click();
        Thread.sleep(2000);

        //Click "To"
        driver.findElement(By.xpath("//div[@id='feed-add-post-destination-container']")).click();

        //delete exist text or emall
        WebElement toSendBox =driver.findElement(By.xpath("//input[@id='feed-add-post-destination-input']"));
        toSendBox.sendKeys(Keys.BACK_SPACE);
        //Click one of the email in the list
        WebElement expectsResult = driver.findElement(By.xpath("//span[@class='bx-finder-groupbox false']//a[3]"));//a[x]: x>=1, x<=12
        expectsResult.click();

        /*
        //Send email address as expectsResult
        WebElement toSendBox =driver.findElement(By.xpath("//input[@id='feed-add-post-destination-input']"));
        String expectsResult ="test123@gmail.com";
        toSendBox.sendKeys(Keys.BACK_SPACE+ expectsResult);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='feed-add-post-destination-container']")).click();
         */

        //Verify test Pass or fail
        WebElement actuallyResults= driver.findElement(By.xpath("//span[@class='feed-add-post-destination-text']"));
        Assert.assertEquals(expectsResult.getText(),actuallyResults.getText());

    }

}
