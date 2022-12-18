package org.example.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;



public class AuthPage extends BasePage{

    @FindBy(xpath = "//input[@id='prependedInput']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement loginButton;

    @Step("Заполнить поле {nameField} значением {value}")
    public AuthPage fillField(String nameField, String value){
        if(nameField.equals("Логин")){
            fillInputField(inputLogin, value);
        } else if(nameField.equals("Пароль")){
            fillInputField(inputPassword, value);
        } else {
            Assert.fail("Поле с наименованием '" + nameField + "' отсутствует " +
                    "на странице аутентификации");
        }
        return this;
    }

    @Step("Кликнуть по кнопке и залогиниться")
    public MainPage confirmLogin() {
        waitUntilClickable(loginButton).click();
        return pageManager.getMainPage();
    }


}
