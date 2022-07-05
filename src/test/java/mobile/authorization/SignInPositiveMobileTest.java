package mobile.authorization;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя на сайте Gorzdrav")
public class SignInPositiveMobileTest extends BaseSettingsMobileTests {
    @Description("Проверка авторизации пользователя на сайте")
    @Test(groups = { "Mobile", "Smoke", "Regression" })
    @Step("Авторизация по номеру телефона и паролю")
    public void loginUserPhoneNumberAndPassword() {
        mobileCookiePage.reCaptchaKey();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileAuthPopUpPage.setPhoneAndPassword(
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }
}
