package ru.praktikum.qa;

import org.junit.*;
import ru.praktikum.qa.pageobjects.ScooterLandingPage;
import static org.junit.Assert.*;

public class QuestionsListTestFirefox extends BasicUITestFirefox{
    public void accordionElementShouldHaveDescription(int index) { // Метод получения описания по индексу элемента меню "Вопросы о важном"
        ScooterLandingPage objScooterLandingPage = new ScooterLandingPage(webDriver); // Создаем объект страницы
        objScooterLandingPage.clickToAccordionElement(Integer.toString(index)); // клик по элементу меню
        String text = objScooterLandingPage.getAccordionElementText(Integer.toString(index)); // получение текстового описания по посланному индексу
        assertEquals ("Ошибка",ExpectedResult.questions[index],text); // проверка пришедшего описания на соответствие массиву Ожидаемых результатов
    }

    @Test
    public void accordionElementShouldHaveDescription0() {
        accordionElementShouldHaveDescription(0);
    }

    @Test
    public void accordionElementShouldHaveDescription1() {
        accordionElementShouldHaveDescription(1);
    }

    @Test
    public void accordionElementShouldHaveDescription2() {
        accordionElementShouldHaveDescription(2);
    }

    @Test
    public void accordionElementShouldHaveDescription3() {
        accordionElementShouldHaveDescription(3);
    }

    @Test
    public void accordionElementShouldHaveDescription4() {
        accordionElementShouldHaveDescription(4);
    }

    @Test
    public void accordionElementShouldHaveDescription5() {
        accordionElementShouldHaveDescription(5);
    }

    @Test
    public void accordionElementShouldHaveDescription6() {
        accordionElementShouldHaveDescription(6);
    }

    @Test
    public void accordionElementShouldHaveDescription7() {
        accordionElementShouldHaveDescription(7);
    }
}


