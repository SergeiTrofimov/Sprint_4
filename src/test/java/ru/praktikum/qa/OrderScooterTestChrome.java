package ru.praktikum.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.Constants;
import ru.praktikum.qa.pageobjects.OrderPage;
import ru.praktikum.qa.pageobjects.ScooterLandingPage;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderScooterTestChrome extends BasicUITestChrome { // инициализируем страницы
    ScooterLandingPage objScooterLandingPage = new ScooterLandingPage(webDriver); // стартовую страницу
    OrderPage objOrderPage = new OrderPage(webDriver); //форму заказов
    // Блок переменных, используем в конструкторе
    String name; //имя
    String surname; //фамилия
    String adress; // адресс
    String mobilePhoneNumber; // телефонный номер
    String deliveryDate; // дата доставки
    String comment; // комментарий
    int metroStationIndex; // индекс станции метро
    int rentDurationIndex; // индекс продолжительности аренды

    // Конструктор класса
    public OrderScooterTestChrome (String name,String surname, String adress, String mobilePhoneNumber,String deliveryDate, String comment, int metroStationIndex, int rentDurationIndex)
    {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.deliveryDate = deliveryDate;
        this.comment=comment;
        this.metroStationIndex = metroStationIndex;
        this.rentDurationIndex = rentDurationIndex;
    }

    // параметры теста
 @Parameterized.Parameters
 public static Object[][] inputText() {
        // тестовые данные {Имя(строка),Фамилия(строка),Адресс(строка), Телефонный номер (строка), Дата доставки(строка), Комментарий (строка), Индекс станции метро(целое), Индекс продолжительности аренды (целое)}
return new Object[][] {
    { "Лев", "Зайцев", "Пушкин","79112489001","13.03.2023","Оставить у дверей",1,1},
     { "Иван", "Болван", "Горький","+79112489002","24.05.2022","Не звонить в дверь",3,1},
     };
  }
  @Before
  public void canOrderScooterSetup (){
        webDriver.get(Constants.hostname);
    } // переоткрываем страничку

    @Test
    public void canOrderScooter() {

        objScooterLandingPage.clickOrderButtonTop();
        objOrderPage.inputTextOrderFormPage1(name, surname, adress,mobilePhoneNumber);
        objOrderPage.clickMetroStationSelectorPage1(metroStationIndex);
        objOrderPage.clickOrderNextRegButton();
        objOrderPage.inputDeliveryDatePage2(deliveryDate);
        objOrderPage.inputCommentPage2(comment);
        objOrderPage.clickFieldRentDurationPage2();
        objOrderPage.selectRentDurationPage2(rentDurationIndex);
        objOrderPage.clickCheckboxColorGreyPage2();
        objOrderPage.clickOrderScooterButtonPage2();
        objOrderPage.clickPopupYesButton();
        objOrderPage.checkOrderSuccess();
        assertTrue("Ошибка",objOrderPage.checkOrderSuccess());
    }
}