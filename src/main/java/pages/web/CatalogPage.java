package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends MainTestBase {


    //элементы
    private static final String MEDICATIONS_BUTTON_XPATH = "xpath;//a[@class='  js-catalog-menu__cat'][contains(.,'Лекарства')]";


    //конструктор
    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getMedicationsPageButton() {
        return new PageElementActions(MEDICATIONS_BUTTON_XPATH, driver);
    }


    //Методы

    @Step("Пользователь нажимает на категорию 'Лекарства")
    public void clickMedicationsButton() {
        getMedicationsPageButton().click();
        logger.info("Пользователь нажимает на категорию 'Лекарства'");
    }
}
