package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    static final Logger log = Logger.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
