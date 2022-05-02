package tests;

import org.testng.annotations.Test;

public class MainPageBaseTests extends BaseTest{

    @Test
    public void destinationFieldFiltersChecks() throws InterruptedException {
        mainPage.checkNumberHintsDropDownDestinations();
        mainPage.checkByLetterFiltrationHintsDropDownDestinations();

        //тут могут быть ассерты, а в отдельном пакете ниже создать именно тесты @Test, если не делать ассерты в main
    }
}
