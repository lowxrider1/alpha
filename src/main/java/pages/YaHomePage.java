package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class YaHomePage {

    private WebDriver driver;

    public static String YA_HOME_PAGE_URL = "https://yandex.ru";

    //Test values
    public Integer minsumSamsung = 40000;
    public Integer minsumBeats = 17000;
    public Integer maxsumBeats = 25000;

    //XPATH
    public static String marketXPath = "//a[contains(@data-id,'market')]]";
    public static String electronicsXPath = "//span[contains(text(), 'Электроника')]";
    public static String mobilesXPath = "//a[contains(text(), 'Мобильные телефоны')]";

    public static String checkSamsungFilterXPath = "//a[@class='_2RDCAZB4Gk']//span[@class='NVoaQvqe58']['contains(text(),'Samsung')']";
    public static String checkMinsumXPath = "//input[@id='glpricefrom']";
    public static String checkMaxsumXPath = "//input[@id='glpriceto']";

    public static String headphonesXPath = "//a[contains(text(),'Наушники и Bluetooth-гарнитуры')]";
    public static String checkBeatsFilterXPath = "//span[contains(text(), 'Beats')]";

    public YaHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void open() {
        driver.get(YA_HOME_PAGE_URL);
    }

    public YaResultByFilterPage moveToSamsungMobilesByFilter(){
        driver.findElement(By.xpath(marketXPath)).click();
        driver.findElement(By.xpath(electronicsXPath)).click();
        driver.findElement(By.xpath(mobilesXPath)).click();
        driver.findElement(By.xpath(checkSamsungFilterXPath)).click();
        driver.findElement(By.xpath(checkMinsumXPath)).sendKeys(minsumSamsung.toString());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new YaResultByFilterPage(driver);
    }

    public YaResultByFilterPage moveToHeadphonesByFilter(){
        driver.findElement(By.xpath(marketXPath)).click();
        driver.findElement(By.xpath(electronicsXPath)).click();
        driver.findElement(By.xpath(headphonesXPath)).click();
        driver.findElement(By.xpath(checkBeatsFilterXPath)).click();
        driver.findElement(By.xpath(checkMinsumXPath)).sendKeys(minsumBeats.toString());
        driver.findElement(By.xpath(maxsumBeats.toString()));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new YaResultByFilterPage(driver);
    }
}
