package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story(value = "Изменения корзины на сайте Gorzdrav")
@DisplayName("Изменения корзины")
@Tag("Regression")
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
        Assertions.assertEquals(2, quantity);
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
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        cartPage.clickDecreaseQuantity();
        pageActions.staticWait(4000);
        int secondQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(1, finalQuantity);
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
        Assertions.assertEquals(1, cartPage.checkCartQuantity());
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
        Assertions.assertEquals(0, cartPage.checkCartQuantity());
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
        Assertions.assertEquals(firstPrice + secondPrice, totalPrice);
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
        Assertions.assertEquals(firstPrice + secondPrice, totalPrice);
        cartPage.clickDeleteMaterials();
        Assertions.assertEquals(1, cartPage.checkCartQuantity());
        int finalPrice = cartPage.getPriceTotal();
        Assertions.assertEquals(firstPrice, finalPrice);
    }

    @DisplayName("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: - Мини-карточки товаров в виде макета")
    @Test
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = cartPage.checkTextDoNotAddToCart();
        Assertions.assertEquals(text,"Не забудьте положить в корзину");
        int count = cartPage.checkDoNotAddToCartProductsList();
        Assertions.assertTrue(count > 0);
    }

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    @Test
    public void increaseQuantityMaterialOnMainPage() {
        mainPage.clickClosePopUp();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(2, finalQuantity);
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
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mainPage.clickDecreaseQuantity();
        pageActions.waitPageLoad();
        int secondQuantity = mainPage.getQuantityMaterials();
        Assertions.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

/*    @DisplayName("Пользователь увеличивает количество шт. товара в карточке товара")
    @Test
    public void increaseQuantityMaterialOnProductCartPage() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        productCardPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        pageActions.staticWait(3000);
        int quantity = productCardPage.getQuantityProduct();
        Assertions.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        productCardPage.clickToCartButton();
        pageActions.waitPageLoad();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }*/
    
}
