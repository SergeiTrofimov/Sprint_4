package ru.praktikum.qa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.qa.pageobjects.ScooterLandingPage;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class QuestionsListTestChrome extends BasicUITestChrome {
    int value; // переменные для конструктора

    public QuestionsListTestChrome(int value) { // конструктор класса

        this.value = value;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}") // параметризация для теста
    public static Object[][] inputText() {
        return new Object[][]{
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        };
    }

    public void accordionElementShouldHaveDescription(int index) { // Метод получения описания по индексу элемента меню "Вопросы о важном"
        ScooterLandingPage objScooterLandingPage = new ScooterLandingPage(webDriver); // Создаем объект страницы
        objScooterLandingPage.clickToAccordionElement(Integer.toString(index)); // клик по элементу меню
        String text = objScooterLandingPage.getAccordionElementText(Integer.toString(index)); // получение текстового описания по посланному индексу
        assertEquals("Ошибка", ExpectedResult.questions[index], text); // проверка пришедшего описания на соответствие массиву Ожидаемых результатов
    }

    @Test
    public void accordionElementShouldHaveDescriptionAll1() {

        accordionElementShouldHaveDescription(value);
    }
}