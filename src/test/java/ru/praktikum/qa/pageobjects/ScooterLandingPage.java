package ru.praktikum.qa.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.Constants;

public class ScooterLandingPage extends MainAbstratPage { // пейджобжект для главной страницы
    private By orderButtonTop = By.className("Button_Button__ra12g");
    private By orderButtonBottom = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");

    public ScooterLandingPage (WebDriver driver) { // конструктор главной страницы
        super (driver);
    }
    public void clickToAccordionElement(String accordionIndex) // нажимаем на элемент списка по полученному индексу
    {
        driver.findElement(By.id(Constants.accordionHeaderNamePrefix +accordionIndex)).click();
    }
    public String getAccordionElementText(String accordionIndex) // получаем текст элемента списка после клика
    {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.accordionPanelNamePrefix+accordionIndex))); // очень ждем появления элемента
        String text = driver.findElement(By.id(Constants.accordionPanelNamePrefix+accordionIndex)).getText(); // хватаем описание, если оно появилось
        return text;
    }
    public void clickOrderButtonTop (){
        driver.findElement(orderButtonTop).click();
    }
}
