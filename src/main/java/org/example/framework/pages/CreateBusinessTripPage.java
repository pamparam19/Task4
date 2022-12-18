package org.example.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateBusinessTripPage extends BasePage{
    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement createBTTitle;

    @FindBy(xpath = "//select[@data-name='field__business-unit']")
    private WebElement drpBusinessUnit;

    @FindBy(xpath = "//div[contains(@class,'selector input-widget-select') and contains(@id,'businessUnit')]/span")
    private WebElement checkUnit;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement orgChooseFirst;

    @FindBy(xpath = "//span[@class='select2-chosen' and text()='Укажите организацию']")
    private WebElement orgChooseSecond;

    @FindBy(xpath = "//div[@id='select2-drop']//input[@class='select2-input select2-focused']")
    private WebElement orgInput;

    @FindBy(xpath = "//span[@class='select2-match']")
    private WebElement matchingOrg;

    @FindBy(xpath = "//a[@class='select2-choice']/span")
    private WebElement checkOrg;

    @FindBy(xpath = "//input[@data-ftid='crm_business_trip_tasks_1']")
    private WebElement ticketCheckbox;

    @FindBy(xpath = "//input[@data-ftid='crm_business_trip_departureCity']")
    private WebElement departCity;

    @FindBy(xpath = "//input[@data-ftid='crm_business_trip_arrivalCity']")
    private WebElement arrivalCity;

    @FindBy(xpath = "//input[contains(@id,'selector') and contains(@id,'departureDatePlan')]")
    private WebElement depDate;

    @FindBy(xpath = "//input[contains(@id,'selector') and contains(@id,'returnDatePlan')]")
    private WebElement returnDate;

    @FindBy(xpath = "//td[contains(@class,'ui-datepicker-current-day') and @data-event='click']")
    private WebElement checkMonthYear;

    @FindBy(xpath = "//td[contains(@class,'ui-datepicker-current-day') and @data-event='click']/a")
    private WebElement checkDay;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    private WebElement saveCloseButton;

    @FindBy(xpath = "//div[@data-ftid='crm_business_trip_users']/parent::*/following-sibling::*")
    private WebElement alertMesUsers;

    @FindBy(xpath = "//div[@data-ftid='crm_business_trip_foreignUsers']/parent::*/following-sibling::*")
    private WebElement alertMesForUs;



    @Step("Проверить появление заголовка {titleToBeChecked}")
    public CreateBusinessTripPage checkOpenCreateBusinessTripPage(String titleToBeChecked) {
        waitUntilVisible(createBTTitle);
        Assert.assertEquals("Заголовок отсутствует или не соответствует требуемому",
                titleToBeChecked, createBTTitle.getText());
        return this;
    }

    @Step("Выбрать подразделение {unitName} и проверить правильность заполнения поля")
    public CreateBusinessTripPage chooseUnit(String unitName){
        Select drpUnit = new Select(drpBusinessUnit);
        drpUnit.selectByVisibleText(unitName);
        Assert.assertEquals("Поле Подразделение заполнено неверно",
                unitName,
                checkUnit.getText());
        return this;
    }

    @Step ("Выбрать организацию {orgName} и проверить правильность заполнения поля")
    public CreateBusinessTripPage chooseOrganisation(String orgName){
        waitUntilClickable(orgChooseFirst).click();
        waitUntilClickable(orgChooseSecond).click();
        waitUntilClickable(orgInput).sendKeys(orgName);
        waitUntilClickable(matchingOrg).click();
        Assert.assertEquals("Организация выбрана некорректно",
                orgName, checkOrg.getText());
        return this;
    }

    @Step("Включить и проверить чекбокс Заказ билетов")
    public CreateBusinessTripPage turnOnCheckbox(){
        waitUntilClickable(ticketCheckbox).click();
        Assert.assertTrue("Чекбокс Заказ билетов не отмечен", ticketCheckbox.isSelected());
        return this;
    }

    @Step("Заполнить поле город выбытия {depCity} и город прибытия {arrCity} " +
            "и проверить правильность заполнения полей")
    public CreateBusinessTripPage fillInCities(String depCity, String arrCity){
        fillInputField(departCity,depCity);
        fillInputField(arrivalCity,arrCity);
        Assert.assertEquals("Город выбытия заполнен неверно", depCity,
                departCity.getAttribute("value"));
        Assert.assertEquals("Город прибытия заполнен неверно", arrCity,
                arrivalCity.getAttribute("value"));
        return this;
    }

    @Step("Заполнить дату выезда {departDate} и дату возвращения {retDate} " +
            "и проверить правильность заполнения полей")
    public CreateBusinessTripPage fillInDates(String departDate, String retDate){
        depDate.sendKeys(departDate);
        checkDates(checkMonthYear, checkDay, departDate);
        depDate.sendKeys(Keys.ESCAPE);
        returnDate.sendKeys(retDate);
        checkDates(checkMonthYear,checkDay,retDate);
        returnDate.sendKeys(Keys.ESCAPE);
        return this;
    }

    @Step("Проверить сообщение об ошибке {alertText}")
    public CreateBusinessTripPage checkMainAlert(String alertText){
        waitUntilClickable(saveCloseButton).click();
        scrollToElementJs(alertMesUsers);
        waitUntilVisible(alertMesUsers);
        Assert.assertEquals("Сообщение об ошибке не появилось/некорректно",
                alertText,
                alertMesUsers.getText());
        waitUntilVisible(alertMesForUs);
        Assert.assertEquals("Сообщение об ошибке не появилось/некорректно",
                alertText,
                alertMesForUs.getText());
        return this;
    }


}
