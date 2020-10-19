package com.assignment_5.user_story_3;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_3_AC_10 {
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/?login=yes");

    }

    @Test
    public void MoreButton() throws InterruptedException {
        driver.get("https://login2.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();


        WebElement More = driver.findElement(By.xpath("//span[.='More']"));
        More.click();

        WebElement file = driver.findElement(By.xpath("//span[.='File']"));
        file.click();

        WebElement selectDocument = driver.findElement(By.xpath("//span[.='Select document from Bitrix24']"));
        selectDocument.click();
        Thread.sleep(2000);
        WebElement cancel = driver.findElement(By.xpath("//div[@class='popup-window-buttons']//span[2]"));
        cancel.click();

        // WebElement photo = driver.findElement(By.xpath("//div[@class='bx-file-dialog-content-wrap']//span[1]"));
        //  photo.click();

        //  driver.findElement(By.xpath("//span[.='Select document']")).click();

        //  WebElement send = driver.findElement(By.id("blog-submit-button-save"));
        //  send.click();
        /*
try {
    WebElement more2 = driver.findElement(By.xpath("//span[@class='feed-post-more-text'][1]"));
    more2.click();
    Thread.sleep(2000);
    WebElement delete = driver.findElement(By.xpath("//div[@class='menu-popup']//span[5]//span[2]"));
    delete.click();

    Alert alert = driver.switchTo().alert();
    alert.accept();
}catch (RuntimeException e){

}

         */

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='File']")).click();
        Thread.sleep(2000);
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();

        Thread.sleep(2000);

        //  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

//WebElement text  = driver.findElement(By.xpath("//body[@contenteditable='true']"));

//text.sendKeys("Test");



//WebElement saveButton  =driver.findElement(By.xpath("//div[@class='feed-buttons-block']//button[2]"));
//saveButton.click();

        WebElement AppreciationClick = driver.findElement(By.xpath("//span[.='Appreciation']"));
        AppreciationClick.click();
        Thread.sleep(2000);
        WebElement Announcement = driver.findElement(By.xpath("//span[.='Announcement']"));
        Announcement.click();
        Thread.sleep(1000);
        WebElement AnnouncementClick =  driver.findElement(By.xpath("//span[.='Announcement']"));
        AnnouncementClick.click();
        Thread.sleep(2000);
        WebElement workflow = driver.findElement(By.xpath("//span[.='Workflow']"));
        workflow.click();

//WebElement workflowClick = driver.findElement(By.xpath("//span[.='Workflow']"));
//workflowClick.click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
    //    driver.close();
    }

}
