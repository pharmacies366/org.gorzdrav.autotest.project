package pages.web;

import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public class CookiePage extends MainTestBase {

    /*Минус этого подхода — необходимость вручную менять куки после истечения их срока валидности*/


    //конструктор
    public CookiePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Пользователь авторизовывается через Cookie")
    public void cookieAuthorization() {
        logger.info("ПРОИЗОШЛА АВТОРИЗАЦИЯ ПОЛЬЗОВАТЕЛЯ ЧЕРЕЗ COOKIE");


        // S1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "91dfbff30a7d6812d033e327a61bd49d6bc8f653"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "W2dvcnpkcmF2XTkzMTM2MDA5NDE6MTY0NjQ3Njc5NDE0MToyNjUyOTFlZGNkNDZiZjk2MzNmY2EzYzk5MDU3NTMzZQ"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-569ff799ff-f47jh"));

    }
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe"));
    }



/*
    // D1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "c874fa37bf4d87e178e789730f8a57dc6ef724a4"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "W2dvcnpkcmF2XTkzMTM2MDA5NDE6MTY0NjQxMzEwNTE4NzpkN2ZjYmZmODY5YWI1NmY3OTk3YjIzM2VlYjZkNjEyNA"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-5d5d5bf848-556n7"));

    }
    public void reCaptchaKey(){
        // driver.manage().addCookie(new Cookie("JSESSIONID", "CA5F7D8DE4178DD0081CFA33A92DB842.accstorefront-d8dcbf9d9-7jsv7"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-d8dcbf9d9-7jsv7"));
        driver.manage().addCookie(new Cookie("isRecapthcaInit", "true"));
    }
*/




    @Step("Получение всех кук и вывод их в консоль")
    public void printAllCookie() {
        Set<Cookie> cookies = new HashSet<>();
        cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            System.out.println("Имя куки - " + cookieName + " значение  куки - " + cookie.getValue());
        }
    }

    @Step("Пользователь очищает Cookie")
    public void deleteAllCookie() {
        driver.manage().deleteAllCookies();
        logger.info("ПОЛЬЗОВАТЕЛЬ ОЧИСТИЛ COOKIE");
        logger.info("ПОЛЬЗОВАТЕЛЬ РАЗЛОГИНЕН");
    }

}
