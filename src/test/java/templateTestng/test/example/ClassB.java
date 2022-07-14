package templateTestng.test.example;

import org.testng.annotations.Test;
import templateTestng.core.MainTestBase;
import templateTestng.pages.googlePages.GoogleMainPage;

import static templateTestng.actions.BrowserActions.navigateTo;

public class ClassB extends MainTestBase {
    @Test
    public void simpleTest1() {
        navigateTo("https://www.google.ru/");
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.getSearchInput().sendKeys("test");
        googleMainPage.getSpeechElement().click();
        googleMainPage.getToolsButton().click();
    }

    @Test
    public void simpleTest2() {
        navigateTo("https://www.google.ru/");
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.getSearchInput().sendKeys("test");
        googleMainPage.getSpeechElement().click();
        googleMainPage.getToolsButton().click();
    }

    @Test
    public void simpleTest3() {
        navigateTo("https://www.google.ru/");
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.getSearchInput().sendKeys("test");
        googleMainPage.getSpeechElement().click();
        googleMainPage.getToolsButton().click();
    }

    @Test
    public void simpleTest4() {
        navigateTo("https://www.google.ru/");
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.getSearchInput().sendKeys("test");
        googleMainPage.getSpeechElement().click();
        googleMainPage.getToolsButton().click();
    }

    @Test
    public void simpleTest5() {
        navigateTo("https://www.google.ru/");
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.getSearchInput().sendKeys("test");
        googleMainPage.getSpeechElement().click();
        googleMainPage.getToolsButton().click();
    }
}
