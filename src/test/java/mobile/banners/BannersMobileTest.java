package mobile.banners;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка работы банеров на сайте Gorzdrav")
public class BannersMobileTest extends BaseSettingsMobileTests {

// Нужно подумать над реализацией


   @Description("Пользователь проверяет прокрутку банеров вперед по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkNextBannerOnMainPage() {
        mobileMainPage.checkNextBannerList();
    }



   @Description("Пользователь проверяет прокрутку банеров назад по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkPrevBannerOnMainPage() {
        mobileMainPage.checkPrevBannerList();
    }

    @Description("Пользователь проверяет переход по банеру на главной странице")
    @Test
    public void checkBannersClickableOnMainPage() {
        mobileMainPage.checkBannersClickable();
    }

    @Description("Проверка перехода по банерау на странице OSP")
    @Test(groups = { "Mobile", "Regression" })
    @Step("переход по банерау на странице OSP")
    public void checkBannersClickableOnOspPage() {
        mobileMainPage.clickSiteLogo();
        pageActions.waitPageLoad();
        mobileMainPage.clickLetterN();
        pageActions.waitPageLoad();
        mobileOspPage.clickBanner();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @Description("Проверка перехода по банерау на странице товара")
    @Test(groups = { "Mobile", "Regression" })
    @Step("переход по банерау на странице товара")
    public void checkBannersClickableOnProductPage() {
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        mobileProductCardPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @Description("Проверка перехода по банерау на странице категории")
    @Test(groups = { "Mobile", "Regression" })
    @Step("переход по банерау на странице категории")
    public void checkBannersClickableOnCategoryPage() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickCatalogButton();
        mobileMainPopUpBlock.clickMedicationsButtons();
        mobileMedicationsCategoryPage.clickAllergyButton();
        mobileAllergyPage.checkAllergyPage();
        mobileAllergyPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @Description("Проверка перехода по банерау на странице поисковой выдачи")
    @Test(groups = { "Mobile", "Regression" })
    @Step("переход по банерау на странице поисковой выдачи")
    public void checkBannersClickableWithSearch() {
        mobileHeaderBlock.setSearchInput("Лекарства");
        mobileMedicationsPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @Description("Проверка перехода по банерау на странице корзины")
    @Test(groups = { "Mobile", "Regression" })
    @Step("переход по банерау на странице корзины")
    public void checkBannersClickableOnCartPage() {
        driver.get(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }
}
