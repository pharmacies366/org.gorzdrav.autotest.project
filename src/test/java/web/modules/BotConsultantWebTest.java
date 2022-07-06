package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Web")
@Story(value = "Консультант бот на сайте 36.6")
public class BotConsultantWebTest extends BaseSettingsWebTests {
    @Description("Проверка пункта: Не могу оформить заказ")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь заполняет свои данные и получает ответ от бота")
    public void checkItemCanNotCheckout() {
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickCantNotOrder();
        botConsultantPopUpPage.contactDetails("test", "00000000000", "test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @Description("Проверка пункта: Мне нужен препарат")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь заполняет свои данные и получает ответ от бота")
    public void checkItemINeedADrug() {
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickNeedADrug();
        botConsultantPopUpPage.contactDetails("test", "00000000000", "test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @Description("Проверка пункта: Нужна доставка")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь заполняет свои данные и получает ответ от бота")
    public void checkItemINeedDelivery() {
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickNeedDelivery();
        botConsultantPopUpPage.contactDetails("test", "00000000000", "test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @Description("Проверка закрытия консультант бота")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь открывает и закрывает консультант бота")
    public void checkCloseBot() {
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickCloseBot();
        mainPage.getBotConsultantButton().isElementDisplayed();

    }
}
