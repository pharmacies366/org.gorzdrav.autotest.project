package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Страница товаров на сайте Gorzdrav")
public class ProductsPageMobileTest extends BaseSettingsMobileTests {

    //баг при установки цены
/*      @Description("Проверка на корректное изменения ценавого диапазона вручную")
        @Test(groups = {"Mobile", "Regression"})
        @Step("Пользователь проверяет изменения диапазона цены вручную")
        public void checkChangePricesRangeWithHands() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCostButton();
        commonActionsOnMobilePages.changePricesRangeWithHands("100", "500");
        commonActionsOnMobilePages.clickFiltersButton();
        int FromPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int ToPriceRange = commonActionsOnMobilePages.getToPriceRange();
        int price = commonActionsOnMobilePages.checkProductsPrices();
        Assert.assertTrue(price >= FromPriceRange);
        Assert.assertTrue(price <= ToPriceRange);
    }*/

    @Description("Проверка на корректное применение чекбокса - Доставка")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь выбирет чекбокс Доставка и проверяет корректное изменение списка товаров")
    public void checkProductsOnlyDelivery() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.deliveryAllowedButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
    }

    // баг? после установки чекбокса, нельзя его снять
/*
    @Description("Проверка на корректную отмену чекбокса - Доставка")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь снимает галочку с чекбокса Доставка и проверяет корректное изменение списка товаров")
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
    }
*/

/*
    @Description("Проверка на корректную отмену всех чекбоксов")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь сбрасывает все выбранные чекбоксы и проверяет корректное изменение списка товаров")
    public void checkCancelAllCheckboxes() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickResetCheckboxes();
        commonActionsOnMobilePages.checkSelectedProductsWithAllMethods();
    }
*/


    @Description("Проверка пагинации страниц")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет коррекность работы пагинации страниц")
    public void checkPagination() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickNextPage();
        commonActionsOnMobilePages.clickPrevPage();
    }


    @Description("Проверка на корректную установку чекбокса - Форма выпуска")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет соотвествие между выдачей товаров и выбранной формы выпуска")
    public void checkReleaseForm() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickReleaseForm();
        commonActionsOnMobilePages.clickCheckbox("Ампулы");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства форма выпуска ампулы");

    }

    @Description("Проверка на корректную установку чекбокса - Бренд")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет соотвествие между выдачей товаров и брендом")
    public void checkBrand() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickBrand();
        commonActionsOnMobilePages.clickCheckbox("Доктор Мом");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства Доктор Мом");
    }

    @Description("Проверка на корректную установку чекбокса - Производители")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет соотвествие между выдачей товаров и производителями")
    public void checkManufacturers() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickManufacturers();
        commonActionsOnMobilePages.clickCheckbox("Озон");
        String titlePage = commonActionsOnMobilePages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства от Озон");
    }

    @Description("Проверка на корректную установку чекбокса - По рецепту")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет корректную выдачу товаров по рецепту")
    public void checkCheckboxWithRecipe() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.checkCheckboxWithRecipe();
        commonActionsOnMobilePages.clickSomeProducts();
        mobileProductCardPage.clickProductDetails();
        String recipeInfo = mobileProductCardPage.getRecipeInfo().getText();
        Assert.assertEquals(recipeInfo, "По рецепту");
    }


    //пока не поправят баги
/*    @Description("Проверка корректной сортировки по уменьшению цены")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет сортировку выдачи товаров по уменьшению цены")
    public void checkSortingPriceReduction() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceReductionOption();
        commonActionsOnMobilePages.checkSortingOption("по уменьшению цены");
        commonActionsOnMobilePages.checkSortingPriceReduction();
    }


    @Description("Проверка корректной сортировки по увеличению цены")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет сортировку выдачи товаров по увеличению цены")
    public void checkSortingPriceIncrease() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceIncreaseOption();
        commonActionsOnMobilePages.checkSortingOption("по увеличению цены");
        commonActionsOnMobilePages.checkSortingPriceIncrease();
    }

    @Description("Проверка корректной сортировки по названию")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет сортировку выдачи товаров по названию")
    public void checkSortingName() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickSortingNameOption();
        commonActionsOnMobilePages.checkSortingOption("по названию");
    }*/

}
