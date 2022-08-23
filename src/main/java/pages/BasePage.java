package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasePage {
    static final Logger log = Logger.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //TODO: change if null , set a current date
    public WebElement findDateInCalendar(LocalDateTime dateToFind, List<WebElement> dates) {

        String formattedDate = dateToFind.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        WebElement dataToClick = null;

        for (WebElement date : dates) {
            if (date.getAttribute("data-date") == null) {
                continue;
            } else if (date.getAttribute("data-date").equals(formattedDate)) {
                dataToClick = date;
                break;
            }
        }
        return dataToClick;
    }

    public void sendKeys(WebElement field, String whatToType) {
        field.sendKeys(whatToType);
    }
}
