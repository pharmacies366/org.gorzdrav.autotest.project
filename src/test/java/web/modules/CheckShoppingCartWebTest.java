package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature(value = "Web")
@Story(value = "Изменения корзины на сайте Gorzdrav")
public class CheckShoppingCartWebTest extends BaseSettingsWebTests {

    @Description("Проверка на увеличение шт. товара на странице корзины")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь увеличивает количество шт. товара на странице корзины")
    public void increaseQuantityMaterialOnCartPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickIncreaseQuantity();
        cartPage.getProductQuantity().waitingForElementNullOnThePage();
        int quantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @Description("Проверка на уменьшение шт. товара на странице корзины")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь уменьшает количество шт. товара на странице корзины")
    public void decreaseQuantityMaterialOnCartPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickIncreaseQuantity();
        cartPage.getProductQuantity().waitingForElementNullOnThePage();
        cartPage.getProductQuantity().contentIsDisplayed("2");
        int firstQuantity = cartPage.getQuantityMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        cartPage.clickDecreaseQuantity();
        cartPage.getProductQuantity().waitingForElementNullOnThePage();
        int secondQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @Description("Проверка на удалёние одного из товаров на странице корзины")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь удаляет 1 из 2-х товаров в корзине")
    public void deleteMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        pageActions.waitPageLoad();
        cartPage.clickDeleteMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(1, cartPage.checkCartQuantity());
    }

    @Description("Проверка на удалёние всех товаров на странице корзины")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь удаляет все товары в корзине")
    public void deleteAllMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        pageActions.waitPageLoad();
        cartPage.deleteAllMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(0, cartPage.checkCartQuantity());
    }

    @Description("Проверка на корректное сложение общей суммы товаров на странице корзины")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    public void checkTotalAmountProducts() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/64844");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        pageActions.waitPageLoad();
        double firstPrice = Double.parseDouble(cartPage.getProductPrice("1"));
        double secondPrice = Double.parseDouble(cartPage.getProductPrice("2"));
        int totalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }

    @Description("Проверка нотификации на странице корзины")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет нотификацию после удаления товара")
    public void checkNotificationCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        int firstPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        int secondPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        pageActions.waitPageLoad();
        int totalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
        cartPage.clickDeleteMaterials();
        Assert.assertEquals(1, cartPage.checkCartQuantity());
        int finalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice, finalPrice);
    }

    @Description("Проверка блока: Не забудьте положить в корзину")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: - Мини-карточки товаров в виде макета")
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = cartPage.checkTextDoNotAddToCart();
        Assert.assertEquals(text,"Не забудьте положить в корзину");
        int count = cartPage.checkDoNotAddToCartProductsList();
        Assert.assertTrue(count > 0);
    }

    @Description("Проверка на увеличение шт. товара на главной странице")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    public void increaseQuantityMaterialOnMainPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

    @Description("Проверка на уменьшение шт. товара на главной странице")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    public void decreaseQuantityMaterialOnMainPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mainPage.clickDecreaseQuantity();
        pageActions.waitPageLoad();
        int secondQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @Description("Проверка на увеличение шт. товара в карточке товара")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь увеличивает количество шт. товара в карточке товара")
    public void increaseQuantityMaterialOnProductCartPage() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        productCardPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        int quantity = productCardPage.getQuantityProduct();
        pageActions.waitPageLoad();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        pageActions.staticWait(2000);//из за проблем скорости работы сайта
        productCardPage.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }
    
}
