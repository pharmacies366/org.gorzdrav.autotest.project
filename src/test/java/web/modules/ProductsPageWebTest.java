package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature(value = "Web")
@Story(value = "Страница товаров на сайте Gorzdrav")
public class ProductsPageWebTest extends BaseSettingsWebTests {

/*//съезжает массив с ценами
   @Description("Проверка на корректное изменения ценавого диапазона вручную")
        @Test(groups = {"Web", "Regression"})
        @Step("Пользователь проверяет изменения диапазона цены вручную")
    public void checkChangePricesRangeWithHands() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.changePricesRangeWithHands("100", "500");
        pageActions.waitPageLoad();
        int ToPriceRange = commonActionsOnWebPages.getToPriceRange();
        int FromPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int price = commonActionsOnWebPages.checkProductsPrices();
        Assert.assertTrue(price >= FromPriceRange);
        Assert.assertTrue(price <= ToPriceRange);
    }
*/

    @Description("Проверка на корректное применение чекбокса - Доставка")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь выбирет чекбокс Доставка и проверяет корректное изменение списка товаров")
    public void checkProductsOnlyDelivery() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedCheckbox("Доставка");
        commonActionsOnWebPages.checkSelectedProductsWithDeliveryMethod();
    }

    @Description("Проверка на корректную отмену чекбокса - Доставка")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь снимает галочку с чекбокса Доставка и проверяет корректное изменение списка товаров")
    public void checkCancelCheckboxDelivery() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedCheckbox("Доставка");
        commonActionsOnWebPages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnWebPages.clickCloseCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedProductsWithAllMethods();
    }

    @Description("Проверка на корректную отмену всех чекбоксов")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь сбрасывает все выбранные чекбоксы и проверяет корректное изменение списка товаров")
    public void checkCancelAllCheckboxes() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedCheckbox("Доставка");
        commonActionsOnWebPages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnWebPages.clickResetCheckboxes();
        commonActionsOnWebPages.checkSelectedProductsWithAllMethods();
    }

    @Description("Проверка пагинации страниц")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет коррекность работы пагинации страниц")
    public void checkPagination() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickNextPage();
        commonActionsOnWebPages.clickPrevPage();
    }

    //Нужно дописать тесты

/*    @Description("Проверка на корректную установку чекбокса - Форма выпуска")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет соотвествие между выдачей товаров и выбранной формы выпуска")
    public void checkReleaseForm() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnWebPages.clickFiltersButton();
        commonActionsOnWebPages.clickReleaseForm();
        commonActionsOnWebPages.clickCheckbox("Ампулы");
        String titlePage = commonActionsOnWebPages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства форма выпуска ампулы");

    }

    @Description("Проверка на корректную установку чекбокса - Бренд")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет соотвествие между выдачей товаров и брендом")
    public void checkBrand() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnWebPages.clickFiltersButton();
        commonActionsOnWebPages.clickBrand();
        commonActionsOnWebPages.clickCheckbox("Доктор Мом");
        String titlePage = commonActionsOnWebPages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства Доктор Мом");
    }

    @Description("Проверка на корректную установку чекбокса - Производители")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет соотвествие между выдачей товаров и производителями")
    public void checkManufacturers() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnWebPages.clickFiltersButton();
        commonActionsOnWebPages.clickManufacturers();
        commonActionsOnWebPages.clickCheckbox("Озон");
        String titlePage = commonActionsOnWebPages.checkPageTitle();
        Assert.assertEquals(titlePage, "Лекарства от Озон");
    }*/

    @Description("Проверка на корректную установку чекбокса - По рецепту")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет корректную выдачу товаров по рецепту")
    public void checkCheckboxWithRecipe() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.checkCheckboxWithRecipe();
        String recipeInfo = productCardPage.getRecipeInfo().getText();
        Assert.assertEquals(recipeInfo, "По рецепту");
    }

/*
   @Description("Проверка корректной сортировки по уменьшению цены")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет сортировку выдачи товаров по уменьшению цены")
    public void checkSortingPriceReduction() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickSortingButton();
        commonActionsOnWebPages.clickPriceReductionOption();
        commonActionsOnWebPages.checkSortingOption("по уменьшению цены");
        commonActionsOnWebPages.checkSortingPriceReduction();
    }


     @Description("Проверка корректной сортировки по увеличению цены")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет сортировку выдачи товаров по увеличению цены")
    public void checkSortingPriceIncrease() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickSortingButton();
        commonActionsOnWebPages.clickPriceIncreaseOption();
        commonActionsOnWebPages.checkSortingOption("по увеличению цены");
        commonActionsOnWebPages.checkSortingPriceIncrease();
    }

  @Description("Проверка корректной сортировки по названию")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет сортировку выдачи товаров по названию")
    public void checkSortingName() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        pageActions.waitPageLoad();
        commonActionsOnWebPages.clickSortingButton();
        commonActionsOnWebPages.clickSortingNameOption();
        commonActionsOnWebPages.checkSortingOption("по названию");
    }*/


}
