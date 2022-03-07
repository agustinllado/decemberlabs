package main.java.pageEvents;

import main.java.utils.ElementFetch;

public class BasePage {
    ElementFetch elementFetch;

    public BasePage() {
        if (elementFetch == null) {
            elementFetch = new ElementFetch();
        }
    }
}
