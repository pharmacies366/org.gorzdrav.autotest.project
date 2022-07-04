package web.authorization;

import base.BaseSettingsWebTests;
import core.ScreenshotWatcher5;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.fail;

@Feature("Web")
@Story("Авторизация пользователя на сайте Gorzdrav")
@DisplayName("Авторизация пользователя")
@Tag("Web")
@Tag("Regression")
@Tag("Smoke")
public class SignInPositiveWebTest extends BaseSettingsWebTests {

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Description("Пользователь вводит номер телефона и пароль и нажимет кнопку Войти")
    @Test
    public void loginUserPhone() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        fail();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber1"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        headerBlock.checkElementIsCorrect();
    }
}
