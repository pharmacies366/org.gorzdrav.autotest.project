package mobile.privateOffice;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Личный кабинет на сайте Gorzdrav")
public class ChangePasswordMobileTest extends BaseSettingsMobileTests {
    //Нет никакой проверки на сайте на изменения пароля
    @Description("Проверка на изменения пароля")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь изменяет пароль")
    public void changePassword() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber8"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobilePersonalAccountPage.clickChangePassword();
        mobileChangePasswordPage.clickChangePassword(
                propertiesManager.getProperty("newuserpass"),
                propertiesManager.getProperty("newuserpass"));
        mobileChangePasswordPage.clickChangeButton();
        mobileChangePasswordPage.clickChangePassword(
                propertiesManager.getProperty("olduserpass"),
                propertiesManager.getProperty("olduserpass"));
        mobileChangePasswordPage.clickChangeButton();
        // mobileChangePasswordPage.getMessageAboutChangePassword();
    }
}
