package ru.praktikum.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterLandingPage extends MainAbstratPage { // пейджобжект для главной страницы

    public static final String accordionHeaderNamePrefix = "accordion__heading-"; // конструирования локатора вопроса
    public static final String accordionPanelNamePrefix = "accordion__panel-"; // конструирования локатора описания

    // Локаторы для страницы
    private By orderButtonTop = By.className("Button_Button__ra12g");
    private By orderButtonBottom = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");
    private By cookieRemoveButton = By.className("App_CookieButton__3cvqF");

    public ScooterLandingPage(WebDriver driver) // конструктор главной страницы
    {
        super(driver);
    }

    public void clickToAccordionElement(String accordionIndex) // нажимаем на элемент списка по полученному индексу
    {
        driver.findElement(By.id(accordionHeaderNamePrefix + accordionIndex)).click();
    }

    public String getAccordionElementText(String accordionIndex) // получаем текст элемента списка после клика
    {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(accordionPanelNamePrefix + accordionIndex))); // очень ждем появления элемента
        String text = driver.findElement(By.id(accordionPanelNamePrefix + accordionIndex)).getText(); // хватаем описание, если оно появилось
        return text;
    }

    public void clickOrderButtonTop() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonTop));
        driver.findElement(orderButtonTop).click();
    }

    public void setCookieRemoveButton() // нажимаем кнопку для попапа с куки
    {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(cookieRemoveButton));
        driver.findElement(cookieRemoveButton).click();
    }
}