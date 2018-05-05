package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getTo().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(
                    new ContactData(
                            "MyFirstName",
                            "MyMiddleName",
                            "MyLastName",
                            "MyNickName",
                            "email@email.email",
                            "modification1"
                    ),
                    true
            );
        }
        app.getTo().goToHomePage();

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size() - 1);

        ContactData contact = new ContactData(
                "FirstName",
                "MiddleName",
                "LastName",
                "NickName",
                "a@a.a",
                "modification1"
        );

        app.getContactHelper().fillContact(
                contact,
                false
        );
        app.getContactHelper().submitContactModification();
        app.getTo().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.sort(byLastName);
        after.sort(byLastName);
        Assert.assertEquals(before, after);
    }
}
