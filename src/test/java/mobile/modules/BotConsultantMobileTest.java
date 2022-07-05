package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Консультант бот на сайте Gorzdrav")
public class  BotConsultantMobileTest extends BaseSettingsMobileTests {

    @Description("Проверка пункта: Не могу оформить заказ")
    @Test(groups = { "Mobile", "Regression" })
    @Step("Пользователь заполняет свои данные и получает ответ от бота")
    public void checkItemCanNotCheckout() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickCantNotOrder();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @Description("Проверка пункта: Мне нужен препарат")
    @Test(groups = { "Mobile", "Regression" })
    @Step("Пользователь заполняет свои данные и получает ответ от бота")
    public void checkItemINeedADrug() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickNeedADrug();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @Description("Проверка пункта: Нужна доставка")
    @Test(groups = { "Mobile", "Regression" })
    @Step("Пользователь заполняет свои данные и получает ответ от бота")
    public void checkItemINeedDelivery() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickNeedDelivery();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @Description("Проверка закрытия консультант бота")
    @Test(groups = { "Mobile", "Regression" })
    @Step("Пользователь открывает и закрывает консультант бота")
    public void checkCloseBot() {
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickCloseBot();
        mobileMainPage.getBotConsultantButton().isElementDisplayed();
    }
}
