package org.example.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import org.example.framework.managers.PageManager;

public class AuthPageSteps {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Заполнить поля формы и залогиниться:$")
    public void fillFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getAuthPage().fillField((String) key, (String) value));
        pageManager.getAuthPage().confirmLogin();
    }
}
