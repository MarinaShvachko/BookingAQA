package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div//button[contains(@class, 'destination__clear')]")
    WebElement clearDestinationFieldButton;

    WebElement destinationField = driver.findElement(By.className("sb-destination-label-sr"));

    private static String pathToDestinationHints = "//div//ul//li[@role='option']";
    private static final int EXPECTED_DESTINATION_HINTS_NUMBER = 5;
    private static final String CITY_NAME_FOR_CHECKING_FILTRATION = "Стамбул";
    private static final int LENGTH_LIMITATION_FOR_CHECKING_FILTRATION = 3;

    List<WebElement> listOfDestinationHints;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //TODO may be I need to delete assert and add them to MainPageBaseTests where I will combine methods and then write only one assert
    public void checkNumberHintsDropDownDestinations() {
        destinationField.sendKeys("Б");
        listOfDestinationHints = (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(pathToDestinationHints), 0));
        Assert.assertEquals(listOfDestinationHints.size(), EXPECTED_DESTINATION_HINTS_NUMBER, "Number of hints in drop down list not equals " + EXPECTED_DESTINATION_HINTS_NUMBER);
        log.info("The number of hints after putting a character in destination field = " + listOfDestinationHints.size());
    }

    //TODO убрать Thread.sleep
    public void checkByLetterFiltrationHintsDropDownDestinations() throws InterruptedException {
        destinationField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
        destinationField.sendKeys(Keys.DELETE);
        String joinedLetters = "";

        for (int x = 0; x < LENGTH_LIMITATION_FOR_CHECKING_FILTRATION; x++) {
            String inputLetterToDestination = CITY_NAME_FOR_CHECKING_FILTRATION.substring(x, x+1);
            joinedLetters += inputLetterToDestination;
            destinationField.sendKeys(inputLetterToDestination);
            Thread.sleep(3000);
            listOfDestinationHints = driver.findElements(By.xpath(pathToDestinationHints));

            for (WebElement destination : listOfDestinationHints) {
               Assert.assertEquals(joinedLetters, destination.getText().substring(0, x+1), "Input letters and letters from hints aren't match");
            }
        }
    }

    public void clearDestinationField() {
        clearDestinationFieldButton.click();
    }

    public void fillStartDate() {

    }

    public void fillEndDate() {

    }

    //transition method
    public SearchResultsPage clickSearchButton() {
        //click()
        return new SearchResultsPage(driver);
    }
}
