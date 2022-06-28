package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Страница товаров на сайте Gorzdrav")
@DisplayName("Страница товаров")
@Tag("Mobile")
@Tag("Regression")
public class ProductsPageMobileTest extends BaseSettingsMobileTests {

    //баг при установки цены
/*    @DisplayName("Пользователь проверяет изменения диапазона цены вручную")
    @Test
    public void checkChangePricesRangeWithHands() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCostButton();
        commonActionsOnMobilePages.changePricesRangeWithHands("100", "500");
        commonActionsOnMobilePages.clickFiltersButton();
        int FromPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int ToPriceRange = commonActionsOnMobilePages.getToPriceRange();
        int price = commonActionsOnMobilePages.checkProductsPrices();
        Assertions.assertTrue(price >= FromPriceRange);
        Assertions.assertTrue(price <= ToPriceRange);
    }*/

    @DisplayName("Пользователь выбирет чекбокс Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkProductsOnlyDelivery() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.deliveryAllowedButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
    }

// баг? после установки чекбокса, нельзя его снять
/*    @DisplayName("Пользователь снимает галочку с чекбокса Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkCancelCheckboxDelivery() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.deliveryAllowedButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.deliveryAllowedButton();
        commonActionsOnMobilePages.clickCloseCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedProductsWithAllMethods();
    }*/

/*    @DisplayName("Пользователь сбрасывает все выбранные чекбоксы и проверяет корректное изменение списка товаров")
    @Test
    public void checkCancelAllCheckboxes() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickResetCheckboxes();
        commonActionsOnMobilePages.checkSelectedProductsWithAllMethods();
    }*/


    @DisplayName("Пользователь проверяет коррекность работы пагинации страниц")
    @Test
    public void checkPagination() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickNextPage();
        commonActionsOnMobilePages.clickPrevPage();
    }


    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и выбранной формы выпуска")
    @Test
    public void checkReleaseForm() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickReleaseForm();
        commonActionsOnMobilePages.clickCheckbox("Ампулы");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assertions.assertEquals(titlePage, "Лекарства форма выпуска ампулы");

    }

    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и брендом")
    @Test
    public void checkBrand() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickBrand();
        commonActionsOnMobilePages.clickCheckbox("Доктор Мом");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assertions.assertEquals(titlePage, "Лекарства Доктор Мом");
    }

    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и производителями")
    @Test
    public void checkManufacturers() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickManufacturers();
        commonActionsOnMobilePages.clickCheckbox("Озон");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assertions.assertEquals(titlePage, "Лекарства от Озон");
    }

    @DisplayName("Пользователь проверяет корректную выдачу товаров по рецепту")
    @Test
    public void checkCheckboxWithRecipe() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.checkCheckboxWithRecipe();
        commonActionsOnMobilePages.clickSomeProducts();
        mobileProductCardPage.clickProductDetails();
        String recipeInfo = mobileProductCardPage.getRecipeInfo().getText();
        Assertions.assertEquals(recipeInfo, "По рецепту");
    }


    //пока не поправят баги
/*    @DisplayName("Пользователь проверяет сортировку выдачи товаров по уменьшению цены")
    @Test
    public void checkSortingPriceReduction() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceReductionOption();
        commonActionsOnMobilePages.checkSortingOption("по уменьшению цены");
        commonActionsOnMobilePages.checkSortingPriceReduction();
    }


    @DisplayName("Пользователь проверяет сортировку выдачи товаров по увеличению цены")
    @Test
    public void checkSortingPriceIncrease() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceIncreaseOption();
        commonActionsOnMobilePages.checkSortingOption("по увеличению цены");
        commonActionsOnMobilePages.checkSortingPriceIncrease();
    }

    @DisplayName("Пользователь проверяет сортировку выдачи товаров по названию")
    @Test
    public void checkSortingName() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickSortingNameOption();
        commonActionsOnMobilePages.checkSortingOption("по названию");
    }*/

}
