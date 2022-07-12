package web.mainPage;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature(value = "Web")
@Story("Проверка подвала сайта Gorzdrav")
public class BasementBlockWebTest extends BaseSettingsWebTests {

    @Description("Проверка коррекного содержания ссылок в подвале сайта")
    @Test(dataProvider = "testLinksInBasement", groups = {"Web", "Regression"})
    @Step("Пользователь проверяет название ссылки, кликает по ней и проверяет содержание текста на странице")
    public void testLinksInBasement(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        basementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        basementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
    }

    @DataProvider(name = "testLinksInBasement")
    public Object[][] testLinksInBasement() {
        return new Object[][]{
                {"/howtoorder/", "Как сделать заказ", "Как оформить заказ на сайте?"},
                {"/apteki/map/", "Где получить заказ", "Работает сейчас"},
                {"/faq/", "Вопрос-ответ", "Вопрос-ответ"},
                {"/feedback/", "Задать вопрос", "Обратная связь"},
                {"/delivery/", "Доставка", "Доставка"},
                {"/oplata/", "Оплата", "Оплата"},
                {"/refund/", "Обмен и возврат", "Правила обмена и возврата товара"},
                {"/warranty/", "Гарантии", "Гарантии"},
                {"/ofertagorzdrav/", "Публичная оферта", "Публичная оферта"},
                {"/personaldata/", "Политика конфиденциальности", "Политика конфиденциальности"},
                {"/manufacturers/", "Производители", "Список лекарств по производителям"},
                {"/partnersgz/", "Партнеры", "Партнеры"},
                {"/mnn/", "Действующие вещества", "Действующие вещества"},
                {"/shares/", "Акции", "Акции"},
                {"/blog/", "Статьи", "Статьи"},
                {"/news/", "Новости", "Новости"},
                {"/aboutus/", "О нас", "О нас"},
                {"/contacts/", "Контактные данные", "Контактные данные"},
                {"/feedback/", "Оставить отзыв", "Обратная связь"},
                {"/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"},
                {"/licenses/", "Лицензии", "Лицензии"}
        };
    }
}
