package mobile.loginuser;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Авторизация пользователя")
@DisplayName("Авторизация пользователя по номеру телефона")
public class LoginUserPhoneTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь авторизовывается на сайте по номеру телефона")
    @Test
    public void loginUserPhone() {
        mobileCookiePage.reCaptchaKey();
        mobileProductCardPage.clickClosePopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setPhoneNumber(propertiesManager.getProperty("userauthphone"));
        mobileAuthPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mobileMainPage.checkElementIsCorrect();
    }

}
