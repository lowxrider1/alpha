package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YaProductPage {

    WebDriver driver;

    //XPath
    public static String productNameXPath = "//h1[@class='title title_size_28 title_bold_yes']";

    public YaProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName(){
        return driver.findElement(By.xpath(productNameXPath)).getText();
    }
}


