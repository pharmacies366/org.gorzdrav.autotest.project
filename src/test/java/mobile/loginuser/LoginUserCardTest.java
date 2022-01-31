package mobile.loginuser;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя по номеру Бонусной карты")
public class LoginUserCardTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь авторизовывается на сайте по номеру Бонусной карты")
    @Test
    public void loginUserCardNumber() {
        mobileCookiePage.reCaptchaKey();
        mobileProductCardPage.clickClosePopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setChangeToCardNumber();
        mobileAuthPopUpPage.setCardNumberAandPassword(
                propertiesManager.getProperty("userauthcard"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mobileMainPage.checkElementIsCorrect();
    }
}
