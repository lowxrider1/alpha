package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YaResultByFilterPage {
    WebDriver driver;
    private String productName;

    //XPath
    public static String firstResultXPath = "(//div[@class='n-snippet-cell2__title'])[1]";
    public static String firstResultProductNameXPath = "(//div[@class='n-snippet-cell2__title'])[1]//a";

    public YaResultByFilterPage(WebDriver driver){
        this.driver = driver;
        this.setProductName(driver.findElement(By.xpath(firstResultXPath)).getText());
    }

    public YaProductPage moveToProductPage(){
        driver.findElement(By.xpath(firstResultXPath)).click();
        return new YaProductPage(driver);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
