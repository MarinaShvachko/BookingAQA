package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utility.Constants.ERROR_TXT.NOT_RIGHT_PAGE_TITLE;
import static utility.Constants.PAGE_TITLES.BASIC_TITLE_SEARCH_RESULT_PAGE;


public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        if (!driver.getTitle().contains(BASIC_TITLE_SEARCH_RESULT_PAGE)) {
            throw new IllegalStateException(NOT_RIGHT_PAGE_TITLE + ". The title is " + driver.getTitle());
        }
    }

    @FindBy(xpath = "//h1")
    WebElement header;

    public String getPageHeader() {
        log.info(header.getText());
        return header.getText();
    }
}
