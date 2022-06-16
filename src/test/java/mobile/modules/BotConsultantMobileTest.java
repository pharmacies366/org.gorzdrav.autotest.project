package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Консультант бот на сайте Gorzdrav")
@DisplayName("Консультант бот")
@Tag("Mobile")
@Tag("Regression")
public class BotConsultantMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь выбирает пункт: Не могу оформить заказ, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemCanNotCheckout() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickCantNotOrder();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Мне нужен препарат, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedADrug() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickNeedADrug();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Нужна доставка, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedDelivery() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickNeedDelivery();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь проверяет закрытие консультант бота")
    @Test
    public void checkCloseBot() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickCloseBot();
        mobileMainPage.getBotConsultantButton().isElementDisplayed();

    }
}