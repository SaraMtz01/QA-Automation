package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    public WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(int duration, String unit){
        switch (unit){
            case "seconds":
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
                break;
            case "minutes":
                driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(duration));
                break;
            case "millis":
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(duration));
                break;
            case "nanos":
                driver.manage().timeouts().implicitlyWait(Duration.ofNanos(duration));
                break;
            case "days":
                driver.manage().timeouts().implicitlyWait(Duration.ofDays(duration));
                break;
            case "hours":
                driver.manage().timeouts().implicitlyWait(Duration.ofHours(duration));
                break;
        }
    }

    public <T> T explicitWaitSeconds(ExpectedCondition<T> condition, int seconds){ //el tipo T permite que el tipo de respuesta se adapte a un webelement o aun boolean
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(condition);
    }


}
