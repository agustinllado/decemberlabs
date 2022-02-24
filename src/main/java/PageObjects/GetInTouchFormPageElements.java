package main.java.PageObjects;

public interface GetInTouchFormPageElements {

    String nameText = "name";
    String emailText = "email";
    String companyText = "company";
    String messageText = "message";
    String budgetRadio = "#budget input[value='%s']";
    String hearUsRadio = "#hearus input[value='%s']";
    String sendButton = "#email-form input[type='submit']";
}
