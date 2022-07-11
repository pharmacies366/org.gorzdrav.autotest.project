/*
package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Изменение региональности на сайте Gorzdrav")
public class CheckRegionalMobileTest extends BaseSettingsMobileTests {

    // После правки багов

    @Description("Проверка выбора города Санкт-Петербург")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь устанавливает город Санкт-Петербург")
    public void checkChangeRegionOnMainPage() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionSpb();
        mobileCitiesPopUpPage.selectSpbCity();
        mobileHeaderBlock.clickBurgerButton();
        mobileHeaderBlock.checkSelectedRegion("Санкт-Петербург");
    }

    @Description("Проверка смены города город Санкт-Петербург на Москву")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь устанавливает город Санкт-Петербург, а затем меняет его на Москва")
    public void checkRevertRegionOnMainPage() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionSpb();
        mobileCitiesPopUpPage.selectSpbCity();
        mobileHeaderBlock.clickBurgerButton();
        mobileHeaderBlock.checkSelectedRegion("Санкт-Петербург");
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionMsk();
        mobileCitiesPopUpPage.selectMskCity();
        mobileHeaderBlock.clickBurgerButton();
        mobileHeaderBlock.checkSelectedRegion("Москва");
    }

    @Description("Проверка выбранного города на станице товара")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет установленный город на станице товара")
    public void checkChangeRegionOnProductPage() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionSpb();
        mobileCitiesPopUpPage.selectSpbCity();
        mobileMainPage.clickFirstProductOnMainPage();
        mobileProductCardPage.checkSelectedRegion("Санкт-Петербург");
    }
}*/
