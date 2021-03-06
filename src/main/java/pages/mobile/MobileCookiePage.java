package pages.mobile;

import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public class MobileCookiePage extends MainTestBase {

    /*Минус этого подхода — необходимость вручную менять куки после истечения их срока валидности*/

    //конструктор
    public MobileCookiePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Пользователь авторизовывается через Cookie")
    public void cookieAuthorization() {
        logger.info("ПРОИЗОШЛА АВТОРИЗАЦИЯ ПОЛЬЗОВАТЕЛЯ ЧЕРЕЗ COOKIE");


        // P1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "e47c8beb8d2e41bfb0762da44e297471ff85e970"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "W2dvcnpkcmF2XTkzMTM2MDA5NDE6MTY0NjgzOTYwMDYzMToyMjk4NDMzMDNmMmMwYjE3NGUwYjQ3MGRkNWEyNGU3MA"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-5f97bcbc9d-8xqc9"));

    }
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe"));
    }


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
