package web.authorization;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Web")
@Story("Авторизация пользователя на сайте Gorzdrav")
public class SignInPositiveWebTest extends BaseSettingsWebTests {

    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Web", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhone() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber1"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        headerBlock.checkElementIsCorrect();
    }
}
