package com.assignment_5.user_story_2;

import com.assignment_5.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class User_Story_2_Test_Suit {
    WebDriver driver;

    @BeforeMethod
    public void set_Up(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");


    }

    @Test//US2_AC#1
    public void User_Story_2_AC_1_High_Priority() throws InterruptedException{
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

        //actual test

        //click on High priority check box
        WebElement checkBox_High_Priority = driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']"));
        checkBox_High_Priority.click();

        boolean actual = driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']")).isSelected();
        //boolean expected = true;

        Assert.assertTrue(actual);


    }

    @Test//link_attachment_verification
    public void User_Story_2_AC_2() throws InterruptedException {

        // driver.get("https://login2.nextbasecrm.com/");

        String email = "helpdesk18@cybertekschool.com";
        String password = "UserUser";

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@class='login-btn'] ")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='lhe_button_editor_task-form-lifefeed_task_form']")).click();

        WebElement actualResult= driver.findElement(By.xpath("//div[@id='bx-html-editor-tlbr-idPostFormLHE_blogPostForm']"));
        Assert.assertTrue(!actualResult.isDisplayed());

        driver.manage().window().maximize();

    }

    @Test
    public void User_Story_2_AC_3() throws InterruptedException {
        //BeforeMEthod
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[.='Task']")).click();
        Thread.sleep(2000);

        //Click "Upload file" icon
        driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-task-form-lifefeed_task_form']")).click();
        Thread.sleep(3000);

        String filePath="C:\\Users\\a9329\\Desktop\\myfile.txt";
        try {
            driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys(filePath);
        }catch (InvalidArgumentException e){
            System.out.println("plz check your file path make suer you have file in that path");
        }

        WebElement actlyResul = driver.findElement(By.xpath("//span[.='myfile.txt']"));
        Assert.assertTrue(actlyResul.isDisplayed());

    }

    @Test
    public void User_Story_2_AC_4() throws InterruptedException {
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

        WebElement taskButton = driver.findElement(By.xpath("//div[@class='feed-add-post-form-variants']//span[@id='feed-add-post-form-tab-tasks']"));
        taskButton.click();
        Thread.sleep(3000);
        WebElement quotetext = driver.findElement(By.xpath("//div[@class='feed-add-post-form-but-wrap']//span[@id='bx-b-mention-task-form-lifefeed_task_form']"));
        quotetext.click();




        Assert.assertTrue(quotetext.isDisplayed(),"Text is not dispalyed verification failed!!!");

    }

    @Test//US1_AC#5:  Users should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
    public void User_Story_2_AC_5() throws InterruptedException {

        //beforeMethod
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        //US#2 Only:
        driver.findElement(By.xpath("//span[.='Task']")).click();
        Thread.sleep(3000);

        //AC#5 Add mention icon and select contacts from the lists provided in dropdown
        driver.findElement(By.xpath("//div[@id='feed-add-post-content-tasks']//span[@title='Add mention']")).click();
        Thread.sleep(2000);
        WebElement mention = driver.findElement(By.xpath("//span[@class='bx-finder-groupbox-content']//a[8]"));//a[i] -->can be more
        String expectResult = mention.getText();
        System.out.println("expectResult = " + expectResult);

        mention.click();
        List<WebElement> ifram = driver.findElements(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(1);
        String actuallyResult = driver.findElement(By.xpath("//span[@class='bxhtmled-metion']")).getText();
        driver.switchTo().parentFrame();

        Assert.assertEquals(expectResult,actuallyResult);
    }

    @Test
    public void UserStory2_AC6() throws InterruptedException {
        //@BeforeMethod
        WebElement UsernameInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        UsernameInputBox.sendKeys("helpdesk18@cybertekschool.com");
        WebElement PasswordInputBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        PasswordInputBox.sendKeys("UserUser"+ Keys.ENTER);


        WebElement TaskTab =driver.findElement(By.xpath("//span[.='Task']/span"));
        TaskTab.click();
        Thread.sleep(2000);

        WebElement LinkIcon =driver.findElement(By.xpath("(//div[@id='post-buttons-bottom'])[3]//i[1]"));
        LinkIcon.click();

        WebElement LinkInput =driver.findElement(By.xpath("//table[@class='bxhtmled-dialog-tbl bxhtmled-dialog-tbl-collapsed']//td//input[@id='linklifefeed_task_form-href']"));
        LinkInput.sendKeys("https://login2.nextbasecrm.com/");

        WebElement SaveButton = driver.findElement(By.xpath("//input[@id='undefined']"));
        Thread.sleep(2000);
        SaveButton.click();

        WebElement iframe = driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));
        driver.switchTo().frame(iframe);

        WebElement URL =driver.findElement(By.xpath("//a[@href='https://login2.nextbasecrm.com/']"));
        Assert.assertTrue(URL.isDisplayed(),"URL is not displayed.Verification failed!");
        driver.switchTo().defaultContent();
        //WebElement SendButton =driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        //SendButton.click();
    }

    @Test//US2_AC#7_1
    public void User_Story_2_AC_7_1_Checklist_Add_CheckMark() throws InterruptedException{

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

    @Test// US2_AC#7_2
    public void User_Story_2_AC_7_2_Checklist_Add_separator() throws InterruptedException {


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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //CheckList field
        driver.findElement(By.xpath("//span[@class='tasks-task-mpf-link']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // separator button
        WebElement separatorButton = driver.findElement(By.xpath("//span[@class= 'js-id-checklist-is-add-separator task-dashed-link-inner']"));
        separatorButton.click();
        // find separator line is displayed
        WebElement separatorLine = driver.findElement(By.xpath("//div[@id='bx-component-scope-lifefeed_task_form-checklist']/div[2]/div[2]"));
        // verify separator line is displayed
        Assert.assertTrue(separatorButton.isDisplayed());


    }

    @Test
    public void User_Story_2_AC_9() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        WebElement event = driver.findElement(By.xpath("//span[.='Event']"));
        event.click();
        Thread.sleep(2000);
        WebElement eventName = driver.findElement(By.xpath("//input[@name='EVENT_NAME']"));
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

    @Test//US1_AC#10:  Users should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
    public void User_Story_2_AC_10() throws InterruptedException {
        //beforeMethod
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk18@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        //US#2 Only:
        driver.findElement(By.xpath("//span[.='Task']")).click();
        Thread.sleep(3000);

        //AC#10
        //Click "More"
        driver.findElement(By.xpath("//div[@data-bx-id='task-edit-additional-header']")).click();

        WebElement isDisplay = driver.findElement(By.xpath("//div[@data-bx-id='task-edit-unchosen-blocks']"));
        System.out.println("isDisplay = " + isDisplay.isDisplayed());
        Assert.assertTrue(isDisplay.isDisplayed(),"its not visible");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
