package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

    private final By groupPageButton = By.linkText("group page");
    private final By submitGroupButton = By.name("submit");
    private final By groupNameInput = By.name("group_name");
    private final By groupHeaderInput = By.name("group_header");
    private final By groupFooterInput = By.name("group_footer");
    private final By newGroupButton = By.name("new");
    private final By deleteGroupButton = By.name("delete");
    private final By editGroupButton = By.name("edit");
    private final By updateGroupButton = By.name("update");
    private final By groupCheckBox = By.name("selected[]");
    private final By groupListSelector = By.cssSelector("span.group");

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(groupPageButton);
    }

    public void submitGroupCreation() {
        click(submitGroupButton);
    }

    public void fillGroupForm(GroupData groupDate) {
        type(groupNameInput, groupDate.getNameGroup());
        type(groupHeaderInput, groupDate.getHeader());
        type(groupFooterInput, groupDate.getFooter());
    }

    public void initGroupCreation() {
        click(newGroupButton);
    }

    public void deleteSelectedGroup() {
        click(deleteGroupButton);
    }

    public By groupByIdSelector(int id) {
        return By.cssSelector(INPUT_TAG_NAME + "[" + VALUE_ATTRIBUTE + "='" + id + "']");
    }

    public void selectGroupById(int id) {
        wd.findElement(this.groupByIdSelector(id)).click();
    }

    public void initGroupModification() {
        click(editGroupButton);
    }

    public void submitGroupModification() {
        click(updateGroupButton);
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }


    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(groupCheckBox);
    }

    public int count() {
        return wd.findElements(groupCheckBox).size();
    }

    private Groups groupCache = null;

    public Groups all() {

        if (groupCache != null) {
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(groupListSelector);

        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName(INPUT_TAG_NAME)).getAttribute(VALUE_ATTRIBUTE));
            groupCache.add(
                    new GroupData()
                            .withId(id)
                            .withNameGroup(name));
        }
        return new Groups(groupCache);
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroup();
        groupCache = null;
        returnToGroupPage();
    }
}
