package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    private final By userInput = By.name("user");
    private final By passwordInput = By.name("pass");
    private final By submitButton = By.cssSelector("[name='LoginForm'] [value='Login']");

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(userInput, username);
        type(passwordInput, password);
        click(submitButton);
    }
}
