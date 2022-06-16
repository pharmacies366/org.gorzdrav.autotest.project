package mobile.authorization;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя на сайте Gorzdrav")
@DisplayName("Авторизация пользователя")
@Tag("Mobile")
@Tag("Regression")
@Tag("Smoke")
public class SignInPositiveMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Test
    public void loginUserPhoneNumberAndPassword() {
        mobileCookiePage.reCaptchaKey();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileAuthPopUpPage.setPhoneAndPassword(
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mobileMainPage.checkElementIsCorrect();
    }
}