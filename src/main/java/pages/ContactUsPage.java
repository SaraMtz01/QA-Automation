package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ContactUsPage {

    //Constructor
    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    private WebElement selectField;
    //private By selectField = By.id("id_contact");

    @FindBy(css = "input#email")
    private WebElement emailField;
    //private By emailField = By.cssSelector("input#email");

    @FindBy(xpath = "//*[@id='id_order']")
    private WebElement orderField;
    //private By orderField = By.xpath("//*[@id='id_order']");

    @FindBy(xpath = "//*[contains(@id,'uniform-fileUpload')" )
    private WebElement fileField;
    //private By fileField = By.xpath("//*[contains(@id,'uniform-fileUpload')]");

    @FindBy(css = "#message")
    private WebElement messageField;
    //private By messageField = By.cssSelector("#message");

    @FindBy(xpath = "//*[contains(text(),'Send')]")
    private WebElement buttonSend;
    //private By buttonSend = By.xpath("//*[contains(text(),'Send')]");

    @FindBy(css = ".alert" )
    private WebElement alertMessage;
    //private By alertMessage = By.cssSelector(".alert");

    @FindBy(css = ".alert p")
    private WebElement alertError;
    //private By alertError = By.cssSelector(".alert p");

    @FindBy(css = ".alert li")
    private WebElement typeOfError;
    //public String expectedMessageError = "error";



    public void fillSubject(String subject){
        Select selectSubject = new Select(selectField);
        selectSubject.selectByVisibleText(subject);
    }

    public void fillEmail(String email){
        emailField.sendKeys(email);
        //driver.findElement(emailField).sendKeys(email);
    }

    public void fillOrderReference (String orderReference){
        orderField.sendKeys(orderReference);
    }

    public void sendAMessage (String message){
        messageField.sendKeys(message);
    }

    public void pressButton(){
        buttonSend.click();
    }

    //Original
    public boolean isTheMessageDisplayed(String expectedMessage){
        String alertText = alertMessage.getText();
        return alertText.contains(expectedMessage);
    }

}
