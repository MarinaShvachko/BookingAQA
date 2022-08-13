package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import static utility.Constants.ERROR_TXT.WRONG_NUMBER_OF_HINTS;
import static utility.Constants.EXPECTED_HINTS.EXPECTED_DESTINATION_HINTS_NUMBER;

public class MainPageBaseTests extends BaseTest {

    @Test
    @Description("1.1 Check number of hints after enter a letter in destination field")
    public void checkNumberOfHintsInDestinationField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        int actualNumberOfHints = mainPage.getNumberOfHintsINDropDownDestinations();

        Assert.assertEquals(actualNumberOfHints, EXPECTED_DESTINATION_HINTS_NUMBER, WRONG_NUMBER_OF_HINTS);
    }

    @Test
    @Description("1.2 Check sorting after specifying destination")
    public void checkFiltrationInDestinationField() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.checkByLetterFiltrationHintsDropDownDestinations();
    }
}
