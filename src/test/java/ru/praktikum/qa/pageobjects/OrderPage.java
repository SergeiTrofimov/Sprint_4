package ru.praktikum.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.Constants;

public class OrderPage extends MainAbstratPage {

    // Локаторы первой страницы
    private By orderNextRegButtonPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button"); // Локатор кнопки "Дальше"
    private By fieldNamePage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input"); // Локатор поля "Имя"
    private By fieldSurnamePage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input"); // Локатор поля "Фамилия"
    private By fieldAdressPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input"); // Локатор поля "Адрес"
    private By fieldMetroStationPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input"); // Локатор поля со списком "Станция метро"
    private By fieldPhoneNumberPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input"); // Локатор поля "Телефонный номер"
    private By valueOfMetroStation = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input"); // локатор элемента поля со списком "станция метро"

    // Локаторы второй страницы
    private By orderOrderScooterButtonPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]"); // локатор кнопки "Заказать"
    private By orderPreviousButtonPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[1]"); // локатор кнопки "Назад"
    private By fieldDeliveryDatePage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input"); // Локатор поля "Дата доставки"
    private By fieldRentDurationPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]");// Локатор поля "Срок аренды"
    private By fieldCommentPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input"); // Локатор поля "Комментарий"
    private By checkboxColorBlackPage2 = By.id("black"); // Локатор чекбокса "Черный жемчуг"
    private By checkboxColorGreyPage2 = By.id("grey"); // Локатор чекбокса "Серая безысходность"

    // Локаторы попапа подтверждения
    private By popupOrderModal = By.xpath("/html/body/div/div/div[2]/div[5]"); // Локатор модального окна
    private By statusViewButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button"); // Локатор модального окна
    private By popupYesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]"); // Локатор кнопки "Да"
    private By popupNoButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1]"); // Локатор кнопки "Нет"


    public OrderPage (WebDriver driver) { // конструктор страницы заказов
        super (driver);
    }

    public void clickOrderNextRegButton (){ // кликаем кнопку "Далее"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderNextRegButtonPage1));
        driver.findElement(orderNextRegButtonPage1).click();
    }

    public void clickOrderScooterButtonPage2 (){ // кликаем кнопку "Заказать"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderOrderScooterButtonPage2));
        driver.findElement(orderOrderScooterButtonPage2).click();
    }

    public void clickPreviousButtonPage2 (){ // кликаем кнопку "Назад"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPreviousButtonPage2));
        driver.findElement(orderPreviousButtonPage2).click();
    }

    public void inputTextOrderFormPage1 (String name, String surname, String adress, String phoneNumber) { // метод, заполняющий текстовые поля разом
        driver.findElement(fieldNamePage1).sendKeys(name);
        driver.findElement(fieldSurnamePage1).sendKeys(surname);
        driver.findElement(fieldAdressPage1).sendKeys(adress);
        driver.findElement(fieldPhoneNumberPage1).sendKeys(phoneNumber);
    }
    public void clickMetroStationSelectorPage1(int MetroStationIndex){ // кликаем поле со списком "Станция метро" и выбираем станцию
        driver.findElement(fieldMetroStationPage1).click();
        driver.findElement(By.xpath(Constants.metroStationSelectorPage1Xpath+MetroStationIndex+"]/button")).click();
    }

    public void inputDeliveryDatePage2 (String deliveryDate) // вводим дату доставки
    {
        driver.findElement(fieldDeliveryDatePage2).sendKeys(deliveryDate);
        driver.findElement(By.className("Order_Header__BZXOb")).click(); // кликаем в заголовок чтобы завершить ввод
    }
    public void inputCommentPage2 (String comment) // вводим коментарий
    {
        driver.findElement(fieldCommentPage2).sendKeys(comment);
    }
    public void clickFieldRentDurationPage2() // кликаем по полю со списком "Длительность аренды"
    {
     driver.findElement(fieldRentDurationPage2).click();
    }

    public void selectRentDurationPage2 (int RentDuration) //выбираем длительность аренды
    {
        driver.findElement(By.xpath(Constants.rentDurationPage2Xpath +RentDuration+"]")).click();
    }

    public void clickCheckboxColorBlackPage2()
    { // выбираем черный цвет
        driver.findElement(checkboxColorBlackPage2).click();
    }
    public void clickCheckboxColorGreyPage2() //выбираем серый цвет
    {
        driver.findElement(checkboxColorGreyPage2).click();
    }
   public void clickPopupYesButton (){ // подтверждаем заказ
       new WebDriverWait(driver, 5)
               .until(ExpectedConditions.visibilityOfElementLocated(popupYesButton));
       driver.findElement(popupYesButton).click();
   }
    public void clickPopupNoButton (){ // отменяем заказ
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(popupNoButton));
        driver.findElement(popupNoButton).click();
    }
    public boolean checkOrderSuccess (){ // проверяем что попап успешного заказа отобразился
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(statusViewButton));
        boolean success = driver.findElement(statusViewButton).isEnabled();
        return success;
    }
    public void clickStatusViewButton() //выбираем серый цвет
    {
        driver.findElement(statusViewButton).click();
    }
}