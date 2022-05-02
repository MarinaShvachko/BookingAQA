package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

public class BaseTest {
    protected WebDriver driver;
    private final String URL = "http://booking.com";
    protected MainPage mainPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //вынести это в отдельные методы т.к. стартовые страницы будут разные
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
