package ru.praktikum.qa.pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class MainAbstratPage { // абстрактный класс для всех страниц проекта
    protected final WebDriver driver;

    public MainAbstratPage(WebDriver driver) { // конструктор абстрактного класса
        this.driver = driver;
    }
}