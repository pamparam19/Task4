package org.example.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTripPage extends BasePage {
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement btTitle;

    @FindBy(xpath = "//a[@title='Создать командировку' and text() = 'Создать командировку']")
    private WebElement createBTbutton;

    @Step("Нажать на кнопку Создать командировку")
    public CreateBusinessTripPage createBusinessTrip() {
        waitUntilClickable(createBTbutton).click();
        return pageManager.getCreateBusinessTripPage();
    }
}
