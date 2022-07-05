package mobile.cft;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature(value = "Мобильная версия")
@Story("ЦФТ на сайте Горздрав")
public class CftOnMainPageMobileTest extends BaseSettingsMobileTests {
    @Description("Проверка заднего фона кнопки с расчётом бонусов")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("Цвет заднего фона кнопки должен быть: #212121 - Синий")
    public void checkBackgroundColorProductGalleryBonus() {
        String actualColor = mobileMainPage.getColorBackgroundProductGalleryButton();
        Assert.assertEquals("#1560bd", actualColor);
    }

    @Description("Проверка фона текста кнопки с расчётом бонусов")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    public void checkColorTextProductGalleryBonus() {
        String actualColor = mobileMainPage.getColorTextProductGalleryButton();
        Assert.assertEquals("#ffffff", actualColor);
    }

    @Description("Проверка, что на шильдике с количеством бонусов присутствует значок '+'")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("На шильдике с бонусами должен присутствовать знак '+'")
    public void checkInfoProductGalleryBonus() {
        mobileMainPage.checkPlusOnBonusButton();
    }
}
