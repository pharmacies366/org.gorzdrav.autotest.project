package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка главной страницы сайта Gorzdrav")
public class MobileBasementBlockMobileTest extends BaseSettingsMobileTests {

    @Description("Проверка коррекного содержания ссылок в подвале сайта")
    @Test(dataProvider = "helpTest", groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет название ссылки, кликает по ней и проверяет содержание текста на странице")
    public void helpTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickHelpButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    @DataProvider(name = "helpTest")
    public Object[][] helpTest() {
        return new Object[][]{
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

    @Description("Проверка коррекного содержания ссылок в подвале сайта")
    @Test(dataProvider = "serviceTest", groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет название ссылки, кликает по ней и проверяет содержание текста на странице")
    public void serviceTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickServiceButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    @DataProvider(name = "serviceTest")
    public Object[][] serviceTest() {
        return new Object[][]{
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


    @Description("Проверка коррекного содержания ссылок в подвале сайта")
    @Test(dataProvider = "aboutCompanyTest", groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет название ссылки, кликает по ней и проверяет содержание текста на странице")
    public void aboutCompanyTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickAboutCompanButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    @DataProvider(name = "aboutCompanyTest")
    public Object[][] aboutCompanyTest() {
        return new Object[][]{
                {"/aboutus/", "О нас", "О нас"},
                {"/contacts/", "Контактные данные", "Контактные данные"},
                //{"/feedback/", "Оставить отзыв", "Обратная связь"}, находиться 2элемента, уточнить почему ? !
                {"/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"},
                {"/licenses/", "Лицензии", "Лицензии"}
        };

    }
}
