package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class TopPanelPage extends MainTestBase {


    //элементы
    private static final String LOGIN_ICON_CSS = "css;.js-to-menu__item--1";


    //конструктор
    public TopPanelPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getLoginIcon() {
        return new PageElementActions(LOGIN_ICON_CSS, driver);
    }



    //Методы

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickToLoginIcon(){
        getLoginIcon().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }
}
