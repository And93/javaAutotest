package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    private static final String PHOTO_PATH = PATH_TO_RESOURCES + "avatar.jpg";

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        app.getTo().groupPage();
        app.group().create(new GroupData().withNameGroup(TestBase.getDataProperties("groupName_1")));
    }

    @Test
    public void testNewContact() throws IOException {
        app.getTo().goToHomePage();
        List<ContactData> before = app.contact().getContactList();
        File photo = new File(PHOTO_PATH);

        ContactData contact = new ContactData()
                .withFirstName(TestBase.getDataProperties("firstName_1"))
                .withMiddleName(TestBase.getDataProperties("middleName_1"))
                .withLastName(TestBase.getDataProperties("lastName_1"))
                .withNickName(TestBase.getDataProperties("nickName_1"))
                .withFirstEmail(TestBase.getDataProperties("firstEmail_1"))
                .withGroup(TestBase.getDataProperties("groupName_1"))
                .withPhoto(photo);

        app.contact().createContact(contact, true);
        app.getTo().goToHomePage();
        List<ContactData> after = app.contact().getContactList();
        before.add(contact);
        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.sort(byLastName);
        after.sort(byLastName);

        assertEquals(
                before,
                after,
                "The contact: " + contact.getLastName() + " " + contact.getFirstName() + " was not created"
        );
    }
}
