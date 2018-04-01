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

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void submitContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
        click(By.id("container"));
    }

    public void fillContact(ContactData contactData, boolean creation) {
        click(By.name("firstname"));
        type(By.name("firstname"), contactData.getFirstName());
        click(By.name("middlename"));
        type(By.name("middlename"), contactData.getMiddleName());
        click(By.name("lastname"));
        type(By.name("lastname"), contactData.getLastName());
        click(By.name("nickname"));
        type(By.name("nickname"), contactData.getNickName());
        click(By.name("email"));
        type(By.name("email"), contactData.getEmail1());
        click(By.name("email2"));

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("[title='Edit']")).get(index).click();

    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contactData, boolean create) {
        addNewContact();
        fillContact(contactData, create);
        submitContact();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elementsLastName = wd.findElements(By.cssSelector("[name='entry'] td:nth-child(2)"));

        for (WebElement element : elementsLastName) {
            String lastName = element.getText();
            ContactData contact = new ContactData(
                    null,
                    null,
                    lastName,
                    null,
                    null,
                    null
            );
            contacts.add(contact);
        }
        return contacts;
    }
}
