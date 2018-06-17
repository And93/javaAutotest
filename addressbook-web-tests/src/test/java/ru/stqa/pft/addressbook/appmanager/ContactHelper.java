package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    private final By contactCheckBox = By.name("selected[]");
    private final By addNewContactButton = By.linkText("add new");
    private final By firstNameInput = By.name("firstname");
    private final By middleNameInput = By.name("middlename");
    private final By lastNameInput = By.name("lastname");
    private final By nickNameInput = By.name("nickname");
    private final By emailInput = By.name("email");
    private final By email2Input = By.name("email2");
    private final By newGroupDropDownMenu = By.name("new_group");
    private final By editContactButton = By.cssSelector("[title='Edit']");
    private final By submitContactButton = By.name("submit");
    private final By deleteContactButton = By.cssSelector("[name='MainForm'] [value='Delete']");
    private final By updateContactButton = By.name("update");
    private final By lastNameInListElement = By.cssSelector("[name='entry'] td:nth-child(2)");
    private final By photoInput = By.name("photo");

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void addNewContact() {
        click(addNewContactButton);
    }

    public void submitContact() {
        click(submitContactButton);
    }

    public void fillContact(ContactData contactData, boolean creation) {
        click(firstNameInput);
        type(firstNameInput, contactData.getFirstName());
        click(middleNameInput);
        type(middleNameInput, contactData.getMiddleName());
        click(lastNameInput);
        type(lastNameInput, contactData.getLastName());
        click(nickNameInput);
        type(nickNameInput, contactData.getNickName());
        click(emailInput);
        type(emailInput, contactData.getFirstEmail());
        click(email2Input);
        attache(photoInput, contactData.getPhoto());

        if (creation) {
            new Select(wd.findElement(newGroupDropDownMenu)).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(newGroupDropDownMenu));
        }
    }

    public void selectContact(int index) {
        wd.findElements(contactCheckBox).get(index).click();
    }

    public void deleteSelectedContact() {
        click(deleteContactButton);
    }

    public void initContactModification(int index) {
        wd.findElements(editContactButton).get(index).click();
    }

    public void submitContactModification() {
        click(updateContactButton);
    }

    public boolean isThereAContact() {
        return isElementPresent(contactCheckBox);
    }

    public void createContact(ContactData contactData, boolean create) {
        addNewContact();
        fillContact(contactData, create);
        submitContact();
    }

    public int getContactCount() {
        return wd.findElements(contactCheckBox).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elementsLastName = wd.findElements(lastNameInListElement);

        for (WebElement element : elementsLastName) {
            String lastName = element.getText();
            ContactData contact = new ContactData().withLastName(lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
