package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    private ContactData contact;

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        app.getTo().goToHomePage();

        contact = new ContactData()
                .withFirstName(TestBase.getDataProperties("firstName_1"))
                .withMiddleName(TestBase.getDataProperties("middleName_1"))
                .withLastName(TestBase.getDataProperties("lastName_1"))
                .withNickName(TestBase.getDataProperties("nickName_1"))
                .withFirstEmail(TestBase.getDataProperties("firstEmail_1"));

        if (!app.contact().isThereAContact()) {
            app.contact().createContact(contact, true);
        }
    }

    @Test
    public void testContactDeletion() {
        app.getTo().goToHomePage();
        List<ContactData> before = app.contact().getContactList();
        app.contact().selectContact(before.size() - 1);
        app.contact().deleteSelectedContact();
        app.closeAlert();
        app.getTo().goToHomePage();
        List<ContactData> after = app.contact().getContactList();
        before.remove(before.size() - 1);

        assertEquals(
                before,
                after,
                "The contact: " + contact.getLastName() + " " + contact.getFirstName() + " was not deleted"
        );
    }
}
