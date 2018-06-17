package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws IOException {

        app.getTo().groupPage();
        app.group().create(new GroupData().withNameGroup(TestBase.getDataProperties("groupName_1")));

        app.getTo().groupPage();
        app.group().create(new GroupData().withNameGroup(TestBase.getDataProperties("groupName_2")));

        app.getTo().goToHomePage();

        if (!app.contact().isThereAContact()) {
            ContactData contact = new ContactData()
                    .withFirstName(TestBase.getDataProperties("firstName_1"))
                    .withMiddleName(TestBase.getDataProperties("middleName_1"))
                    .withLastName(TestBase.getDataProperties("lastName_1"))
                    .withNickName(TestBase.getDataProperties("nickName_1"))
                    .withFirstEmail(TestBase.getDataProperties("firstEmail_1"))
                    .withGroup(TestBase.getDataProperties("groupName_1"));

            app.contact().createContact(contact, true);
        }
    }

    @Test
    public void testContactModification() throws IOException {
        app.getTo().goToHomePage();
        List<ContactData> before = app.contact().getContactList();
        app.contact().initContactModification(before.size() - 1);

        ContactData contact = new ContactData()
                .withFirstName(TestBase.getDataProperties("firstName_2"))
                .withMiddleName(TestBase.getDataProperties("middleName_2"))
                .withLastName(TestBase.getDataProperties("lastName_2"))
                .withNickName(TestBase.getDataProperties("nickName_2"))
                .withFirstEmail(TestBase.getDataProperties("firstEmail_2"))
                .withGroup(TestBase.getDataProperties("groupName_2"));

        app.contact().fillContact(contact, false);
        app.contact().submitContactModification();
        app.getTo().goToHomePage();
        List<ContactData> after = app.contact().getContactList();
        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.sort(byLastName);
        after.sort(byLastName);

        assertEquals(
                before,
                after,
                "The contact: " + contact.getLastName() + " " + contact.getFirstName() + " was not modificated"
        );
    }
}
