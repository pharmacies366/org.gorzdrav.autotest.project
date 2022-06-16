/*
package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story("Проверка главной страницы сайта Gorzdrav")
@DisplayName("Проверка подвала сайта")
@RunWith(DataProviderRunner.class)
@Tag("Mobile")
@Tag("Regression")
public class MobileBasementBlockMobileTest extends BaseSettingsMobileTests {

    @DataProvider
    public static Object[][] help() {
        return new Object[][]{
                //Помощь
                {"/howtoorder/", "Как сделать заказ", "Как оформить заказ на сайте?"},
                {"/apteki/map/", "Где получить заказ", "Работает сейчас"},
                {"/faq/", "Вопрос-ответ", "Вопрос-ответ"},
                {"/feedback/", "Задать вопрос", "Обратная связь"},
                {"/delivery/", "Доставка", "Доставка"},
                {"/oplata/", "Оплата", "Оплата"},
                {"/refund/", "Обмен и возврат", "Правила обмена и возврата товара"},
                {"/warranty/", "Гарантии", "Гарантии"}
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("help")
    public void helpTest(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        mobileBasementBlock.clickHelpButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    @DataProvider
    public static Object[][] Service() {
        return new Object[][]{
                //Сервис
                {"/ofertagorzdrav/", "Публичная оферта", "Публичная оферта"},
                {"/personaldata/", "Политика конфиденциальности", "Политика конфиденциальности"},
                {"/manufacturers/", "Производители", "Список лекарств по производителям"},
                {"/partnersgz/", "Партнеры", "Партнеры"},
                {"/mnn/", "Действующие вещества", "Действующие вещества"},
                {"/shares/", "Акции", "Акции"},
                {"/blog/", "Статьи", "Статьи"},
                {"/news/", "Новости", "Новости"}
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("Service")
    public void serviceTest(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        pageActions.waitPageLoad();
        mobileBasementBlock.clickServiceButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    @DataProvider
    public static Object[][] aboutCompany() {
        return new Object[][]{
                //О Компании
                {"/aboutus/", "О нас", "О нас"},
                {"/contacts/", "Контактные данные", "Контактные данные"},
              //  {"/feedback/", "Оставить отзыв", "Обратная связь"},
                {"/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"},
                {"/licenses/", "Лицензии", "Лицензии"}
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("aboutCompany")
    public void aboutCompanyTest(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        mobileBasementBlock.clickAboutCompanButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

}
*/
