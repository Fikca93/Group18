package com.assignment_5.user_story_3;


import com.assignment_5.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class User_Story_3_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void User_Story_3_AC_2(){
        //PRE-CONDITION
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement usernameBoxElement = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBoxElement.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passwordBoxElement = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBoxElement.sendKeys("UserUser");
        WebElement logInButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButtonElement.click();
        WebElement messageButtonElement = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButtonElement.click();

        //TEST
        WebElement linkButton = driver.findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']"));
        linkButton.click();


        // 1ST ASSERTION CHECKING IF LINK BUTTON BRINGS UP THE LINK BOX
        WebElement linkBox = driver.findElement(By.xpath("//div[@class='bx-core-window bx-core-adm-dialog']"));
        Assert.assertTrue(linkBox.isDisplayed(),"Link box is not displayed. Test FAILED!!!");

        // 2ND ASSERTION VERIFYING IF AFTER PROVIDING THE INFO AND CLICKING SAVE LINK IS POSTED INTO MESSAGE BOX
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text']"));
        inputTextBox.sendKeys("Gherkin Language Best Practices");

        WebElement inputLinkBox = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']"));
        inputLinkBox.sendKeys("https://www.youtube.com/watch?v=nrggIRWK6qo");

        WebElement saveButton = driver.findElement(By.xpath("//input[@class='adm-btn-save']"));
        saveButton.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement textLinkElement = driver.findElement(By.xpath("//a[.='Gherkin Language Best Practices']"));
        Assert.assertTrue(textLinkElement.isDisplayed(),"Text link is not displayed. Test FAILED!!!");

        // 3RD ASSERTION VERIFYING THAT AFTER CLICKING SEND BUTTON LINK HAS BEEN POSTED ON ACTIVITY STREAM
        driver.switchTo().defaultContent();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        WebElement postOnPage = driver.findElement(By.xpath("//div[.='Gherkin Language Best Practices']"));
        Assert.assertTrue(postOnPage.isDisplayed(),"Link is not displayed on the page. Test FAILED!!!");

        //4TH ASSERTION AFTER CLICKING USER SHOULD BE REDIRECTED TO THE POSTED LINK
        postOnPage.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachHandle : windowHandles) {
            if (driver.switchTo().window(eachHandle).getTitle().equals("Gherkin Best Practices - YouTube")){
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        String expectedTitle = "Gherkin Best Practices - YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"Actual title doesn't match the expected. Test FAILED!!!");

        // NOT PART OF THE TEST, JUST DELETING THE POST THAT HAS BEEN POSTED
        // THIS STEP IS NEEDED IN ORDER TO RUN THE TEST AGAIN, BECAUSE SAME POST CANNOT BE DONE MORE THAN ONCE

        for (String eachHandle : windowHandles) {
            if (driver.switchTo().window(eachHandle).getTitle().equals("(3) Portal")){
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        WebElement moreDropdownMenu = driver.findElement(By.xpath("//a[contains(@id,'feed-post-menuanchor')]"));
        moreDropdownMenu.click();
        WebElement deleteButtonFromMoreDropdown = driver.findElement(By.xpath("//div[@class='menu-popup-items']//span[5]"));
        deleteButtonFromMoreDropdown.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void us3_AC4_quote() throws InterruptedException {

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
        // click on Event tab
        WebElement eventTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        eventTab.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // actual test
        //click on quote icon
        WebElement quoteIcon = driver.findElement(By.xpath("//span[@id='bx-b-quote-blogPostForm_calendar']/span"));
        quoteIcon.click();
        // switch to iframe
        WebDriver iframe = driver.switchTo().frame(1);
        //find element in the text message box
        WebElement quote = driver.findElement(By.xpath("//blockquote[@class='bxhtmled-quote']"));
        boolean actualResult = quote.isDisplayed();
        // verify element is displayed
        Assert.assertTrue(actualResult);
    }

    @Test
    public void UserStory3_AC5() throws InterruptedException {
        //@BeforeMethod
        WebElement UsernameInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        UsernameInputBox.sendKeys("helpdesk18@cybertekschool.com");
        WebElement PasswordInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        PasswordInputBox.sendKeys("UserUser"+ Keys.ENTER);

        WebElement EventTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        EventTab.click();
        Thread.sleep(2000);
        WebElement VisualEditorIcon = driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm_calendar']"));
        VisualEditorIcon.click();
        Thread.sleep(2000);
        // WebElement iframe = driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));
        // driver.switchTo().frame(iframe);
        WebElement TextBarEditor=driver.findElement(By.xpath("(//div[@class='bxhtmled-toolbar'])[2]"));
        Assert.assertTrue(TextBarEditor.isDisplayed(),TextBarEditor+" is not displayed!!");
    }

    @Test // Users should be able to set reminders by entering the timing

    public void UserStory3_AC_7() throws InterruptedException {
        //@BeforeMethod
        WebElement UsernameInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        UsernameInputBox.sendKeys("helpdesk18@cybertekschool.com");
        WebElement PasswordInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        PasswordInputBox.sendKeys("UserUser"+ Keys.ENTER);

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
    public void afterMethod(){
        driver.manage().window().maximize();
        driver.close();
    }
}
