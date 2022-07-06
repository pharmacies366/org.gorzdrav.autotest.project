package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Web")
@Story(value = "Изменение региональности на сайте Gorzdrav")
public class CheckRegionalWebTest extends BaseSettingsWebTests {

    @Description("Проверка выбора города Санкт-Петербург")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь устанавливает город Санкт-Петербург")
    public void checkChangeRegionOnMainPage() {
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectSpbCity();
        headerBlock.checkSelectedRegion("Санкт-Петербург и ЛО");
    }

    @Description("Проверка смены города город Санкт-Петербург на Москву")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь устанавливает город Санкт-Петербург, а затем меняет его на Москва")
    public void checkRevertRegionOnMainPage() {
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectSpbCity();
        headerBlock.checkSelectedRegion("Санкт-Петербург и ЛО");
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectMskCity();
        headerBlock.checkSelectedRegion("Москва и МО");
    }

    @Description("Проверка выбранного города на станице товара")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет установленный город на станице товара")
    public void checkChangeRegionOnProductPage() {
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectSpbCity();
        headerBlock.checkSelectedRegion("Санкт-Петербург и ЛО");
        pageActions.waitPageLoad();
        mainPage.clickFirstProductOnMainPage();
        pageActions.waitPageLoad();
        productCardPage.checkSelectedRegion("Санкт-Петербург");
    }
}
