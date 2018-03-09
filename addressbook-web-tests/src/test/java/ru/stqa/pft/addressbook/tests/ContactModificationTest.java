package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "MyFirstName",
                    "MyMiddleName",
                    "MyLastName",
                    "MyNickName",
                    "MyTitle",
                    "MyCompany",
                    "MyAddress",
                    "Home",
                    " + 00000 211111 10011001410410",
                    "784818181121",
                    "2222222",
                    "nvbnvhbrt@vdfkmvdd.rogprekgo",
                    "sfsjdn@lkcdmklsm.peppe",
                    "[s[s[s[s[s[s[s[s[@cddcd.[q[q",
                    "address 25",
                    "here",
                    "null",
                    "modification1"), true);
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContact(new ContactData(
                "FirstName",
                "MiddleName",
                "LastName",
                "NickName",
                "Title",
                "Company",
                "Address",
                "Home",
                " + 00000 211111",
                "784818181121",
                "2222222",
                "null",
                "sfsjdn@lkcdmklsm.peppe",
                "[s[s[s[s[s[s[s[s[@cddcd.[q[q",
                "address 69",
                "null",
                "null",
                "modification1"), false
        );
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }
}
