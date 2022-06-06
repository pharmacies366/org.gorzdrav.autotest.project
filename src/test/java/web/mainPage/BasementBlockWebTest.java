/*
package web.mainPage;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story("Проверка подвала сайта Gorzdrav")
@DisplayName("Проверка подвала сайта")
@RunWith(DataProviderRunner.class)
@Tag("Regression")
public class BasementBlockWebTest extends BaseSettingsWebTests {

    @DataProvider
    public static Object[][] basementLinks() {
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
                {"/licenses/", "Лицензии", "Лицензии"}
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINK_TEXT}")
    @Test
    @UseDataProvider("basementLinks")
    public void test(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        basementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        basementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

}
*/
