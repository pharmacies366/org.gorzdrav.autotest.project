package web.cft;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Михаил
 */

@Feature(value = "Web")
@Story("ЦФТ на сайте Горздрав")
@DisplayName("Проверка работы ЦФТ на главной странице сайта Горздрав")
@Tag("Regression")
@Tag("CFT")
public class CftOnMainPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов")
    @Description("Цвет заднего фона кнопки должен быть: #212121 - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        String actualColor = mainPage.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#1560bd", actualColor);
    }

    @DisplayName("Проверка фона текста кнопки с расчётом бонусов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        String actualColor = mainPage.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка, что на шильдике с количеством бонусов присутствует значок '+'")
    @Description("На шильдике с бонусами должен присутствовать знак '+'")
    @Test
    public void checkInfoProductGalleryBonus() {
        mainPage.checkPlusOnBonusButton();
    }

}
