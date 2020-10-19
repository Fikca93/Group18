package com.assignment_5.user_story_3;

import com.assignment_5.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class User_Story_3_AC_7 {
    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        WebElement UsernameInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        UsernameInputBox.sendKeys("helpdesk18@cybertekschool.com");
        WebElement PasswordInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        PasswordInputBox.sendKeys("UserUser"+ Keys.ENTER);
    }
    @Test // Users should be able to set reminders by entering the timing
    public void UserStory3_AC_7() throws InterruptedException {

        WebElement EventTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        EventTab.click();
        Thread.sleep(2000);

        WebElement SetReminderCheckBox = driver.findElement(By.id("event-remindercal_3Jcl"));
        System.out.println(SetReminderCheckBox.isSelected());

        Select SelectRemindType = new Select(driver.findElement(By.xpath("//select[@name='EVENT_REMIND_TYPE']")));


        List<WebElement> Reminders = new ArrayList<>();
        Reminders.addAll(SelectRemindType.getOptions());

        WebElement numberOfTime = driver.findElement(By.xpath("//input[@id='event-remind_countcal_3Jcl']"));
        numberOfTime.sendKeys(Keys.BACK_SPACE);
        numberOfTime.sendKeys(Keys.BACK_SPACE);
        Faker faker = new Faker();

        for (WebElement eachOption : Reminders) {

            System.out.println(eachOption.getText());

            switch (eachOption.getText()) {
                case "minutes":
                    int minutes =faker.number().numberBetween(1,59);
                    numberOfTime.sendKeys(minutes+"");
                    SelectRemindType.selectByVisibleText("hours");
                    Thread.sleep(2000);
                    break;

                case "hours":
                    numberOfTime.sendKeys(Keys.BACK_SPACE);
                    int hours =faker.number().numberBetween(1,12);
                    numberOfTime.sendKeys(hours+"");
                    Thread.sleep(2000);
                    SelectRemindType.selectByVisibleText("days");
                    Thread.sleep(2000);
                    break;
                case "days":
                    numberOfTime.sendKeys(Keys.BACK_SPACE);
                    int days =faker.number().numberBetween(1,7);
                    numberOfTime.sendKeys(days+"");
                    Thread.sleep(2000);
                    break;
            }
        }

        Assert.assertTrue(SelectRemindType.getFirstSelectedOption().isDisplayed());

    }
    @AfterMethod
    public void teardown(){
        driver.manage().window().maximize();
        //driver.quit();
    }
}