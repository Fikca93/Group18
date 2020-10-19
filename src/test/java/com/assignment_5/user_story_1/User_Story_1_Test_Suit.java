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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class User_Story_1_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser"+ Keys.ENTER);
    }

    @Test
    public void User_Story_1_AC_2() throws InterruptedException {
        //BeforeMethod


        //Click the "Message"
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click();
        Thread.sleep(2000);

        //Click "To"
        driver.findElement(By.xpath("//div[@id='feed-add-post-destination-container']")).click();

        //Send email address as expectsResult
        WebElement toSendBox =driver.findElement(By.xpath("//input[@id='feed-add-post-destination-input']"));
        String expectsResult ="test123@gmail.com";
        toSendBox.sendKeys(Keys.BACK_SPACE+ expectsResult);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='feed-add-post-destination-container']")).click();

        //Verify test Pass or fail
        WebElement actuallyResults= driver.findElement(By.xpath("//span[@class='feed-add-post-destination-text']"));
        Assert.assertEquals(expectsResult,actuallyResults.getText());

    }

    @Test
    public void User_Story_1_AC_4() throws InterruptedException {

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

    @Test
    public void User_Story_1_AC_7(){
        //PRE-CONDITION


        WebElement messageButtonElement = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButtonElement.click();

        //TEST
        WebElement visualEditorButtonElement = driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm']"));
        visualEditorButtonElement.click();

        WebElement editorTextBarElement = driver.findElement(By.xpath("//div[@class='bxhtmled-toolbar-cnt']"));
        Assert.assertTrue(editorTextBarElement.isDisplayed(),"Editor-text bar is not displayed. Test FAILED!!!");
    }

    @Test
    public void User_Story_1_AC_8(){
        //PRE-CONDITION

        WebElement logInButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButtonElement.click();
        WebElement messageButtonElement = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButtonElement.click();

        //TEST
        WebElement topicButtonElement = driver.findElement(By.xpath("//span[@onclick='showPanelTitle_blogPostForm(this);']"));
        topicButtonElement.click();

        WebElement topicTextBoxElement = driver.findElement(By.xpath("//div[@id='blog-title']"));
        Assert.assertTrue(topicTextBoxElement.isDisplayed(),"Topic text box is not displayed. Test FAILED!!!");

    }

    @Test
    public void User_Story_1_AC_9() throws InterruptedException, AWTException {
        WebElement message = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        message.click();
        Thread.sleep(1000);


        WebElement recordButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-but-cnt feed-add-videomessage']"));
        recordButton.click();
        WebElement deviceAccess = driver.findElement(By.xpath("//div[@class='popup-window-buttons']//span[@class='popup-window-button popup-window-button-blue']"));
        deviceAccess.click();
//
        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        robot.delay(100);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        robot.delay(100);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        Thread.sleep(2000);


        WebElement errorText = driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']"));
        errorText.click();

      }
    @AfterMethod
    public void afterMethod() {
        driver.manage().window().maximize();
        driver.close();
    }

}
