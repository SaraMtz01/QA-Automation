package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver){ //REcibirá un navegador
        this.driver = driver;
    }

    //Elementos
    private By usernameField = By.id("username");
    private By pwdField = By.id("password");
    private By buttonSubmitLogin = By.id("submit");

    //Acciones

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPwd(String pwd){
        driver.findElement(pwdField).sendKeys(pwd);
    }

    public void clickButton(){
        driver.findElement(buttonSubmitLogin).click();
    }

    public boolean isLoginSuccesful(){
        boolean succesfulLogin = driver.getTitle().contains("Logged In Successfully");
        return succesfulLogin;
    }



}
