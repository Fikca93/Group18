package com.assignment_5.user_story_2;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_7_1 {

    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void us2_AC_7_1_Checklist_Add_CheckMark() throws InterruptedException{

        // before method
        String helpDeskUserName = "Helpdesk18@cybertekschool.com";
        String pass = "UserUser";

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys(helpDeskUserName);
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(pass);
        WebElement loginSubmitBox = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginSubmitBox.click();
        Thread.sleep(1000);
        //click on Activity Stream button
        WebElement buttonActivityStream = driver.findElement(By.xpath("//a[@title='Activity Stream']/span[1]"));
        buttonActivityStream.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // click on Task tab
        WebElement taskTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        taskTab.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


                // actual test
            // click on Check List
        driver.findElement(By.xpath("//span[@class='tasks-task-mpf-link']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // enter text1 in the field ToDo Things
        String expectedText1 = "Task_111";
        WebElement boxThings_ToDo = driver.findElement(By.xpath("//input[@class='js-id-checklist-is-form-title task-checklist-field-add']"));
        boxThings_ToDo.sendKeys(expectedText1);
            // check mark icon click
        WebElement checkMark = driver.findElement(By.xpath("//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']"));
        checkMark.click();

        String expectedText2 = "Task_222";
        boxThings_ToDo.sendKeys(expectedText2);
            // add button click is clicked
        WebElement addButton = driver.findElement(By.xpath("//span[@class= 'js-id-checklist-is-open-form task-dashed-link-inner']"));
        addButton.click();
            // find the entered text1 is displayed and get text from element
        WebElement text1 = driver.findElement(By.xpath("//div[@class='js-id-checklist-is-items js-id-checklist-items-ongoing tasks-checklist-dropzone']/div[2]/div/div/label/span[2]"));
        String actualText1 = text1.getText().trim();
        boolean text1_isDisplayed =text1.isDisplayed();
            //find the entered text2 is displayed and get text from element
        WebElement text2 = driver.findElement(By.xpath("//div[@class='js-id-checklist-is-items js-id-checklist-items-ongoing tasks-checklist-dropzone']/div[3]/div/div/label/span[2]"));
        String actualText2 = text2.getText().trim();
        boolean text2_isDisplayed =text2.isDisplayed();
            //verify Text1 and Text2 is displayed and
            // verify expected text1 and text2 same with expected text1 and text2
        Assert.assertTrue(actualText1.equals(expectedText1) && actualText2.equals(expectedText2)&&
                text1_isDisplayed && text2_isDisplayed);

   }


    @AfterMethod
    public void tearDown(){
       // driver.close();
    }



}
