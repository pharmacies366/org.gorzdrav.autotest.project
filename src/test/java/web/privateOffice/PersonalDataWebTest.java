package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте Gorzdrav")
public class PersonalDataWebTest extends BaseSettingsWebTests {

    @Description("Проверка коррекного содержания ссылок в личном кабинете")
    @Test(dataProvider = "checkDisplayedOptions", groups = {"Web", "Regression"})
    @Step("Пользователь проверяет название ссылки, кликает по ней и проверяет содержание текста на странице")
    public void checkDisplayedOptions(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        personalDataPage.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        personalDataPage.selectPersonalDataButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    @DataProvider(name = "checkDisplayedOptions")
    public Object[][] checkDisplayedOptions() {
        return new Object[][]{
                {"/my-account/my-profile", "Мой профиль", "Мой профиль"},
                {"/my-account/update-password", "Изменить пароль", "Изменить пароль"},
                {"/my-account/orders", "Мои покупки", "Мои покупки"},
                //{"/my-account/my-promotions", "Мои акции", "Мои акции"}, убрали на проде
                {"/my-account/my-advice", "Здрав Совет", "Здрав Совет"},
                {"/logout/", "Выйти", "Как сделать заказ"}
        };
    }


    @Description("Проверка на заполнение и сохранения изменений для поля Отчество")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь заполняет отчество и сохраняет данные")
    public void checkPersonalData() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearPatronymic();
        personalDataPage.ckickSaveButton();
        pageActions.waitPageLoad();
        personalDataPage.personalDetails(
                propertiesManager.getProperty("patronymic"));
        personalDataPage.ckickSaveButton();
        personalDataPage.checkSavePersonalData();
    }


    @Description("Проверка на получение ошибки при сохраниние данных без имени")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь очищает поля имя и получает ошибку")
    public void clearNameAndGettingError() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearName();
        personalDataPage.ckickSaveButton();
        personalDataPage.gettingErrorWithName();
    }

    @Description("Проверка на заполнение и сохранения изменений для поля Имя")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь изменяет и сохраняет имя")
    public void changeName() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearName();
        personalDataPage.sendName("Alex");
        personalDataPage.ckickSaveButton();
        personalDataPage.checkNewName("Alex");
        personalDataPage.clearName();
        personalDataPage.sendName("Ivan");
        personalDataPage.ckickSaveButton();
        personalDataPage.checkNewName("Ivan");
    }

    @Description("Проверка на заполнение и сохранения изменений для полей с датой рождения")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь изменяет дату рождения")
    public void changeBirthday() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.changeBirthday("12", "Апрель", "1994");
        personalDataPage.ckickSaveButton();
        personalDataPage.changeBirthday("1", "Февраль", "1993");//Возврашаем в исходную дату
        personalDataPage.ckickSaveButton();
    }

    //Сделать корректную проверку на изменения пола
    @Description("Проверка на заполнение и сохранения изменений для выбора пола")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь изменяет пол")
    public void changeGender() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.changeGenderToFemale();
        personalDataPage.ckickSaveButton();
        personalDataPage.getFemaleButton().checkAttribute("value", "FEMALE");
        personalDataPage.changeGenderToMale();
        personalDataPage.ckickSaveButton();
        personalDataPage.getMaleButton().checkAttribute("value", "MALE");
    }

    @Description("Проверка на получение ошибки при сохраниние данных без email")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь очищает поля email, нажимает сохранить и получает ошибку")
    public void clearEmail() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearEmail();
        personalDataPage.ckickSaveButton();
        personalDataPage.gettingErrorWithEmail();
    }

    @Description("Проверка на недоступность для редактирования поля телефон")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет, что поле с номером телефона нельзя редактировать")
    public void checkPhone() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.checkPhone();
    }

    @Description("Проверка на установку чекбокса с новостной рассылкой")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь поочерёдно устонавливает и снимает чекбокс с новостной рассылкой")
    public void checkReceiveNews() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clickReceiveNews();
        personalDataPage.ckickSaveButton();
        personalDataPage.checkSelectedCheckboxReceiveNews();
        personalDataPage.clickReceiveNews();
        personalDataPage.ckickSaveButton();
        personalDataPage.checkNotSelectedCheckboxReceiveNews();
    }

}
