package web.mainPage;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature(value = "Web")
@Story("Проверка шапки сайта gorzdrav")
public class HeaderBlockWebTest extends BaseSettingsWebTests {

    @Description("Проверка кликабельности логотипа")
    @Test(groups = {"Web", "Regression"})
    public void checkClickableLogo() {
        headerBlock.clickSiteLogo();
        pageActions.checkUrl("https://gorzdrav.org/");
    }

    @Description("Проверка кликабельности кнопки 'Каталог'")
    @Test(groups = {"Web", "Regression"})
    public void checkClickableCatalogButton() {
        headerBlock.clickCatalogButton();
        logger.info("Каталог кликабелен");
    }

    @Description("Проверка работы поиска")
    @Test(groups = {"Web", "Regression"})
    public void testingTheSearch() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.checkUrl("https://gorzdrav.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/search/?text=44226");
        logger.info("Поиск работает корректно");
    }

    @Description("Проверки работы корзины")
    @Test(groups = {"Web", "Regression"})
    public void testingTheCart() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        int quantity = headerBlock.checkCartQuantity();
        Assert.assertEquals(1, quantity);
        logger.info("Проверка прошла успешно");
    }

    @Description("Проверка кликабельности и корректности перехода по кнопке для выбора городов")
    @Test(groups = {"Web", "Regression"})
    public void checkButtonSelectCities() {
        headerBlock.clickCitiesButton();
        Assert.assertEquals("Выбор города", headerBlock.checkCitiesPopUp());
        logger.info("Проверка прошла успешно");
    }

    @Description("Проверка кликабельности кнопки 'Войти'")
    @Test(groups = {"Web", "Regression"})
    public void checkClickableSignIn() {
        headerBlock.clickToSignInButton();
        logger.info("Кнопка 'Войти' кликабельна");
    }

    @Description("Проверка кликабельности кнопки 'Зарегистрироваться'")
    @Test(groups = {"Web", "Regression"})
    public void checkClickableSignUp() {
        headerBlock.clickToSignInButton();
        headerBlock.clickToSignUpButton();
        logger.info("Кнопка 'Зарегистрироваться' кликабельна");
    }

    //нет на s1
/*    @Description("Проверка релевантного перехода по кнопке: 'Аптеки'")
    @Test(groups = {"Web", "Regression"})
    public void clickPharmacyButton() {
        headerBlock.clickPharmacyButton();
        pageActions.checkUrl("https://gorzdrav.org/apteki/map/");
    }

    @Description("Проверка релевантного перехода по кнопке: 'Карта Горздрав'")
    @Test(groups = {"Web", "Regression"})
    public void clickGorzdravMapButton() {
        headerBlock.clickGorzdravMap();
        pageActions.checkUrl("https://gorzdrav.org/club/");
    }

    @Description("Проверка релевантного перехода по кнопке: 'Доставка'")
    @Test(groups = {"Web", "Regression"})
    public void clickDeliveryButton() {
        headerBlock.clickDeliveryButton();
        pageActions.checkUrl("https://gorzdrav.org/delivery/");
    }

    @Description("Проверка релевантного перехода по кнопке: 'Бронирование'")
    @Test(groups = {"Web", "Regression"})
    public void clickBookingButton() {
        headerBlock.clickBookingButton();
        pageActions.checkUrl("https://gorzdrav.org/");
        pageActions.contentIsDisplayed("Как сделать заказ");
    }

    @Description("Проверка релевантного перехода по кнопке: 'Вакансии'")
    @Test(groups = {"Web", "Regression"})
    public void clickVacanciesButton() {
        headerBlock.clickVacanciesButton();
        pageActions.checkUrl("https://gorzdrav.org/vacansii/");
    }

    @Description("Проверка кликабельности номера телефона")
    @Test(groups = {"Web", "Regression"})
    public void checkClickablePhoneNumber() {
        headerBlock.getPhoneNumber().elementIsClickable();
        logger.info("Номер телефона кликабелен");
    }*/

}
