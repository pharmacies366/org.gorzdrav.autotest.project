package web.authorization;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Авторизация пользователя на сайте Gorzdrav")
@DisplayName("Авторизация пользователя")
public class SignInPositiveWebTest extends BaseSettingsWebTests {

/*    @DisplayName("Авторизация пользователя на сайте по номеру Бонусной карты")
    @Test
    public void loginUserCardNumber() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        authPopUpPage.setChangeToCardNumber();
        authPopUpPage.setCardNumberAandPassword(
                propertiesManager.getProperty("bonuscard1"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        headerBlock.checkElementIsCorrect();
    }*/

/*    @DisplayName("Авторизация пользователя на сайте через E-mail")
    @Test
    public void loginUserEmail() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        authPopUpPage.setChangeToEmail();
        authPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("userauthmail1"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        headerBlock.checkElementIsCorrect();
    }*/

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Test
    public void loginUserPhone() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber1"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        headerBlock.checkElementIsCorrect();
    }
}
