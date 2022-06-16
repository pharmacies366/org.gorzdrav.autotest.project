package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте Gorzdrav")
@DisplayName("Личный кабинет")
@Tag("Web")
@Tag("Regression")
public class PersonalDataWebTest extends BaseSettingsWebTests {

    @ParameterizedTest(name = "В личном кабинете пользователь переходит по ссылке => {index} {1}")
    @MethodSource("checkDisplayedOptions")
    @Description("Пользователь переходит в личный кабинет и проверяет отображения списка с пунктами страниц в Л.К." +
            " и релевантный переход")
    public void testSomething(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickToPersonalAccount();
        personalDataPage.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        personalDataPage.selectPersonalDataButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    private static Stream<Arguments> checkDisplayedOptions() {
        return Stream.of(
                Arguments.of("/my-account/my-profile", "Мой профиль", "Мой профиль"),
                Arguments.of("/my-account/update-password", "Изменить пароль", "Изменить пароль"),
                Arguments.of("/my-account/orders", "Мои покупки", "Мои заказы"),
                Arguments.of("/my-account/my-promotions", "Мои акции", "Мои акции"),
                Arguments.of("/my-account/my-advice", "Здрав Совет", "Здрав Совет"),
                Arguments.of("/logout/", "Выйти", "Как сделать заказ")
        );
    }


    @DisplayName("Пользователь заполняет отчество и сохраняет данные")
    @Test
    public void checkPersonalData() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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


    @DisplayName("Пользователь очищает поля имя и получает ошибку")
    @Test
    public void clearNameAndGettingError() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearName();
        personalDataPage.ckickSaveButton();
        personalDataPage.gettingErrorWithName();
    }

    @DisplayName("Пользователь изменяет и сохраняет имя")
    @Test
    public void changeName() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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

    @DisplayName("Пользователь изменяет дату рождения")
    @Test
    public void changeBirthday() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.changeBirthday("12", "Апрель", "1994");
        personalDataPage.ckickSaveButton();
        personalDataPage.changeBirthday("1", "Февраль", "1993");//Возврашаем в исходную дату
        personalDataPage.ckickSaveButton();
    }

/*    @DisplayName("Пользователь изменяет пол")
    @Test
    public void changeGender() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.changeGender("FEMALE");
        personalDataPage.ckickSaveButton();
        personalDataPage.getFemaleButton().checkAttribute("value", "FEMALE");
        personalDataPage.changeGender("MALE");
        personalDataPage.ckickSaveButton();
        personalDataPage.getMaleButton().checkAttribute("value", "MALE");
    }*/

    @DisplayName("Пользователь очищает поля email, нажимает сохранить и получает ошибку")
    @Test
    public void clearEmail() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearEmail();
        personalDataPage.ckickSaveButton();
        personalDataPage.gettingErrorWithEmail();
    }

    @DisplayName("Пользователь проверяет, что поле с номером телефона нельзя редактировать")
    @Test
    public void checkPhone() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.checkPhone();
    }

    @DisplayName("Проверка чекбокса с новостной рассылкой")
    @Test
    public void checkReceiveNews() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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
