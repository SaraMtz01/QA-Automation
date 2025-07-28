package tests;

import config.ConfigManager;
import drivers.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ScrollUtils;
import utils.WaitUtils;

public class BaseTest {
    protected WebDriver driver;
    protected WaitUtils wait;
    protected ScrollUtils scrollUtil;

    @BeforeEach
    public void setup(){

        driver = DriverManager.getDriver();
        driver.manage().window().maximize();

        wait= new WaitUtils(driver); // Crea una instancia de clase de WaitUtils y configura un implicitWait de 10 segundos
        wait.implicitWait(10, "seconds"); // aplica el implicit wait

        scrollUtil= new ScrollUtils(driver);
    }

    @AfterEach
    public void tearDown(){
        DriverManager.quitDriver();
    }
}

