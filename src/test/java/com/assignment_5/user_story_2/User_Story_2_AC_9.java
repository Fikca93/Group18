package com.assignment_5.user_story_2;


import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_2_AC_9 {
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/?login=yes");

    }
    //Users can add Deadline, Time Planning by using date pickers.

    @Test
    public void TimePlanning() throws InterruptedException {
        driver.get("https://login2.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        WebElement event = driver.findElement(By.xpath("//span[.='Event']"));
        event.click();

        WebElement eventName = driver.findElement(By.xpath("//input[@placeholder='Event name']"));
        eventName.sendKeys("Sprint Date");
        Thread.sleep(2000);
        WebElement startDate = driver.findElement(By.xpath("//input[@id='feed-cal-event-fromcal_3Jcl']"));
        startDate.click();
        WebElement SeptemberDay = driver.findElement(By.xpath("//a[.='25']"));
        SeptemberDay.click();

        driver.findElement(By.id("feed_cal_event_from_timecal_3Jcl")).click();

        WebElement deleteHour = driver.findElement(By.xpath("//input[@title='Hours']"));
        deleteHour.click();
        deleteHour.sendKeys(Keys.BACK_SPACE);


        Thread.sleep(2000);

        WebElement hour = driver.findElement(By.xpath("//td[@title='Increase (Up)']"));

        for (int i = 0; i<=12; i++){

            hour.click();

            if (i==5){
                break;
            }
        }
        WebElement deleteMinute = driver.findElement(By.xpath("//input[@title='Minutes']"));
        deleteMinute.click();
        deleteMinute.sendKeys(Keys.CLEAR);
        Thread.sleep(3000);
        WebElement minute = driver.findElement(By.xpath("//div[@id='feed_cal_event_from_timecal_3Jcl_div']//div[2]//table[2]//td[2]"));

        for (int i = 0; i<=12; i++) {

            minute.click();

            if (i == 11) {
                break;
            }
        }
        WebElement pm_am = driver.findElement(By.className("bxc-am-pm"));
        pm_am.click();
        Thread.sleep(2000);
        WebElement setTime = driver.findElement(By.xpath("//input[@value='Set Time']"));
        setTime.click();


        WebElement EndDate = driver.findElement(By.id("feed-cal-event-tocal_3Jcl"));
        EndDate.click();

        WebElement months = driver.findElement(By.className("bx-calendar-top-month"));
        months.click();
        Thread.sleep(1000);
        WebElement October = driver.findElement(By.xpath("//div[@class='bx-calendar-month-content']//span[10]"));
        October.click();
        Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("//div[@class='bx-calendar-layer']//div//a[5]"));
        day.click();

        driver.findElement(By.id("feed_cal_event_to_timecal_3Jcl")).click();

/*
try {


    WebElement deleteHour1 = driver.findElement(By.xpath("//table/tbody/tr/td/input"));
    deleteHour1.click();
    deleteHour1.sendKeys(Keys.BACK_SPACE);
   // Thread.sleep(2000);


    WebElement setTime2 = driver.findElement(By.xpath("//input[@value='Set Time']"));
    setTime.click();

    WebElement close = driver.findElement(By.xpath("//img[@title='Close'][1]"));
    close.click();


}catch (RuntimeException e){


}

 */

        WebElement eventRemainder = driver.findElement(By.id("event-remindercal_3Jcl"));
        Assert.assertTrue(eventRemainder.isSelected(),"Event Remainder is not selected");

        WebElement setRemainder = driver.findElement(By.id("event-remind_countcal_3Jcl"));
        setRemainder.sendKeys(Keys.BACK_SPACE+""+Keys.BACK_SPACE);
        setRemainder.sendKeys("1"+Keys.ENTER);

        Select remainder = new Select(driver.findElement(By.id("event-remind_typecal_3Jcl")));
        remainder.selectByVisibleText("hours");


        WebElement eventLocation = driver.findElement(By.name("EVENT_LOCATION"));
        eventLocation.click();
        eventLocation.sendKeys("East Meeting Room");
        eventLocation.click();

        WebElement addPerson = driver.findElement(By.id("feed-event-dest-cont"));
        addPerson.click();

        WebElement toAllEmployee = driver.findElement(By.className("bx-finder-box-item-t7-name"));
        toAllEmployee.click();

        WebElement closeIcon = driver.findElement(By.xpath("//span[@class='popup-window-close-icon']"));
        closeIcon.click();

        WebElement submit = driver.findElement(By.id("blog-submit-button-save"));
        submit.click();
        Thread.sleep(2000);

        WebElement more2 = driver.findElement(By.xpath("//span[@class='feed-post-more-text'][1]"));
        more2.click();

        WebElement delete = driver.findElement(By.xpath("//span[@class='menu-popup-item menu-popup-no-icon '][3]//span[2]"));
        delete.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }



}
