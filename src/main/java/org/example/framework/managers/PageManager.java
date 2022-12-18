package org.example.framework.managers;

import org.example.framework.pages.AuthPage;
import org.example.framework.pages.BusinessTripPage;
import org.example.framework.pages.CreateBusinessTripPage;
import org.example.framework.pages.MainPage;

public class PageManager {
    private static PageManager pageManager;
    private AuthPage authPage;
    private MainPage mainPage;
    private BusinessTripPage businessTripPage;
    private CreateBusinessTripPage createBusinessTripPage;


    private PageManager(){
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public AuthPage getAuthPage() {
        if (authPage == null) {
            authPage = new AuthPage();
        }
        return authPage;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public BusinessTripPage getBusinessTripPage() {
        if (businessTripPage == null) {
            businessTripPage = new BusinessTripPage();
        }
        return businessTripPage;
    }

    public CreateBusinessTripPage getCreateBusinessTripPage() {
        if (createBusinessTripPage == null) {
            createBusinessTripPage = new CreateBusinessTripPage();
        }
        return createBusinessTripPage;
    }



}
