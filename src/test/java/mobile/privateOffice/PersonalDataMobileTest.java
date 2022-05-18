package mobile.privateOffice;

import base.BaseSettingsMobileTests;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;

@Feature(value = "Мобильная версия")
@Story(value = "Личный кабинет на сайте Gorzdrav")
@DisplayName("Личный кабинет")
@RunWith(DataProviderRunner.class)
public class PersonalDataMobileTest extends BaseSettingsMobileTests {

    @DataProvider
    public static Object[][] checkDisplaedOptions() {
        return new Object[][]{
                {"/my-account/my-profile", "Мой профиль", "Мой профиль"},
                {"/my-account/update-password", "Изменить пароль", "Изменить пароль"},
                {"/my-account/orders", "Мои покупки", "Мои покупки"},
                {"/my-account/my-promotions", "Мои акции", "Мои акции"},
                {"/my-account/my-advice", "Здрав Совет", "Здрав Совет"},
                {"/logout/", "Выйти", "Как сделать заказ"}
        };
    }

    @DisplayName("Пользователь переходит в личный кабинет и проверяет отображения списка с пунктами страниц в Л.К." +
            " и релевантный переход")
    @Step("В личном кабинете переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("checkDisplaedOptions")
    public void checkDisplaedOptions(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileCartPage.checkAndClearCartQuantity();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobilePersonalDataPage.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobilePersonalDataPage.selectPersonalDataButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    @DisplayName("Пользователь заполняет отчество и сохраняет данные")
    @Test
    public void checkPersonalDeta() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearPatronymic();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.personalDetails(
                propertiesManager.getProperty("patronymic"));
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkSavePersonalData();
    }

    @DisplayName("Пользователь очищает поля имя и получает ошибку")
    @Test
    public void clearNameAndGettingError() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearName();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.gettingErrorWithName();
    }

    @DisplayName("Пользователь изменяет и сохраняет имя")
    @Test
    public void chanchName() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearName();
        mobilePersonalDataPage.sendName("Alex");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkNewName("Alex");
        mobilePersonalDataPage.clearName();
        mobilePersonalDataPage.sendName("Ivan");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkNewName("Ivan");
    }

    @DisplayName("Пользователь изменяет дату рождения")
    @Test
    public void changeBirthday() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.changeBirthday("12","Апрель","1994");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.changeBirthday("1","Февраль","1993");//Возврашаем в исходную дату
        mobilePersonalDataPage.ckickSaveButton();
    }

/*    @DisplayName("Пользователь изменяет пол")
    @Test
    public void changeGender() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.changeGender("FEMALE");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.getFemaleButton().checkAttribute("value", "FEMALE");
        mobilePersonalDataPage.changeGender("MALE");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.getMaleButton().checkAttribute("value", "MALE");
    }*/

    @DisplayName("Пользователь очищает поля email, нажимает сохранить и получает ошибку")
    @Test
    public void clearEmail() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearEmail();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.gettingErrorWithEmail();
    }

    @DisplayName("Пользователь проверяет, что поле с номером телефона нельзя редактировать")
    @Test
    public void checkPhone() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.checkPhone();
    }

    @DisplayName("Проверка чекбокса с новостной рассылкой")
    @Test
    public void checkReceiveNews() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clickReceiveNews();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkSelectedCheckboxReceiveNews();
        mobilePersonalDataPage.clickReceiveNews();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkNotSelectedCheckboxReceiveNews();
    }

}