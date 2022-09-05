package ru.praktikum.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.Constants;
import ru.praktikum.qa.pageobjects.OrderPage;
import ru.praktikum.qa.pageobjects.ScooterLandingPage;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderScooterTestFirefox extends BasicUITestFirefox {
    ScooterLandingPage objScooterLandingPage = new ScooterLandingPage(webDriver);
    OrderPage objOrderPage = new OrderPage(webDriver);

    String name;
    String surname;
    String adress;
    String mobilePhoneNumber;
    String deliveryDate;
    String comment;
    int metroStationIndex;
    int rentDurationIndex;
    public static final By orderOrderScooterButtonPage2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    public OrderScooterTestFirefox (String name,String surname, String adress, String mobilePhoneNumber,String deliveryDate, String comment, int metroStationIndex, int rentDurationIndex)
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
    }

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
