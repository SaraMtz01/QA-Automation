package tests;
import config.ConfigManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContactUsPage;


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

        String expectedSuccessMessage = "Your message has been successfully sent to our team.";
        Assertions.assertTrue(contactUsPage.isTheMessageDisplayed(expectedSuccessMessage)); //original
    }


    @Test
    public void mailNotSent(){
        driver.get(ConfigManager.get("contactUs.url"));
        contactUsPage = new ContactUsPage(driver);
        scrollUtil.scrollingPage(0,400);

        contactUsPage.fillSubject("Webmaster");
        contactUsPage.fillEmail("");
        contactUsPage.fillOrderReference("14827JXJ374");
        contactUsPage.sendAMessage("This is my message for the team: Hello World");
        contactUsPage.pressButton();

        String expectedErrorMessage = "Invalid email address.";
        Assertions.assertTrue(contactUsPage.isTheMessageDisplayed(expectedErrorMessage));
    }

    @Test
    public void messageSentSuccessfullyWithoutReference(){
        driver.get(ConfigManager.get("contactUs.url"));
        contactUsPage = new ContactUsPage(driver);
        scrollUtil.scrollingPage(0,400);

        contactUsPage.sendAMessage("Hello");
        contactUsPage.fillOrderReference("");
        contactUsPage.fillEmail("myEmail@gmail.com");
        contactUsPage.fillSubject("Webmaster");
        contactUsPage.pressButton();

        String expectedSuccessMessage = "Your message has been successfully sent to our team.";
        Assertions.assertTrue(contactUsPage.isTheMessageDisplayed(expectedSuccessMessage));
    }

}
