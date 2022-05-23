package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Изменения корзины на сайте Gorzdrav")
@DisplayName("Изменения корзины")
public class CheckShoppingCartWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь увеличивает количество шт. товара на странице корзины")
    @Test
    public void increaseQuantityMaterialOnCartPage() {
        mainPage.clickClosePopUp();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickIncreaseQuantity();
        pageActions.staticWait(3000);
        int quantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара на странице корзины")
    @Test
    public void decreaseQuantityMaterialOnCartPage() {
        mainPage.clickClosePopUp();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickIncreaseQuantity();
        cartPage.getProductQuantity().contentIsDisplayed("2");
        int firstQuantity = cartPage.getQuantityMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        cartPage.clickDecreaseQuantity();
        pageActions.staticWait(4000);
        int secondQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @DisplayName("Пользователь удаляет 1 из 2-х товаров в корзине")
    @Test
    public void deleteMaterialsFromCart() {
        mainPage.clickClosePopUp();
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

    @DisplayName("Пользователь удаляет все товары в корзине")
    @Test
    public void deleteAllMaterialsFromCart() {
        mainPage.clickClosePopUp();
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

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void checkTotalAmountProducts() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        pageActions.waitPageLoad();
        int firstPrice = productCardPage.getProductPrice();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        int secondPrice = productCardPage.getProductPrice();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }

    @DisplayName("Пользователь проверяет нотификацию после удаления товара")
    @Test
    public void checkNotificationCart() {
        mainPage.clickClosePopUp();
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

    @DisplayName("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: - Мини-карточки товаров в виде макета")
    @Test
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = cartPage.checkTextDoNotAddToCart();
        Assert.assertEquals(text,"Не забудьте положить в корзину");
        int count = cartPage.checkDoNotAddToCartProductsList();
        Assert.assertTrue(count > 0);
    }

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    @Test
    public void increaseQuantityMaterialOnMainPage() {
        mainPage.clickClosePopUp();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    @Test
    public void decreaseQuantityMaterialOnMainPage() {
        mainPage.clickClosePopUp();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mainPage.clickDecreaseQuantity();
        int secondQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

/*    @DisplayName("Пользователь увеличивает количество шт. товара в карточке товара")
    @Test
    public void increaseQuantityMaterialOnProductCartPage() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        productCardPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        pageActions.staticWait(3000);
        int quantity = productCardPage.getQuantityProduct();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        productCardPage.clickToCartButton();
        pageActions.waitPageLoad();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }*/
    
}
