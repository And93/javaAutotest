package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNewContact() {
        app.getNavigationHelper().addNewContact();
        app.getContactHelper().fillContactGroup(new ContactData(
                "MyFirstName",
                "MyMiddleName",
                "MyLastName",
                "MyNickName",
                "MyTitile",
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
                "null")
        );
        app.getContactHelper().submitContact();
    }
}
