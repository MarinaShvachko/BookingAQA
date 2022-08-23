package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultsPage;

import static utility.Constants.ERROR_TXT.NOT_RIGHT_PAGE_HEADING;
import static utility.Constants.ERROR_TXT.WRONG_NUMBER_OF_HINTS;
import static utility.Constants.EXPECTED_HINTS.EXPECTED_DESTINATION_HINTS_NUMBER;
import static utility.Constants.TravelData.*;

public class MainPageBaseTests extends BaseTest {

    @Test(description = "1.1 Check number of hints after enter a letter in destination field")
    public void checkNumberOfHintsInDestinationField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        int actualNumberOfHints = mainPage.getNumberOfHintsINDropDownDestinations();

        Assert.assertEquals(actualNumberOfHints, EXPECTED_DESTINATION_HINTS_NUMBER, WRONG_NUMBER_OF_HINTS);
    }

    @Test(description = "1.2 Check sorting after specifying destination")
    public void checkFiltrationInDestinationField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.checkByLetterFiltrationHintsDropDownDestinations();
    }

    @Test(description = "1.3 Check search by city name, near dates, default number of people and rooms")
    public void checkSearchByCityAndNearDates() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.fillDestinationField(DESTINATION_LISBON);
        mainPage.setCheckInCheckOutDates(DAYS_UNTIL_CHECKIN, DAYS_UNTIL_CHECKOUT);
        SearchResultsPage searchResults = mainPage.clickSearchButton();

        Assert.assertTrue(searchResults.getPageHeader().startsWith(DESTINATION_LISBON), NOT_RIGHT_PAGE_HEADING);
    }
}
