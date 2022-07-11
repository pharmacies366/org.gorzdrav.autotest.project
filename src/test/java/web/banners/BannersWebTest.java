package web.banners;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature(value = "Web")
@Story("Проверка работы банеров на сайте Gorzdrav")
public class BannersWebTest extends BaseSettingsWebTests {

    @Description("Проверка переключения банеров по стрелке вперёд и корректной роботы карусели")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет прокрутку банеров вперед по стрелке и возврат к первоначальному баннеру на главной странице")
    public void checkNextBannerOnMainPage() {
        mainPage.checkNextBannerList();
    }

    @Description("Проверка переключения банеров по стрелке назад и корректной роботы карусели")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет прокрутку банеров назад по стрелке и возврат к первоначальному баннеру на главной странице")
    public void checkPrevBannerOnMainPage() {
        mainPage.checkPrevBannerList();
    }

    @Description("Проверка смены банеров по пинам")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет смену банеров по пинам на главной странице")
    public void checkBannerButtonsOnMainPage() {
        mainPage.checkNextBannerButtons();
    }

    @Description("Проверка перехода по банерам на главной странице")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет переход по банерам на главной странице")
    public void checkBannersClickableOnMainPage() {
        mainPage.checkBannersClickable();
    }

    @Description("Проверка перехода по банерау на странице OSP")
    @Test(groups = {"Web", "Regression"})
    @Step("переход по банерау на странице OSP")
    public void checkBannersClickableOnOspPage() {
        mainPage.clickLetterN();
        ospPage.clickBanner();
        productCardPage.clickMainButton();
    }

    @Description("Проверка перехода по банерау на странице товара")
    @Test(groups = {"Web", "Regression"})
    @Step("переход по банерау на странице товара")
    public void checkBannersClickableOnProductPage() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        productCardPage.clickBanner();
        productCardPage.clickMainButton();
    }

    @Description("Проверка перехода по банерау на странице категории")
    @Test(groups = {"Web", "Regression"})
    @Step("переход по банерау на странице категории")
    public void checkBannersClickableOnCategoryPage() {
        mainPage.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickBanner();
        productCardPage.clickMainButton();
    }

    @Description("Проверка перехода по банерау на странице поисковой выдачи")
    @Test(groups = {"Web", "Regression"})
    @Step("переход по банерау на странице поисковой выдачи")
    public void checkBannersClickableWithSearch() {
        headerBlock.setSearchInput("Лекарства");
        commonActionsOnWebPages.clickBanner();
        productCardPage.clickMainButton();
    }

    @Description("Проверка перехода по банерау на странице корзины")
    @Test(groups = {"Web", "Regression"})
    @Step("переход по банерау на странице корзины")
    public void checkBannersClickableOnCartPage() {
        driver.get(propertiesManager.getProperty("baseurl") + "cart");
        cartPage.clickBanner();
        productCardPage.clickMainButton();
    }
}
