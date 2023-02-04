package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{
    @Test
    public void SetLocaleToES() {
        homePage.getLanguageButton().click();
        homePage.getLocaleES().click();

        Assert.assertEquals(homePage.getTitleES(), "Página de aterrizaje");
    }
    @Test
    public void SetLocaleToEN() {
        homePage.getLanguageButton().click();
        homePage.getLocaleEN().click();
        Assert.assertEquals(homePage.getTitleEN(), "Landing");
    }
    @Test
    public void SetLocaleToFR() {
        homePage.getLanguageButton().click();
        homePage.getLocaleFR().click();
        Assert.assertEquals(homePage.getTitleFR(), "Page d'atterrissage");
    }
}
