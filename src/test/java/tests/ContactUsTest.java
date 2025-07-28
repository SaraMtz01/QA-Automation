package tests;

import config.ConfigManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ContactUsPage;
import utils.ScrollUtils;
import utils.WaitUtils;

public class ContactUsTest extends BaseTest{
    protected ContactUsPage contactUsPage;

    @Test
    public void messageSendSuccesfully(){
        driver.get(ConfigManager.get("contactUs.url"));
        contactUsPage = new ContactUsPage(driver);
        scrollUtil.scrollingPage(0,400);

        contactUsPage.fillSubject("Webmaster");
        contactUsPage.fillEmail("myEmail1@gmail.com");
        contactUsPage.fillOrderReference("14827JXJ374");
        contactUsPage.sendAMessage("This is my message for the team: Hello World");
        contactUsPage.pressButton();

        String expectedSuccesMessage = "Your message has been successfully sent to our team.";
        // Assertions.assertTrue(contactUsPage.isTheMessageDisplayed(expectedSuccesMessage)); //original
        Assertions.assertTrue(contactUsPage.isTheMessageDisplayed2(expectedSuccesMessage)); //original

    }

    /*
    @Test
    public void mailNotSended(){
        driver.get(ConfigManager.get("contactUs.url"));
        contactUsPage = new ContactUsPage(driver);
        scrollUtil.scrollingPage(0,400);

        contactUsPage.fillSubject("Webmaster");
        contactUsPage.fillEmail("");
        contactUsPage.fillOrderReference("14827JXJ374");
        contactUsPage.sendAMessage("This is my message for the team: Hello World");
        contactUsPage.pressButton();

        String expectedErrorMessage = "Your message has been successfully sent to our team.";
        Assertions.assertTrue(contactUsPage.isTheMessageDisplayed(expectedErrorMessage));


    }

     */


}
