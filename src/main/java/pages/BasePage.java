package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BasePage {
    protected WebDriver driver;
    public BasePage (WebDriver driver) {
        this.driver = driver;
    }
    static final Logger log = Logger.getLogger(BasePage.class);

    //общие методы для всех страниц
//    protected WebElement find (By locator) {
//        return driver.findElement(locator);
//    }
//    protected void type (String text, By locator) {
//        find(locator).sendKeys(text);
//    }
//    protected void click (By locator) {
//        find(locator).click();
//    }

    public void sendKeys(WebElement field, String whatToType) {
        field.sendKeys(whatToType);
    }
}
