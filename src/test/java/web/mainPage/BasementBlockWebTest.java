package web.mainPage;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Feature(value = "Web")
@Story("Проверка подвала сайта Gorzdrav")
@DisplayName("Проверка подвала сайта")
@Tag("Web")
@Tag("Regression")
public class BasementBlockWebTest extends BaseSettingsWebTests {

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkBasementLinks")
    public void testSomething(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        basementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        basementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
    }

    private static Stream<Arguments> checkBasementLinks() {
        return Stream.of(
                Arguments.of("/howtoorder/", "Как сделать заказ", "Как оформить заказ на сайте?"),
                Arguments.of("/apteki/map/", "Где получить заказ", "Работает сейчас"),
                Arguments.of("/faq/", "Вопрос-ответ", "Вопрос-ответ"),
                Arguments.of("/feedback/", "Задать вопрос", "Обратная связь"),
                Arguments.of("/delivery/", "Доставка", "Доставка"),
                //Arguments.of("/oplata/", "Оплата", "Оплата"),
                //Arguments.of("/refund/", "Обмен и возврат", "Правила обмена и возврата товара"),
                //Arguments.of("/warranty/", "Гарантии", "Гарантии"),
                Arguments.of("/ofertagorzdrav/", "Публичная оферта", "Публичная оферта"),
                Arguments.of("/personaldata/", "Политика конфиденциальности", "Политика конфиденциальности"),
                Arguments.of("/manufacturers/", "Производители", "Список лекарств по производителям"),
                Arguments.of("/partnersgz/", "Партнеры", "Партнеры"),
                Arguments.of("/mnn/", "Действующие вещества", "Лекарства по действующему веществу (МНН)"),
                Arguments.of("/shares/", "Акции", "Акции"),
                Arguments.of("/blog/", "Статьи", "Статьи"),
                Arguments.of("/news/", "Новости", "Новости"),
                Arguments.of("/aboutus/", "О нас", "О нас"),
                Arguments.of("/contacts/", "Контактные данные", "Контактные данные"),
                Arguments.of("/feedback/", "Оставить отзыв", "Обратная связь"),
                Arguments.of("/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"),
                Arguments.of("/licenses/", "Лицензии", "Лицензии")
        );
    }

}
