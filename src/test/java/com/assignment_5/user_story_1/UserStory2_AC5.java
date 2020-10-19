package com.assignment_5.user_story_1;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory2_AC5 {
    WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    @Test
    public void user_story_2_ac_5() throws InterruptedException {
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser"+ Keys.ENTER);
        Thread.sleep(3000);
        WebElement Task = driver.findElement(By.xpath("//span[.='Task']"));
        Task.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='feed-add-post-content-tasks']//span[@title='Quote text']")).click();
        Thread.sleep(3000);
    //    WebElement quote = driver.findElement(By.xpath(""));
        WebElement quote = driver.findElement(By.xpath("//div[@id='bx-html-editor-area-cnt-lifefeed_task_form']"));//div[@class='bxhtmled-area-cnt']
        String expectresult = quote.getText();
        System.out.println("expectedResult = " +expectresult);

        quote.click();
    //    List<WebElement>


}}
//body[@contenteditable='true']//blockquote[@class='bxhtmled-quote']
