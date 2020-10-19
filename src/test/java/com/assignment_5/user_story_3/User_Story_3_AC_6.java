package com.assignment_5.user_story_3;




import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_3_AC_6 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void add_mention_icon() {
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("UserUser");
        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();

        WebElement eventTab =driver.findElement(By.xpath("//span[.='Event']"));
        eventTab.click();

        WebElement startDate =driver.findElement(By.id("feed-cal-event-fromcal_3Jcl"));
        startDate.click();

        WebElement selectStartDate=driver.findElement(By.xpath("//a[.='12']"));
        selectStartDate.click();

        WebElement startTime=driver.findElement(By.xpath("//input[@name='TIME_FROM_']"));
        startTime.click();

        WebElement setBotton=driver.findElement(By.xpath("//input[@value='Set Time']"));
        setBotton.click();

        WebElement endDate=driver.findElement(By.id("feed-cal-event-tocal_3Jcl"));
        endDate.click();

        WebElement selectEndDate=driver.findElement(By.xpath("//a[.='16']"));
        selectEndDate.click();

        WebElement endTime=driver.findElement(By.xpath("//input[@name='TIME_TO_']"));
        endTime.click();

        WebElement setBotton2= driver.findElement(By.xpath("//input[@value='Set Time']"));
        setBotton2.click();

        WebElement timeZone= driver.findElement(By.id("feed-cal-tz-switchcal_3Jcl"));
        timeZone.click();





    }
}
