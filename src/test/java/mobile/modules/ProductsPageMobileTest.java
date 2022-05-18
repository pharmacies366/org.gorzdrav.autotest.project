package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Страница товаров на сайте Gorzdrav")
@DisplayName("Страница товаров")
public class ProductsPageMobileTest extends BaseSettingsMobileTests {

    //баг при установки цены
/*    @DisplayName("Пользователь проверяет изменения диапазона цены вручную")
    @Test
    public void checkChangePricesRangeWithHands() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCostButton();
        commonActionsOnMobilePages.changePricesRangeWithHands("100", "500");
        commonActionsOnMobilePages.clickFiltersButton();
        int ToPriceRange = commonActionsOnMobilePages.getToPriceRange();
        int FromPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int price = commonActionsOnMobilePages.checkProductsPrices();
        Assert.assertTrue(price >= FromPriceRange);
        Assert.assertTrue(price <= ToPriceRange);
    }*/

    @DisplayName("Пользователь выбирет чекбокс Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkProductsOnlyDelivery() {
        // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
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
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
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
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
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
        // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickNextPage();
        commonActionsOnMobilePages.clickPrevPage();
    }


    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и выбранной формы выпуска")
    @Test
    public void checkReleaseForm() {
        //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickReleaseForm();
        commonActionsOnMobilePages.clickCheckbox("Ампулы");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства форма выпуска ампулы");

    }

    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и брендом")
    @Test
    public void checkBrand() {
        //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickBrand();
        commonActionsOnMobilePages.clickCheckbox("Доктор Мом");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства Доктор Мом");
    }

    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и производителями")
    @Test
    public void checkManufacturers() {
        //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickManufacturers();
        commonActionsOnMobilePages.clickCheckbox("Озон");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства от Озон");
    }

    @DisplayName("Пользователь проверяет корректную выдачу товаров по рецепту")
    @Test
    public void checkCheckboxWithRecipe() {
        // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.checkCheckboxWithRecipe();
        String recipeInfo = mobileProductCardPage.getRecipeInfo().getText();
        Assert.assertEquals(recipeInfo, "По рецепту");
    }

    @DisplayName("Пользователь проверяет корректную выдачу товаров без рецепта")
    @Test
    public void checkCheckboxWithoutRecipe() {
        // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.checkCheckboxWithoutRecipe();
        String recipeInfo = mobileProductCardPage.getRecipeInfo().getText();
        Assert.assertEquals(recipeInfo, "Без рецепта");
    }

    @DisplayName("Пользователь проверяет сортировку выдачи товаров по уменьшению цены")
    @Test
    public void checkSortingPriceReduction() {
        // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceReductionOption();
        commonActionsOnMobilePages.checkSortingOption("по уменьшению цены");
        commonActionsOnMobilePages.checkSortingPriceReduction();
    }


    @DisplayName("Пользователь проверяет сортировку выдачи товаров по увеличению цены")
    @Test
    public void checkSortingPriceIncrease() {
        // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceIncreaseOption();
        commonActionsOnMobilePages.checkSortingOption("по увеличению цены");
        commonActionsOnMobilePages.checkSortingPriceIncrease();
    }

    @DisplayName("Пользователь проверяет сортировку выдачи товаров по названию")
    @Test
    public void checkSortingName() {
        //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickSortingNameOption();
        commonActionsOnMobilePages.checkSortingOption("по названию");
    }

}
