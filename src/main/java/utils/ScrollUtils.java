package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollUtils {
    private WebDriver driver;

    public ScrollUtils(WebDriver driver){
        this.driver = driver;
    }

    public void scrollingPage (int horizontal, int vertical){
        ((JavascriptExecutor) driver).executeScript("window.scroll("+horizontal +","+vertical+")");
    }

}
