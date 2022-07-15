package templateTestng.web.authorization;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import templateTestng.blocks.web.WebHeaderBlock;
import templateTestng.core.MainTestBase;
import templateTestng.pages.authorization.AuthPopUpPage;
import templateTestng.pages.cookie.CookiePage;

import static templateTestng.actions.BrowserActions.navigateTo;

@Feature("Web")
@Story("Авторизация пользователя на сайте Gorzdrav")
public class SignInPositiveWebTest extends MainTestBase {

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber1"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone2() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber2"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone3() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber3"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone4() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber4"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone5() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber5"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone6() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber6"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone7() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone8() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber8"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone9() {
        navigateTo("https://gorzdrav.org/");
        CookiePage cookiePage = new CookiePage();
        cookiePage.reCaptchaKey();
        WebHeaderBlock webHeaderBlock = new WebHeaderBlock();
        webHeaderBlock.clickToSignInButton();
        AuthPopUpPage authPopUpPage = new AuthPopUpPage();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        webHeaderBlock.checkElementIsCorrect();
    }

}
