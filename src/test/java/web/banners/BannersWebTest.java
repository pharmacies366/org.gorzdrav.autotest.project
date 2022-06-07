package web.banners;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story("Проверка работы банеров на сайте Gorzdrav")
@DisplayName("Проверка работы банеров на сайте")
@Tag("Regression")
public class BannersWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь проверяет прокрутку банеров вперед по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkNextBannerOnMainPage() {
        mainPage.checkNextBannerList();
    }

    @DisplayName("Пользователь проверяет прокрутку банеров назад по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkPrevBannerOnMainPage() {
        mainPage.checkPrevBannerList();
    }

    @DisplayName("Пользователь проверяет смену банеров по пинам на главной странице")
    @Test
    public void checkBannerButtonsOnMainPage() {
        mainPage.checkNextBannerButtons();
    }

/*    @DisplayName("Пользователь проверяет переход по банерам на главной странице")
    @Test
    public void checkBannersClickableOnMainPage() {
        mainPage.checkBannersClickable();
    }*/

    @DisplayName("Пользователь проверяет переход по банерау на странице OSP")
    @Test
    public void checkBannersClickableOnOspPage() {
        mainPage.clickLetterN();
        ospPage.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице товара")
    @Test
    public void checkBannersClickableOnProductPage() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        productCardPage.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице категории")
    @Test
    public void checkBannersClickableOnCategoryPage() {
        mainPage.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банеру на странице поисковой выдачи")
    @Test
    public void checkBannersClickableWithSearch() {
        headerBlock.setSearchInput("Лекарства");
        commonActionsOnWebPages.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банеру на странице корзины")
    @Test
    public void checkBannersClickableOnCartPage() {
        driver.get(propertiesManager.getProperty("baseurl") + "cart");
        cartPage.clickBanner();
        productCardPage.clickMainButton();
    }
}
