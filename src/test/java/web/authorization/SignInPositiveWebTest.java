package web.authorization;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Web")
@Story("Авторизация пользователя на сайте Gorzdrav")
@DisplayName("Авторизация пользователя")
@Tag("Regression")
@Tag("Smoke")
public class SignInPositiveWebTest extends BaseSettingsWebTests {

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Description("Пользователь вводит номер телефона и пароль и нажимет кнопку Войти")
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
