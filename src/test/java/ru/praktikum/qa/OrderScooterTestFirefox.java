package ru.praktikum.qa;

import org.junit.Test;
import ru.praktikum.qa.pageobjects.OrderPage;
import ru.praktikum.qa.pageobjects.ScooterLandingPage;
import static org.junit.Assert.*;

public class OrderScooterTestFirefox extends BasicUITestFirefox {
    ScooterLandingPage objScooterLandingPage = new ScooterLandingPage(webDriver);
    OrderPage objOrderPage = new OrderPage(webDriver);

    @Test
    public void canOrderScooter()
    {
        objScooterLandingPage.clickOrderButtonTop();
        objOrderPage.inputTextOrderFormPage1("Лев","Зайцев","Пушкин","+79112489001");
        objOrderPage.clickMetroStationSelectorPage1();
        objOrderPage.selectMetroStationSelector1Page1();
        objOrderPage.clickOrderNextRegButton();
        objOrderPage.inputDeliveryDatePage2();
        objOrderPage.inputCommentPage2();
        objOrderPage.clickFieldRentDurationPage2();
        objOrderPage.selectRentDurationPage2();
        objOrderPage.clickCheckboxColorGreyPage2();
        objOrderPage.clickOrderScooterButtonPage2();
        objOrderPage.clickPopupYesButton();
        objOrderPage.checkOrderSuccess();
        assertTrue("Ошибка",objOrderPage.checkOrderSuccess());
    }
    public void experementMethod() {

    }
}
