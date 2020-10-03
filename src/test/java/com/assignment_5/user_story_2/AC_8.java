package com.assignment_5.user_story_2;

import com.utilities.WebDriverFactory;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AC_8   {

    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[.='Task']")).click();
    }

    @Test
    public void Ac_8 () throws InterruptedException {
         Thread.sleep( 1000);
         driver.findElement(By.linkText("Tasks")).click();
         driver.findElement(By.xpath("//a[@class='ui-btn-main']")).click();
         Thread.sleep( 1000);

         WebElement e = driver.findElement(By.xpath("//iframe[contains(@class,'side-panel-iframe')]"));
         driver.switchTo().frame(e);
         driver.findElement(By.xpath("//input[@data-bx-id='task-edit-title']")).sendKeys("Tasks for Employees");

         Thread.sleep( 1000);
         driver.findElement(By.xpath("//span[@data-target='accomplice']")).click();
         driver.findElement(By.xpath("//*[@id='bx-component-scope-bitrix_tasks_task_default_1-accomplice']/span[2]/a[2]")).click();
         List <WebElement> Participants =  driver.findElements(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));
         for (WebElement each : Participants) {
            each.click();
         }
         driver.findElement(By.xpath("//*[@id='BXSocNetLogDestination']/span")).click();

         driver.findElement(By.xpath("//span[@data-target='auditor']")).click();
         Thread.sleep( 1000);
         driver.findElement(By.xpath("//*[@id='bx-component-scope-bitrix_tasks_task_default_1-auditor']/span[2]/a[2]")).click();
         List <WebElement> Observers =  driver.findElements(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));
         for (WebElement each : Observers){
            each.click();
         }
         driver.findElement(By.xpath("//*[@id='BXSocNetLogDestination']/span")).click();

         // ADD Button
         driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-success']")).click();

         // First Varification
         driver.switchTo().defaultContent();
         Thread.sleep( 2000);
         String expectResult = "Tasks for Employees";
         List<WebElement> tableNames = driver.findElements(By.xpath("//tbody//tr//td[3]"));
         for (WebElement each : tableNames){
            if (each.getText().equals(expectResult)){
                Assert.assertEquals(each.getText(),expectResult);
            }
         }

         // Second Varification
         String expected = "Task has been created";
         String actual = driver.findElement(By.xpath("//div[@class='ui-notification-balloon-message']")).getText();
         Assert.assertEquals(actual,expected);
         }

    @AfterMethod
    public void afterMethod(){
      //driver.close();
    }

}
