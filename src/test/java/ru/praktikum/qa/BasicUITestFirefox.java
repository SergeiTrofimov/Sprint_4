package ru.praktikum.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.Constants;

public abstract class BasicUITestFirefox { // абстрактный класс для тестов
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setup() // приведения систмы в првоначальное состояние
    {
        WebDriverManager.firefoxdriver().setup(); // инициализируем драйвер под хром
        webDriver = new FirefoxDriver(); // создаем объект драйвера под хром
        webDriver.get(Constants.hostname); // открываем страницу
        // webDriver.findElement(By.className(Constants.cookieRemoveButtonClassName)).click(); // закрываем попап с куки
    }

    @AfterClass
    public static void teardown() {
        // Закрой браузер
        webDriver.quit();
    }

}