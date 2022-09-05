package ru.praktikum.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Constants;

public abstract class BasicUITestChrome { // абстрактный класс для тестов
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setup () // приведения систмы в првоначальное состояние
    {
        WebDriverManager.chromedriver().setup(); // инициализируем драйвер под хром
        webDriver = new ChromeDriver(); // создаем объект драйвера под хром
        webDriver.get(Constants.hostname); // открываем страницу
        webDriver.findElement(By.className(Constants.cookieRemoveButtonClassName)).click(); // закрываем попап с куки
    }


   @AfterClass
   public static void teardown() {
       // Закрой браузер
     webDriver.quit();
   }

}
