package web.cft;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * @author Михаил
 */

@Feature(value = "Web")
@DisplayName("ЦФТ на сайте Горздрав")
@Story("Проверка работы ЦФТ в карточке товаров сайта Горздрав")
@Tag("Web")
@Tag("Regression")
@Tag("CFT")
public class CftOnCardProductPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка цвета надписи по информации о начисляемых бонусах")
    @Description("Цвет надписи должен быть: #1560bd - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#1560bd", actualColor);
    }

    @DisplayName("Проверка, что на надписи по информации о начисляемых бонусах присутствует значок '+' для главного товара в карточке товара")
    @Description("В тексте должен присутствовать знак '+'")
    @Test
    public void checkInfoOnMainProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.checkPlusOnMainProductAboutBonuses();
    }

    @DisplayName("Проверка цвета текста на табличке с расчётом бонусов для товаров - аналогов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка, что на шильдике с количеством бонусов присутствует значок '+' для товаров - аналогов")
    @Description("На шильдике с бонусами должен присутствовать знак '+'")
    @Test
    public void checkInfoProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.checkPlusOnBonusButton();
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkCorrectEnding")
    public void testSomething(String PRODUCT, String BONUS_MESSAGE) {
        openUrl(propertiesManager.getProperty("baseurl") + PRODUCT);
        assertThat(productCardPage.getPlusOnMainProductAboutBonuses().getText(), containsString(BONUS_MESSAGE));
    }

    private static Stream<Arguments> checkCorrectEnding() {
        return Stream.of(
                Arguments.of("p/211533", "1 бонус"),
                Arguments.of("p/300733", "2 бонуса"),
                Arguments.of("p/206671", "10 бонусов")
        );
    }

}
