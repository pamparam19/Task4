package org.example.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement mpTitle;

    @FindBy(xpath = "//li[@class='dropdown']/a[@class='unclickable']")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//ul[@class='dropdown-menu menu_level_1']/li[contains(@class,'single') or @class='dropdown']/a/span")
    private List<WebElement> listSubMenu;

    public MainPage checkOpenMainPage(String titleToBeChecked) {
        waitUntilVisible(mpTitle);

        Assert.assertEquals("Заголовок отсутствует или не соответствует требуемому",
                titleToBeChecked, mpTitle.getText());
        return this;
    }

    public MainPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : listBaseMenu) {
            if (menuItem.getText().equalsIgnoreCase(nameBaseMenu)) {
                waitUntilClickable(menuItem);
                action.moveToElement(menuItem).perform();
                return this;
            }
        }
            Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
            return this;
    }


    public BusinessTripPage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : listSubMenu) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                waitUntilClickable(menuItem).click();
                return pageManager.getBusinessTripPage();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return pageManager.getBusinessTripPage();
    }
}
