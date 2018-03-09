package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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
        click(By.name("title"));
        type(By.name("title"), contactData.getTitle());
        click(By.name("company"));
        type(By.name("company"), contactData.getCompany());
        click(By.name("address"));
        type(By.name("address"), contactData.getAddress());
        click(By.name("home"));
        type(By.name("home"), contactData.getHomePhone());
        click(By.name("mobile"));
        click(By.name("home"));
        click(By.name("mobile"));
        type(By.name("mobile"), contactData.getMobilePhone());
        click(By.name("work"));
        type(By.name("work"), contactData.getWorkPhone());
        click(By.name("fax"));
        type(By.name("fax"), contactData.getFax());
        click(By.name("email"));
        type(By.name("email"), contactData.getEmail1());
        click(By.name("email2"));
        type(By.name("email2"), contactData.getEmail2());
        click(By.name("email3"));
        type(By.name("email3"), contactData.getEmail3());
        click(By.name("address2"));
        type(By.name("address2"), contactData.getAddress2());
        click(By.name("phone2"));
        type(By.name("phone2"), contactData.getPhone2());
        click(By.name("notes"));
        type(By.name("notes"), contactData.getNotes());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void initContactModification() {
        click(By.cssSelector("[title='Edit']"));
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
}
