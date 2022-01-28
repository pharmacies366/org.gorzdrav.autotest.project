package web.loginuser;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя по номеру Бонусной карты")
public class LoginUserCardTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь авторизовывается на сайте по номеру Бонусной карты")
    @Test
    public void loginUserCardNumber() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.setChangeToCardNumber();
        authPopUpPage.setCardNumberAandPassword(propertiesManager.getProperty("userauthcard"), "userpass");
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mainPage.checkElementIsCorrect();
    }
}
