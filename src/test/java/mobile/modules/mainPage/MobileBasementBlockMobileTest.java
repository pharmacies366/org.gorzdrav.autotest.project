/*
package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@Feature(value = "Мобильная версия")
@Story("Проверка главной страницы сайта Gorzdrav")
@DisplayName("Проверка подвала сайта")
@Tag("Mobile")
@Tag("Regression")
public class MobileBasementBlockMobileTest extends BaseSettingsMobileTests {

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("helpTest")
    public void helpTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickHelpButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    private static Stream<Arguments> helpTest() {
        return Stream.of(
                //Помощь
                Arguments.of("/howtoorder/", "Как сделать заказ", "Как оформить заказ на сайте?"),
                Arguments.of("/apteki/map/", "Где получить заказ", "Работает сейчас"),
                Arguments.of("/faq/", "Вопрос-ответ", "Вопрос-ответ"),
                Arguments.of("/feedback/", "Задать вопрос", "Обратная связь"),
                Arguments.of("/delivery/", "Доставка", "Доставка"),
                Arguments.of("/oplata/", "Оплата", "Оплата"),
                Arguments.of("/refund/", "Обмен и возврат", "Правила обмена и возврата товара"),
                Arguments.of("/warranty/", "Гарантии", "Гарантии")
        );
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("serviceTest")
    public void serviceTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickServiceButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    private static Stream<Arguments> serviceTest() {
        return Stream.of(
                //Сервис
                Arguments.of("/ofertagorzdrav/", "Публичная оферта", "Публичная оферта"),
                Arguments.of("/personaldata/", "Политика конфиденциальности", "Политика конфиденциальности"),
                Arguments.of("/manufacturers/", "Производители", "Список лекарств по производителям"),
                Arguments.of("/partnersgz/", "Партнеры", "Партнеры"),
                Arguments.of("/mnn/", "Действующие вещества", "Действующие вещества"),
                Arguments.of("/shares/", "Акции", "Акции"),
                Arguments.of("/blog/", "Статьи", "Статьи"),
                Arguments.of("/news/", "Новости", "Новости")
        );
    }


    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("aboutCompanyTest")
    public void aboutCompanyTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickAboutCompanButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    private static Stream<Arguments> aboutCompanyTest() {
        return Stream.of(
                //О Компании
                Arguments.of("/aboutus/", "О нас", "О нас"),
                Arguments.of("/contacts/", "Контактные данные", "Контактные данные"),
                //Arguments.of("/feedback/", "Оставить отзыв", "Обратная связь"), находиться 2 элемента, уточнить почему?!
                Arguments.of("/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"),
                Arguments.of("/licenses/", "Лицензии", "Лицензии")
        );
    }

}
*/
