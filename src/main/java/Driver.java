import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public static WebDriver driver;

    Driver(){}

    public static WebDriver getWebDriver(){
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}
