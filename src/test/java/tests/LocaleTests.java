package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Language;

public class LocaleTests extends BaseTest{
    @Test
    public void SetLocaleToES() {
        homePage.chooseLanguage(Language.ES);

        Assert.assertEquals(homePage.getTitleES(), "Página de aterrizaje");
    }
    @Test
    public void SetLocaleToEN() {
        homePage.chooseLanguage(Language.EN);

        Assert.assertEquals(homePage.getTitleEN(), "Landing");
    }
    @Test
    public void SetLocaleToFR() {
        homePage.chooseLanguage(Language.FR);

        Assert.assertEquals(homePage.getTitleFR(), "Page d'atterrissage");
    }
}
