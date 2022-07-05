package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature(value = "Мобильная версия")
@Story(value = "Изменения корзины на сайте Gorzdrav")
public class CheckShoppingCartMobileTest extends BaseSettingsMobileTests {

    @Description("Проверка на увеличение шт. товара на странице корзины")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь увеличивает количество шт. товара на странице корзины")
    public void increaseQuantityMaterialOnCartPage() {
        mobileMainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickIncreaseQuantity();
        mobileCartPage.getIncreaseQuantity().waitingForElementNullOnThePage();
        int quantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @Description("Проверка на уменьшение шт. товара на странице корзины")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь уменьшает количество шт. товара на странице корзины")
    public void decreaseQuantityMaterialOnCartPage() {
        mobileMainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickIncreaseQuantity();
        mobileCartPage.getIncreaseQuantity().waitingForElementNullOnThePage();
        int firstQuantity = mobileCartPage.getQuantityMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileCartPage.clickDecreaseQuantity();
        mobileCartPage.getDecreaseQuantity().waitingForElementNullOnThePage();
        int secondQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        mobileHeaderBlock.clickToCartButton();
        pageActions.staticWait(1000);
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @Description("Проверка на удалёние одного из товаров на странице корзины")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь удаляет 1 из 2-х товаров в корзине")
    public void deleteMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.clickDeleteMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(1, mobileCartPage.checkCartQuantity());
    }

    @Description("Проверка на удалёние всех товаров на странице корзины")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь удаляет все товары в корзине")
    public void deleteAllMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.deleteAllMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(0, mobileCartPage.checkCartQuantity());
    }

    @Description("Проверка на корректное сложение общей суммы товаров на странице корзины")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    public void checkTotalAmountProducts() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        pageActions.waitPageLoad();
        int firstPrice = mobileProductCardPage.getProductPrice();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        int secondPrice = mobileProductCardPage.getProductPrice();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }

    @Description("Проверка нотификации на странице корзины")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет нотификацию после удаления товара")
    public void checkNotificationCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        int firstPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        int secondPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        pageActions.waitPageLoad();
        int totalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
        mobileCartPage.clickDeleteMaterials();
        Assert.assertEquals(1, mobileCartPage.checkCartQuantity());
        int finalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(secondPrice, finalPrice);
    }

    @Description("Проверка блока: Не забудьте положить в корзину")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: - Мини-карточки товаров в виде макета")
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = mobileCartPage.checkTextDoNotAddToCart();
        Assert.assertEquals(text, "Не забудьте положить в корзину");
        int count = mobileCartPage.checkDoNotAddToCartProductsList();
        Assert.assertTrue(count > 0);
    }

    @Description("Проверка на увеличение шт. товара на главной странице")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    public void increaseQuantityMaterialOnMobileMainPage() {
        mobileMainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mobileMainPage.clickIncreaseQuantity();
        int firstQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileHeaderBlock.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

    @Description("Проверка на уменьшение шт. товара на главной странице")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    public void decreaseQuantityMaterialOnMobileMainPage() {
        mobileMainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mobileMainPage.clickIncreaseQuantity();
        int firstQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileMainPage.clickDecreaseQuantity();
        int secondQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        mobileHeaderBlock.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @Description("Проверка на увеличение шт. товара в карточке товара")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь увеличивает количество шт. товара в карточке товара")
    public void increaseQuantityMaterialOnProductCartPage() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickIncreaseQuantity();
        int quantity = mobileProductCardPage.getQuantityProduct();
        pageActions.waitPageLoad();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        pageActions.staticWait(2000);//из за проблем скорости работы сайта
        mobileProductCardPage.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

}
