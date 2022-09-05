package ru.praktikum.qa;

import org.junit.*;
import org.openqa.selenium.By;
import ru.Constants;
import ru.praktikum.qa.pageobjects.ScooterLandingPage;
import static org.junit.Assert.*;

public class QuestionsListTestChrome extends BasicUITestChrome {
    public void accordionElementShouldHaveDescription(int index) { // Метод получения описания по индексу элемента меню "Вопросы о важном"
        ScooterLandingPage objScooterLandingPage = new ScooterLandingPage(webDriver); // Создаем объект страницы
        objScooterLandingPage.clickToAccordionElement(Integer.toString(index)); // клик по элементу меню
        String text = objScooterLandingPage.getAccordionElementText(Integer.toString(index)); // получение текстового описания по посланному индексу
        assertEquals("Ошибка", ExpectedResult.questions[index], text); // проверка пришедшего описания на соответствие массиву Ожидаемых результатов
    }

    @Test // перебор вопросов (открываем все вопросы, сравниваем описания)
    public void accordionElementShouldHaveDescriptionAll() {
        for (int i = 0; i <= 7; i++) {
            accordionElementShouldHaveDescription(i);
        }
    }
        @Test // проверяем, что можно открыть предыдущий вопрос, после выбора следущего
        public void accordionElementShouldHaveDescriptionPrevious (){
        accordionElementShouldHaveDescription(0);
        accordionElementShouldHaveDescription(1);
        accordionElementShouldHaveDescription(0);
    }
}