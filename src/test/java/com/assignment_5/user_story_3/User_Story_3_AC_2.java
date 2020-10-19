package com.assignment_5.user_story_3;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class User_Story_3_AC_2 {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");
        //TODO: AFTER THIS LINE ADD TO TEST WHEN TRANSFERING TO TEST SUIT
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement usernameBoxElement = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBoxElement.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passwordBoxElement = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBoxElement.sendKeys("UserUser");
        WebElement logInButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButtonElement.click();
        WebElement messageButtonElement = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButtonElement.click();


    }

    @Test //User Story#3 AC#2  User should be able to attach links by clicking on the link icon.
    public void linkAttaching(){

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

    @AfterMethod
    public void afterMethod(){
        driver.manage().window().maximize();
    }







}
