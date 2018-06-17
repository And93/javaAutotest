package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    private static final String GROUPS_PAGE_NAME = "Groups";

    private final By homePage = By.id("maintable");
    private final By homePageTab = By.linkText("home");
    private final By groupsPageTab = By.linkText("groups");
    private final By groupsPageNameElement = By.tagName("h1");
    private final By newGroupButton = By.name("new");

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if (isElementPresent(groupsPageNameElement)
                && wd.findElement(groupsPageNameElement).getText().equals(GROUPS_PAGE_NAME)
                && isElementPresent(newGroupButton)) {
            return;
        }
        click(groupsPageTab);
    }

    public void goToHomePage() {
        if (isElementPresent(homePage)) {
            return;
        }
        click(homePageTab);
    }
}
