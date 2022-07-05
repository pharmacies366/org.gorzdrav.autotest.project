package mobile.cft;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Михаил
 */

@Feature(value = "Мобильная версия")
@Story("Проверка работы ЦФТ в карточке товаров сайта Горздрав")
public class CftOnCardProductPageMobileTest extends BaseSettingsMobileTests {

    @Description("Проверка цвета надписи по информации о начисляемых бонусах")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("Цвет надписи должен быть: #1560bd - Синий")
    public void checkBackgroundColorProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = mobileProductCardPage.getColorBackgroundProductGalleryButton();
        Assert.assertEquals("#1560bd", actualColor);
    }

    @Description("Проверка, что на надписи по информации о начисляемых бонусах присутствует значок '+' для главного товара в карточке товара")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("В тексте должен присутствовать знак '+'")
    public void checkInfoOnMainProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        mobileProductCardPage.checkPlusOnMainProductAboutBonuses();
    }

    @Description("Проверка цвета текста на табличке с расчётом бонусов для товаров - аналогов")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    public void checkColorTextProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = mobileProductCardPage.getColorTextProductGalleryButton();
        Assert.assertEquals("#ffffff", actualColor);
    }

    @Description("Проверка, что на шильдике с количеством бонусов присутствует значок '+' для товаров - аналогов")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("На шильдике с бонусами должен присутствовать знак '+'")
    public void checkInfoProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        mobileProductCardPage.checkPlusOnBonusButton();
    }

/*    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkCorrectEnding")
    public void testSomething(String PRODUCT, String BONUS_MESSAGE) {
        openUrl(propertiesManager.getProperty("baseurl") + PRODUCT);
        assertThat(mobileProductCardPage.getPlusOnMainProductAboutBonuses().getText(), containsString(BONUS_MESSAGE));
    }

    private static Stream<Arguments> checkCorrectEnding() {
        return Stream.of(
                Arguments.of("p/44995", "1 бонус"),
                Arguments.of("p/54898", "2 бонуса"),
                Arguments.of("p/300209", "10 бонусов")
        );
    }*/

}
