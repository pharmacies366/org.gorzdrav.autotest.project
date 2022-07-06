package web.cft;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * @author Михаил
 */

@Feature(value = "Web")
@Story("Проверка работы ЦФТ в карточке товаров сайта Горздрав")
public class CftOnCardProductPageWebTest extends BaseSettingsWebTests {

    @Description("Проверка цвета надписи по информации о начисляемых бонусах")
    @Test(groups = {"Web", "Regression", "CFT"})
    @Step("Цвет надписи должен быть: #1560bd - Синий")
    public void checkBackgroundColorProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.getColorBackgroundProductGalleryButton();
        Assert.assertEquals("#1560bd", actualColor);
    }

    @Description("Проверка, что на надписи по информации о начисляемых бонусах присутствует значок '+' для главного товара в карточке товара")
    @Test(groups = {"Web", "Regression", "CFT"})
    @Step("В тексте должен присутствовать знак '+'")
    public void checkInfoOnMainProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.checkPlusOnMainProductAboutBonuses();
    }

    @Description("Проверка цвета текста на табличке с расчётом бонусов для товаров - аналогов")
    @Test(groups = {"Web", "Regression", "CFT"})
    @Step("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    public void checkColorTextProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.getColorTextProductGalleryButton();
        Assert.assertEquals("#ffffff", actualColor);
    }

    @Description("Проверка, что на шильдике с количеством бонусов присутствует значок '+' для товаров - аналогов")
    @Test(groups = {"Web", "Regression", "CFT"})
    @Step("На шильдике с бонусами должен присутствовать знак '+'")
    public void checkInfoProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.checkPlusOnBonusButton();
    }

    @Description("Проверка окончаний в зависимости от количество начисляемых бонусов")
    @Test(dataProvider = "checkCorrectEnding", groups = {"Web", "Regression"})
    public void checkCorrectEnding(String PRODUCT, String BONUS_MESSAGE) {
        openUrl(propertiesManager.getProperty("baseurl") + PRODUCT);
        assertThat(productCardPage.getPlusOnMainProductAboutBonuses().getText(), containsString(BONUS_MESSAGE));
    }

    @DataProvider(name = "checkCorrectEnding")
    public Object[][] checkCorrectEnding() {
        return new Object[][]{
                {"p/211533", "1 бонус"},
                {"p/300733", "2 бонуса"},
                {"p/206671", "10 бонусов"},
        };
    }
}
