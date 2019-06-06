import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.YaHomePage;
import pages.YaProductPage;
import pages.YaResultByFilterPage;
import java.util.concurrent.TimeUnit;


public class CheckNameResultAndDescTest {

    static WebDriver driver;

    @AfterClass
    public static void setUp(){
        driver = Driver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /*
    Тестовый сценарий. Нажимаем на ссылку "Маркет", далее на ссылку "Электроника", далее на ссылку "Мобильные телефоны".
    После фильтруем результаты по бренду Samsung и сумме от 40 т.р. Переходим по ссылке первого продукта в описании и
    и проверяем их соответствие.
     */
    @Test
    public void CheckNameSamsungInDescProduct(){
        YaHomePage yahomePage = new YaHomePage(driver);
        yahomePage.open();
        YaResultByFilterPage resultByFilterPage = yahomePage.moveToSamsungMobilesByFilter();
        YaProductPage productPage = resultByFilterPage.moveToProductPage();
        Assert.assertTrue(resultByFilterPage.getProductName().equals(productPage.getProductName()));
    }

    /*
    Тестовый сценарий. Нажимаем на ссылку "Маркет", далее на ссылку "Электроника", далее на ссылку "Наушники".
    После фильтруем результаты по бренду Beats и сумме от 17 т.р. lj 25 т.р. Переходим по ссылке первого продукта в описании и
    и проверяем их соответствие.
     */
    @Test
    public void CheckNameBeatsInDescProduct(){
        YaHomePage yaHomePage = new YaHomePage(driver);
        yaHomePage.open();
        YaResultByFilterPage resultByFilterPage = yaHomePage.moveToHeadphonesByFilter();
        YaProductPage productPage = resultByFilterPage.moveToProductPage();
        Assert.assertTrue(resultByFilterPage.getProductName().equals(productPage.getProductName()));
    }

    @BeforeClass
    public static void tearDown(){
        driver.close();
    }

}