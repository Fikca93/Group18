package com.assignment_5.user_story_1;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class User_Story_1_AC_9{
 WebDriver driver;
 @BeforeMethod
 public void set_Up() throws InterruptedException, AWTException {
  driver = WebDriverFactory.getDriver("chrome");
  driver.get("https://login2.nextbasecrm.com/");
  driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
  driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser" + Keys.ENTER);
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
 }