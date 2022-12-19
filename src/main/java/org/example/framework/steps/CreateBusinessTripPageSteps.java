package org.example.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bg.И;
import org.example.framework.managers.PageManager;

import java.util.List;
import java.util.Map;

public class CreateBusinessTripPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^Проверить открытие страницы \"([^\"]*)\"$")
    public void checkTitle(String titleName) {
        pageManager.getCreateBusinessTripPage().checkOpenCreateBusinessTripPage(titleName);
    }

    @И("^Выбрать подразделение \"([^\"]*)\"$")
    public void chooseUnit(String unitName) {
        pageManager.getCreateBusinessTripPage().chooseUnit(unitName);
    }

    @И("^Выбрать организацию \"([^\"]*)\"$")
    public void chooseOrg(String orgName) {
        pageManager.getCreateBusinessTripPage().chooseOrganisation(orgName);
    }

    @И("^Отметить чекбокс \"([^\"]*)\"$")
    public void chooseCheckbox(String orgName) {
        pageManager.getCreateBusinessTripPage().turnOnCheckbox();
    }

    @И("^Заполнить информацию о городе выбытия и прибытия:$")
    public void fillInCitiesInfo(DataTable dataTable) {
        List<Map<String, String>> cities = dataTable.asMaps(String.class, String.class);
        pageManager.getCreateBusinessTripPage().fillInCities(cities.get(0).get("Город выбытия"),
                cities.get(0).get("Город прибытия"));
    }

    @И("^Заполнить информацию о дате выезда и возвращения:$")
    public void fillInDatesInfo(DataTable dataTable) {
        List<Map<String, String>> dates = dataTable.asMaps(String.class, String.class);
        pageManager.getCreateBusinessTripPage().fillInDates(dates.get(0).get("Дата выезда"),
                dates.get(0).get("Дата возвращения"));
    }

    @И("^Проверить сообщение об ошибке \"([^\"]*)\"$")
    public void checkErMes(String message) {
        pageManager.getCreateBusinessTripPage().checkMainAlert(message);
    }
}
