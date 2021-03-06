package mobile.front;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка главной страницы на сайте Gorzdrav")
@DisplayName("Проверка главной страницы")
public class MainPageTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка отображения логотипа")
    @Test
    public void checkVisibilityLogoMainPage(){
        mobileMainPage.getSiteLogo().elementIsVisibility();
        logger.info("Логотип отображается на сайте");
    }

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogoMainPage(){
        mobileMainPage.getSiteLogo().elementIsClickable();
        logger.info("Логотип кликабелен");
    }
}
