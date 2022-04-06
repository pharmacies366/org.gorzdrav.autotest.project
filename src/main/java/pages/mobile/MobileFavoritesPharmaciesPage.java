package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MobileFavoritesPharmaciesPage extends MainTestBase {

    //элементы
    private static final String TITLE_PAGE_XPATH = "xpath;//div[@class='b-popup--window__title']";


    //конструктор
    public MobileFavoritesPharmaciesPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getNamePage() {
        return new PageElementActions(TITLE_PAGE_XPATH, driver);
    }




    //Методы
    @Step("Пользователь проверяет название страницы для выбора любимой аптеки")
    public void checkNamePage(){
       String namePage = getNamePage().getText();
        Assert.assertEquals("Выберите любимую аптеку", namePage);
        logger.info("Пользователь проверяет название страницы для выбора любимой аптеки");
    }
}
