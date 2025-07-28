package tests;

import config.ConfigManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.testng.Assert;
//import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    //private WebDriver driver;
    //private DriverFactory driverFactory;
    protected LoginPage loginPage;


    @Test
    public void testSuccesfulLogin(){
        driver.get(ConfigManager.get("login.url"));  // Aquí defines la URL que quieras
        loginPage = new LoginPage(driver);

        loginPage.enterUsername("student");
        loginPage.enterPwd("Password123");
        loginPage.clickButton();
        Assertions.assertTrue(loginPage.isLoginSuccesful());
    }

}
