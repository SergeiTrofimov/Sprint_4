package ru.praktikum.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends MainAbstratPage {

    public static final String rentDurationPage2Xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div["; //используется для конструирования выбора значения срока аренды
    private static final String metroStationSelectorPage1Xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li["; // используется для конструирования локатора станции

    // Локаторы первой страницы
    private By orderNextRegButtonPage1 = By.cssSelector("div.Order_NextButton__1_rCA > button"); // Локатор кнопки "Дальше"
    private By fieldNamePage1 = By.xpath("//input[@placeholder='* Имя']"); // Локатор поля "Имя"
    private By fieldSurnamePage1 = By.xpath("//input[@placeholder='* Фамилия']"); // Локатор поля "Фамилия"
    private By fieldAdressPage1 = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Локатор поля "Адрес"
    private By fieldMetroStationPage1 = By.className("select-search__input"); // Локатор поля со списком "Станция метро"
    private By fieldPhoneNumberPage1 = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Локатор поля "Телефонный номер"

    // Локаторы второй страницы
    private By orderOrderScooterButtonPage2 = By.cssSelector("div.Order_Buttons__1xGrp > button:nth-child(2)"); // локатор кнопки "Заказать"
    private By orderPreviousButtonPage2 = By.cssSelector("div.Order_Buttons__1xGrp > button.Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i"); // локатор кнопки "Назад"
    private By fieldDeliveryDatePage2 = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Локатор поля "Дата доставки"
    private By fieldRentDurationPage2 = By.className("Dropdown-placeholder");// Локатор поля "Срок аренды"
    private By fieldCommentPage2 = By.xpath("//input[@placeholder='Комментарий для курьера']"); // Локатор поля "Комментарий"
    private By checkboxColorBlackPage2 = By.id("black"); // Локатор чекбокса "Черный жемчуг"
    private By checkboxColorGreyPage2 = By.id("grey"); // Локатор чекбокса "Серая безысходность"

    // Локаторы попапа подтверждения
    private By popupOrderModal = By.cssSelector("div.Order_Modal__YZ-d3 > div.Order_ModalHeader__3FDaJ"); // Локатор модального окна
    private By statusViewButton = By.cssSelector("div.Order_NextButton__1_rCA > button:nth-child(1)"); // Локатор кнопки просмотра заказа в модальном окне
    private By popupYesButton = By.cssSelector("div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)"); // Локатор кнопки "Да"
    private By popupNoButton = By.xpath("div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button.Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i"); // Локатор кнопки "Нет"

    public OrderPage(WebDriver driver) { // конструктор страницы заказов
        super(driver);
    }

    public void clickOrderNextRegButton() { // кликаем кнопку "Далее"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderNextRegButtonPage1));
        driver.findElement(orderNextRegButtonPage1).click();
    }

    public void clickOrderScooterButtonPage2() { // кликаем кнопку "Заказать"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderOrderScooterButtonPage2));
        driver.findElement(orderOrderScooterButtonPage2).click();
    }

    public void clickPreviousButtonPage2() { // кликаем кнопку "Назад"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPreviousButtonPage2));
        driver.findElement(orderPreviousButtonPage2).click();
    }

    public void inputTextOrderFormPage1(String name, String surname, String adress, String phoneNumber) { // метод, заполняющий текстовые поля разом
        driver.findElement(fieldNamePage1).sendKeys(name);
        driver.findElement(fieldSurnamePage1).sendKeys(surname);
        driver.findElement(fieldAdressPage1).sendKeys(adress);
        driver.findElement(fieldPhoneNumberPage1).sendKeys(phoneNumber);
    }

    public void clickMetroStationSelectorPage1(int MetroStationIndex) { // кликаем поле со списком "Станция метро" и выбираем станцию
        driver.findElement(fieldMetroStationPage1).click();
        driver.findElement(By.xpath(metroStationSelectorPage1Xpath + MetroStationIndex + "]/button")).click();
    }

    public void inputDeliveryDatePage2(String deliveryDate) // вводим дату доставки
    {
        driver.findElement(fieldDeliveryDatePage2).sendKeys(deliveryDate);
        driver.findElement(By.className("Order_Header__BZXOb")).click(); // кликаем в заголовок чтобы завершить ввод
    }

    public void inputCommentPage2(String comment) // вводим коментарий
    {
        driver.findElement(fieldCommentPage2).sendKeys(comment);
    }

    public void clickFieldRentDurationPage2() // кликаем по полю со списком "Длительность аренды"
    {
        driver.findElement(fieldRentDurationPage2).click();
    }

    public void selectRentDurationPage2(int RentDuration) //выбираем длительность аренды
    {
        driver.findElement(By.xpath(rentDurationPage2Xpath + RentDuration + "]")).click();
    }

    public void clickCheckboxColorBlackPage2() { // выбираем черный цвет
        driver.findElement(checkboxColorBlackPage2).click();
    }

    public void clickCheckboxColorGreyPage2() //выбираем серый цвет
    {
        driver.findElement(checkboxColorGreyPage2).click();
    }

    public void clickPopupYesButton() { // подтверждаем заказ
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(popupYesButton));
        driver.findElement(popupYesButton).click();
    }

    public void clickPopupNoButton() { // отменяем заказ
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(popupNoButton));
        driver.findElement(popupNoButton).click();
    }

    public boolean checkOrderSuccess() { // проверяем что попап успешного заказа отобразился
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