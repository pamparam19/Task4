package org.example.framework.pages;

import org.example.framework.managers.DriverManager;
import org.example.framework.managers.PageManager;
import org.example.framework.managers.TestPropManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final DriverManager driverManager = DriverManager.getDriverManager();
    protected PageManager pageManager = PageManager.getPageManager();
    protected Actions action = new Actions(driverManager.getDriver());
    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 20, 10000);
    private final TestPropManager props = TestPropManager.getTestPropManager();

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    protected void fillInputField(WebElement field, String value) {
       // scrollToElementJs(field);
        waitUntilClickable(field).clear();
        field.click();
        field.sendKeys(value);
    }

    protected void checkDates(WebElement elementYear, WebElement elementDay, String tDate){
        Assert.assertEquals("Год выезда выбран неправильно",tDate.substring(6),
                elementYear.getAttribute("data-year"));
        Assert.assertEquals("Месяц выезда выбран неправильно",String.valueOf(Integer.valueOf(tDate.substring(3,5))-1),
                elementYear.getAttribute("data-month"));
        Assert.assertEquals("День выезда выбран неправильно",tDate.substring(0,2),
                elementDay.getText());
    }

}
