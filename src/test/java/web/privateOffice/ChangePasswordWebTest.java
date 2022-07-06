package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте Gorzdrav")
public class ChangePasswordWebTest extends BaseSettingsWebTests {

    //нужно сдеелать проверку на сайте об изменении пароля
    @Description("Проверка на изменения пароля")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь изменяет пароль")
    public void changePassword() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber8"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.clickSiteLogo();
        headerBlock.clickToPersonalAccount();
        pageActions.waitPageLoad();
        headerBlock.clickChangePassword();
        pageActions.waitPageLoad();
        changePasswordPage.clickChangePassword(
                propertiesManager.getProperty("newuserpass"),
                propertiesManager.getProperty("newuserpass"));
        changePasswordPage.clickChangeButton();
        // changePasswordPage.getMessageAboutChangePassword();
        pageActions.waitPageLoad();
        changePasswordPage.clickChangePassword(
                propertiesManager.getProperty("olduserpass"),
                propertiesManager.getProperty("olduserpass"));
        changePasswordPage.clickChangeButton();
        // changePasswordPage.getMessageAboutChangePassword();
    }
}
