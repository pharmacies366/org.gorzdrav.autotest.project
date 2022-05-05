package web.mainPage;

import base.BaseSettingsWebTests;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;

@Feature(value = "Web")
@Story("Проверка подвала сайта Gorzdrav")
@DisplayName("Проверка подвала сайта")
@RunWith(DataProviderRunner.class)
public class BasementBlockWebTest extends BaseSettingsWebTests {

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                //Помощь
                {"/howtoorder/", "Как сделать заказ", "Как оформить заказ на сайте?"},
                {"/apteki/map/", "Где получить заказ", "Работает сейчас"},
                {"/faq/", "Вопрос-ответ", "Вопрос-ответ"},
                {"/feedback/", "Задать вопрос", "Обратная связь"},
                {"/delivery/", "Доставка", "Доставка"},
                {"/oplata/", "Оплата", "Оплата"},
                {"/refund/", "Обмен и возврат", "Правила обмена и возврата товара"},
                {"/warranty/", "Гарантии", "Гарантии"},
                //Сервис
                {"/ofertagorzdrav/", "Публичная оферта", "Публичная оферта"},
                {"/personaldata/", "Политика конфиденциальности", "Политика конфиденциальности"},
                {"/manufacturers/", "Производители", "Список лекарств по производителям"},
                {"/partnersgz/", "Партнеры", "Партнеры"},
                {"/mnn/", "Действующие вещества", "Действующие вещества"},
                {"/shares/", "Акции", "Акции"},
                {"/blog/", "Статьи", "Статьи"},
                {"/news/", "Новости", "Новости"},
                //О Компании
                {"/aboutus/", "О нас", "О нас"},
                {"/contacts/", "Контактные данные", "Контактные данные"},
                {"/feedback/", "Оставить отзыв", "Обратная связь"},
                {"/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"},
                {"/licenses/", "Лицензии", "Лицензии"},
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINK_TEXT}")
    @Test
    @UseDataProvider("data")
    public void test(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mainPage.clickClosePopUp();
        basementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        basementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


}
