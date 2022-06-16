package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте Gorzdrav")
@DisplayName("Личный кабинет")
@Tag("Web")
@Tag("Regression")
public class ChangePasswordWebTest extends BaseSettingsWebTests {

 //нужно сдеелать проверку на сайте об изменении пароля
    @DisplayName("Пользователь изменяет пароль")
    @Test
    public void changePassword() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber8"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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
