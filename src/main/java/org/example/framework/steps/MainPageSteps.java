package org.example.framework.steps;

import io.cucumber.java.bg.И;
import org.example.framework.managers.PageManager;

public class MainPageSteps {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Проверить появление заголовка \"([^\"]*)\"$")
    public void checkTitle(String titleName) {
        pageManager.getMainPage().checkOpenMainPage(titleName);
    }

    @И("^Выбрать меню \"([^\"]*)\"$")
    public void clickMenu(String menuName) {
        pageManager.getMainPage().selectBaseMenu(menuName);
    }

    @И("^Выбрать подменю \"([^\"]*)\"$")
    public void clickSubMenu(String submenuName) {
        pageManager.getMainPage().selectSubMenu(submenuName);
        pageManager.getBusinessTripPage().createBusinessTrip();
    }

}
