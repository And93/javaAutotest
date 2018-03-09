package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNewContact() {
        app.getNavigationHelper().goToHomePage();
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
}
