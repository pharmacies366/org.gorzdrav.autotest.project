package web.mainPage;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story("Проверка шапки сайта gorzdrav")
@DisplayName("Проверка шапки сайта")
@Tag("Regression")
public class HeaderBlockWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogo(){
        headerBlock.getSiteLogo().elementIsClickable();
        logger.info("Логотип кликабелен");
    }

    @DisplayName("Проверка кликабельности кнопки 'Каталог'")
    @Test
    public void checkClickableCatalogButton(){
        headerBlock.clickCatalogButton();
        logger.info("Каталог кликабелен");
    }

    @DisplayName("Проверка работы поиска")
    @Test
    public void testingTheSearch(){
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.checkUrl("https://gorzdrav.org/search/?text=44226");
        logger.info("Поиск работает корректно");
    }

    @DisplayName("Проверки работы корзины")
    @Test
    public void testingTheCart(){
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        int quantity = headerBlock.checkCartQuantity();
        Assertions.assertEquals(1, quantity);
        logger.info("Проверка прошла успешно");
    }

    @DisplayName("Проверка кликабельности и корректности перехода по кнопке для выбора городов")
    @Test
    public void checkButtonSelectCities(){
        headerBlock.clickCitiesButton();
        Assertions.assertEquals("Выбор города", headerBlock.checkCitiesPopUp());
        logger.info("Проверка прошла успешно");
    }

    @DisplayName("Проверка кликабельности кнопки 'Войти'")
    @Test
    public void checkClickableSignIn(){
        headerBlock.clickToSignInButton();
        logger.info("Кнопка 'Войти' кликабельна");
    }

    @DisplayName("Проверка кликабельности кнопки 'Зарегистрироваться'")
    @Test
    public void checkClickableSignUp(){
        headerBlock.clickToSignInButton();
        headerBlock.clickToSignUpButton();
        logger.info("Кнопка 'Зарегистрироваться' кликабельна");
    }

/*    @DisplayName("Проверка релевантного перехода по кнопке: 'Аптеки'") //нет на s1
    @Test
    public void clickPharmacyButton(){
        headerBlock.clickPharmacyButton();
        pageActions.checkUrl("https://gorzdrav.org/apteki/map/");
    }*/

/*    @DisplayName("Проверка релевантного перехода по кнопке: 'Карта Горздрав'") //нет на s1
    @Test
    public void clickGorzdravMapButton(){
        headerBlock.clickGorzdravMap();
        pageActions.checkUrl("https://gorzdrav.org/club/");
    }*/

/*    @DisplayName("Проверка релевантного перехода по кнопке: 'Доставка'") //нет на s1
    @Test
    public void clickDeliveryButton(){
        headerBlock.clickDeliveryButton();
        pageActions.checkUrl("https://gorzdrav.org/delivery/");
    }*/

/*    @DisplayName("Проверка релевантного перехода по кнопке: 'Бронирование'")  //нет на s1
    @Test
    public void clickBookingButton(){
        headerBlock.clickBookingButton();
        pageActions.checkUrl("https://gorzdrav.org/");
        pageActions.contentIsDisplayed("Как сделать заказ");
    }

    @DisplayName("Проверка релевантного перехода по кнопке: 'Вакансии'")
    @Test
    public void clickVacanciesButton(){
        headerBlock.clickVacanciesButton();
        pageActions.checkUrl("https://gorzdrav.org/vacansii/");
    }

    @DisplayName("Проверка кликабельности номера телефона")
    @Test
    public void checkClickablePhoneNumber(){
        headerBlock.getPhoneNumber().elementIsClickable();
        logger.info("Номер телефона кликабелен");
    }*/

}
