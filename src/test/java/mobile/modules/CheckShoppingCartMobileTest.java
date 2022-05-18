package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Изменения корзины на сайте Gorzdrav")
@DisplayName("Изменения корзины")
public class CheckShoppingCartMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь увеличивает количество шт. товара на странице корзины")
    @Test
    public void increaseQuantityMaterialOnCartPage() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickIncreaseQuantity();
        pageActions.staticWait(1000);
        int quantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара на странице корзины")
    @Test
    public void decreaseQuantityMaterialOnCartPage() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickIncreaseQuantity();
        pageActions.staticWait(1000);
        int firstQuantity = mobileCartPage.getQuantityMaterials();
        pageActions.waitPageLoad();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileCartPage.clickDecreaseQuantity();
        pageActions.staticWait(1000);
        int secondQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        mobileHeaderBlock.clickToCartButton();
        pageActions.staticWait(1000);
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @DisplayName("Пользователь удаляет 1 из 2-х товаров в корзине")
    @Test
    public void deleteMaterialsFromCart() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
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

    @DisplayName("Пользователь удаляет все товары в корзине")
    @Test
    public void deleteAllMaterialsFromCart() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
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

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void checkTotalAmountProducts() {
     //   mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        int firstPrice = mobileProductCardPage.getProductPrice();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        pageActions.waitPageLoad();
        int secondPrice = mobileProductCardPage.getProductPrice();
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }

    @DisplayName("Пользователь проверяет нотификацию после удаления товара")
    @Test
    public void checkNotificationCart() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
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

    @DisplayName("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: - Мини-карточки товаров в виде макета")
    @Test
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = mobileCartPage.checkTextDoNotAddToCart();
        Assert.assertEquals(text,"Не забудьте положить в корзину");
        int count = mobileCartPage.checkDoNotAddToCartProductsList();
        Assert.assertTrue(count > 0);
    }

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    @Test
    public void increaseQuantityMaterialOnMobileMainPage() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
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

    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    @Test
    public void decreaseQuantityMaterialOnMobileMainPage() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
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

 /*   @DisplayName("Пользователь увеличивает количество шт. товара в карточке товара")
    @Test
    public void increaseQuantityMaterialOnProductCartPage() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        int quantity = mobileProductCardPage.getQuantityProduct();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        mobileProductCardPage.clickToCartButton();
        pageActions.waitPageLoad();
        int finalQuantity = mobileProductCardPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }*/

}
