package mobile.authorization;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя на сайте Gorzdrav")
@DisplayName("Авторизация пользователя")
public class SignInPositive extends BaseSettingsMobileTests {

/*    @DisplayName("Авторизация пользователя на сайте по номеру Бонусной карты")
    @Test
    public void loginUserCardNumber() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setChangeToCardNumber();
        mobileAuthPopUpPage.setCardNumberAandPassword(
                propertiesManager.getProperty("mobilebonuscard1"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }*/

    @DisplayName("Авторизация пользователя на сайте через E-mail")
    @Test
    public void loginUserEmail() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setChangeToEmail();
        mobileAuthPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("mobileuserauthmail1"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }

    @DisplayName("Авторизация пользователя на сайте по номеру телефона")
    @Test
    public void loginUserPhone() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setPhoneNumber(propertiesManager.getProperty("mobilephonenumber1"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }
}
