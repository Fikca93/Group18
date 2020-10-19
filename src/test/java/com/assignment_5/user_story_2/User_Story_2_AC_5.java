package com.assignment_5.user_story_2;


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

public class User_Story_2_AC_5 {
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

    @Test//US1_AC#5:  Users should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
    public void add_Mention() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='feed-add-post-content-tasks']//span[@title='Add mention']")).click();
        WebElement mention = driver.findElement(By.xpath("//span[@class='bx-finder-groupbox-content']//a[8]"));//a[i] -->can be more
        String expectResult = mention.getText();
        System.out.println("expectResult = " + expectResult);

        mention.click();
       // List<WebElement> ifram = driver.findElements(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(1);
        String actuallyResult = driver.findElement(By.xpath("//span[@class='bxhtmled-metion']")).getText();
        driver.switchTo().parentFrame();

        Assert.assertEquals(expectResult,actuallyResult);
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
        //driver.close();
    }

}
