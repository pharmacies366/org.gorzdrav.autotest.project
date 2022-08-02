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

    private static String baseUrl = "https://gorzdrav.org";

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkBasementLinks")
    public void testSomething(String LOCATOR, String LINK_TEXT, String PAGE_URL) {
        basementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        basementBlock.selectBasementButtons(LOCATOR);
        pageActions.checkUrl(PAGE_URL);
    }

    private static Stream<Arguments> checkBasementLinks() {
        return Stream.of(
                Arguments.of("/howtoorder/", "Как сделать заказ", baseUrl + "/howtoorder/"),
                Arguments.of("/apteki/map/", "Где получить заказ", baseUrl + "/apteki/map/"),
                Arguments.of("/faq/", "Вопрос-ответ", baseUrl + "/faq/"),
                Arguments.of("/feedback/", "Задать вопрос", baseUrl + "/feedback/"),
                Arguments.of("/delivery/", "Доставка", baseUrl + "/delivery/"),
                Arguments.of("/oplata/", "Оплата", baseUrl + "/oplata/"),
                Arguments.of("/refund/", "Обмен и возврат", baseUrl + "/refund/"),
                Arguments.of("/warranty/", "Гарантии", baseUrl + "/warranty/"),
                Arguments.of("/ofertagorzdrav/", "Публичная оферта", baseUrl + "/ofertagorzdrav/"),
                Arguments.of("/personaldata/", "Политика конфиденциальности", baseUrl + "/personaldata/"),
                Arguments.of("/manufacturers/", "Производители", baseUrl + "/manufacturers/"),
                Arguments.of("/partnersgz/", "Партнеры", baseUrl + "/partnersgz/"),
                Arguments.of("/mnn/", "Действующие вещества", baseUrl + "/mnn/"),
                Arguments.of("/shares/", "Акции", baseUrl + "/promotions/"),
                Arguments.of("/blog/", "Статьи", baseUrl + "/blog/"),
                Arguments.of("/news/", "Новости", baseUrl + "/news/"),
                Arguments.of("/aboutus/", "О нас", baseUrl + "/aboutus/"),
                Arguments.of("/contacts/", "Контактные данные", baseUrl + "/contacts/"),
                Arguments.of("/feedback/", "Оставить отзыв", baseUrl + "/feedback/"),
                Arguments.of("/advertisingplacement/", "Размещение рекламы", baseUrl + "/advertisingplacement/"),
                Arguments.of("/licenses/", "Лицензии", baseUrl + "/licenses/")
        );
    }

}
