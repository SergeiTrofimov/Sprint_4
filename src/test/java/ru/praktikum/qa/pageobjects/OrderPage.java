package ru.praktikum.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends MainAbstratPage {

    // Локаторы первой страницы
    private By orderNextRegButtonPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    private By fieldNamePage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private By fieldSurnamePage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private By fieldAdressPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private By fieldMetroStationPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    private By fieldPhoneNumberPage1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private By valueOfMetroStation = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");

    // Локаторы второй страницы
    private By orderOrderScooterButtonPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private By orderPreviousButtonPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[1]");
    private By fieldDeliveryDatePage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private By fieldRentDurationPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    private By fieldCommentPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    private By checkboxColorBlackPage2 = By.id("black");
    private By checkboxColorGreyPage2 = By.id("grey");

    // Локаторы попапа подтверждения
    private By popupYesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    private By popupNoButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1]");
    private By popupOrderModal = By.className("Order_Modal__YZ-d3");

    public OrderPage (WebDriver driver) { // конструктор страницы заказов
        super (driver);
    }

    public void clickOrderNextRegButton (){ // кликаем кнопку "Далее"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderNextRegButtonPage1));
        driver.findElement(orderNextRegButtonPage1).click();
    }

    public void clickOrderScooterButtonPage2 (){ // кликаем кнопку "Далее"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderOrderScooterButtonPage2));
        driver.findElement(orderOrderScooterButtonPage2).click();
    }

    public void clickPreviousButtonPage2 (){ // кликаем кнопку "Далее"
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPreviousButtonPage2));
        driver.findElement(orderPreviousButtonPage2).click();
    }
    public void inputTextOrderFormPage1 (String name, String surname, String adress, String phoneNumber) {
        driver.findElement(fieldNamePage1).sendKeys(name);
        driver.findElement(fieldSurnamePage1).sendKeys(surname);
        driver.findElement(fieldAdressPage1).sendKeys(adress);
        //driver.findElement(fieldMetroStationPage1).sendKeys(metroStation);
        driver.findElement(fieldPhoneNumberPage1).sendKeys(phoneNumber);
    }
    public void clickMetroStationSelectorPage1(){
        driver.findElement(fieldMetroStationPage1).click();

    }
    public void selectMetroStationSelector(String metroStationName) {
        driver.findElement(valueOfMetroStation).sendKeys(metroStationName);
    }
    public void selectMetroStationSelector1Page1(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button")).click();
    }
    public void inputDeliveryDatePage2 ()
    {
        driver.findElement(fieldDeliveryDatePage2).sendKeys("13.03.1982");
        driver.findElement(By.className("Order_Header__BZXOb")).click();
    }
    public void inputCommentPage2 ()
    {
        driver.findElement(fieldCommentPage2).sendKeys("Оставить у дверей");
    }
    public void clickFieldRentDurationPage2()
    {
     driver.findElement(fieldRentDurationPage2).click();
    }

    public void selectRentDurationPage2 ()
    {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).click();
    }

    public void clickCheckboxColorBlackPage2() {
        driver.findElement(checkboxColorBlackPage2).click();
    }
    public void clickCheckboxColorGreyPage2()
    {
        driver.findElement(checkboxColorGreyPage2).click();
    }
   public void clickPopupYesButton (){
       new WebDriverWait(driver, 5)
               .until(ExpectedConditions.visibilityOfElementLocated(popupYesButton));
       driver.findElement(popupYesButton).click();
   }
    public void clickPopupNoButton (){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(popupNoButton));
        driver.findElement(popupNoButton).click();
    }
    public boolean checkOrderSuccess (){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(popupOrderModal));
        boolean success = driver.findElement(popupOrderModal).isDisplayed();
        return success;
    }
}