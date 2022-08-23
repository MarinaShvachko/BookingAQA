package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static utility.Constants.DataForDestinationField.CITY_NAME_FOR_CHECKING_FILTRATION;
import static utility.Constants.DataForDestinationField.LENGTH_LIMITATION_FOR_CHECKING_FILTRATION;
import static utility.Constants.URL.MAIN_PAGE_URL;


public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    private static String pathToDestinationHints = "//div//ul//li[@role='option']";
    List<WebElement> listOfDestinationHints;

    @FindBy(className = "sb-destination-label-sr")
    WebElement destinationField;

    @FindBy(xpath = "//div[contains(@class,'dates__checkin')]")
    WebElement datesCalendar;

    @FindBy(xpath = "//div[@class='bui-calendar__wrapper']//tr//td")
    List<WebElement> datesOfDepartureCalendar;

    @FindBy(xpath = "//div//button[@class='sb-searchbox__button ']")
    WebElement makeSearchButton;

    public int getNumberOfHintsINDropDownDestinations() {
        destinationField.sendKeys("N");
        listOfDestinationHints = (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(pathToDestinationHints), 0));
        log.info("The number of hints after putting a character in destination field = " + listOfDestinationHints.size());
        return listOfDestinationHints.size();
    }

    //TODO убрать Thread.sleep
    public void checkByLetterFiltrationHintsDropDownDestinations() {
        SoftAssert softAssert = new SoftAssert();
        String joinedLetters = "";

        for (int x = 0; x < LENGTH_LIMITATION_FOR_CHECKING_FILTRATION; x++) {
            String inputLetterToDestination = CITY_NAME_FOR_CHECKING_FILTRATION.substring(x, x + 1);
            joinedLetters += inputLetterToDestination;
            log.info("Joined letters are " + joinedLetters);

            destinationField.sendKeys(inputLetterToDestination);
            log.info("Entered letters " + inputLetterToDestination);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            listOfDestinationHints = driver.findElements(By.xpath(pathToDestinationHints));

            for (WebElement destination : listOfDestinationHints) {
                softAssert.assertEquals(joinedLetters, destination.getText().substring(0, x + 1), "Input letters and letters from hints aren't match");
                log.info("Expected letters - " + joinedLetters + ", actual letters - " + destination.getText().substring(0, x + 1));
            }
            softAssert.assertAll();
        }
    }

    public Boolean fillDestinationField(String destinationPoint) {
        destinationField.sendKeys(destinationPoint);
        return true;
    }

//    public Boolean deleteAllFromDestinationField() {
//        destinationField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
//        destinationField.sendKeys(Keys.DELETE);
//        return true;
//    }

    public Boolean setCheckInCheckOutDates(int daysUntilCheckIn, int daysUntilCheckOut) {
        LocalDateTime checkInDate = LocalDateTime.now().plusDays(daysUntilCheckIn);
        LocalDateTime checkOutDate = LocalDateTime.now().plusDays(daysUntilCheckOut);

        datesCalendar.click();

        WebElement foundCheckInDate = findDateInCalendar(checkInDate, datesOfDepartureCalendar);
        WebElement foundCheckOutDate = findDateInCalendar(checkOutDate, datesOfDepartureCalendar);

        foundCheckInDate.click();
        foundCheckOutDate.click();

        return true;
    }

    public SearchResultsPage clickSearchButton() {
        makeSearchButton.click();
        return new SearchResultsPage(driver);
    }
}
