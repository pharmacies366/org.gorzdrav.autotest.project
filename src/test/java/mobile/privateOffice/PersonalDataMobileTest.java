package mobile.privateOffice;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Личный кабинет на сайте Gorzdrav")
public class PersonalDataMobileTest extends BaseSettingsMobileTests {


/*    private static Stream<Arguments> checkDisplayedOptions() {
        return Stream.of(
                Arguments.of("/my-account/my-profile", "Мой профиль", "Мой профиль"),
                Arguments.of("/my-account/update-password", "Изменить пароль", "Изменить пароль"),
                Arguments.of("/my-account/orders", "Мои покупки", "Мои покупки"),
                Arguments.of("/my-account/my-promotions", "Мои акции", "Мои акции"),
                Arguments.of("/my-account/my-advice", "Здрав Совет", "Здрав Совет"),
                Arguments.of("/logout/", "Выйти", "Как сделать заказ")
        );
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkDisplayedOptions")
    public void checkDisplayedOptions(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobilePersonalDataPage.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobilePersonalDataPage.selectPersonalDataButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }*/

    @Description("Проверка на заполнение и сохранения изменений для поля Отчество")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь заполняет отчество и сохраняет данные")
    public void checkPersonalData() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearPatronymic();
        pageActions.waitPageLoad();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.personalDetails(
                propertiesManager.getProperty("patronymic"));
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkSavePersonalData();
    }

    @Description("Проверка на получение ошибки при сохраниние данных без имени")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь очищает поля имя и получает ошибку")
    public void clearNameAndGettingError() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearName();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.gettingErrorWithName();
    }

    @Description("Проверка на заполнение и сохранения изменений для поля Имя")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь изменяет и сохраняет имя")
    public void changeName() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
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

    @Description("Проверка на заполнение и сохранения изменений для полей с датой рождения")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь изменяет дату рождения")
    public void changeBirthday() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.changeBirthday("12", "Апрель", "1994");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.changeBirthday("1", "Февраль", "1993");//Возврашаем в исходную дату
        mobilePersonalDataPage.ckickSaveButton();
    }

    //Сделать корректную проверку на изменения пола
    @Description("Проверка на заполнение и сохранения изменений для выбора пола")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь изменяет пол")
    public void changeGender() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.changeGender("2");
        pageActions.waitPageLoad();
        mobilePersonalDataPage.ckickSaveButton();
        // mobilePersonalDataPage.getFemaleCheck().checkAttribute("value", "FEMALE");
        mobilePersonalDataPage.changeGender("1");
        pageActions.waitPageLoad();
        mobilePersonalDataPage.ckickSaveButton();
        // mobilePersonalDataPage.getMaleButton().checkAttribute("value", "MALE");
    }

    @Description("Проверка на получение ошибки при сохраниние данных без email")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь очищает поля email, нажимает сохранить и получает ошибку")
    public void clearEmail() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearEmail();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.gettingErrorWithEmail();
    }

    @Description("Проверка на недоступность для редактирования поля телефон")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет, что поле с номером телефона нельзя редактировать")
    public void checkPhone() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.checkPhone();
    }

    @Description("Проверка на установку чекбокса с новостной рассылкой")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь поочерёдно устонавливает и снимает чекбокс с новостной рассылкой")
    public void checkReceiveNews() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
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
