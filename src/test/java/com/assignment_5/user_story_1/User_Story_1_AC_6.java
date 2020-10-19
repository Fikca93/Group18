package com.assignment_5.user_story_1;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_1_AC_6 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void  add_mention_icon(){
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passWord=driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("UserUser");
        WebElement logIn= driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();

        WebElement messageBotton= driver.findElement(By.xpath("//span[.='Message']"));
        messageBotton.click();

        WebElement icon= driver.findElement(By.id("bx-b-mention-blogPostForm"));
        icon.click();

        WebElement user1=driver.findElement(By.xpath("//div[.='hr77@cybertekschool.com']"));
        user1.click();

        WebElement icon2= driver.findElement(By.id("bx-b-mention-blogPostForm"));
        icon2.click();

        WebElement user2=driver.findElement(By.xpath("//div[.='helpdesk27@cybertekschool.com']"));
        user2.click();
    }
}
