package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        app.getTo().groupPage();

        if (app.group().all().size() == 0) {
            app.group()
                    .create(
                            new GroupData()
                                    .withNameGroup(TestBase.getDataProperties("groupName_3"))
                                    .withHeader(TestBase.getDataProperties("header_3"))
                                    .withFooter(TestBase.getDataProperties("footer_3"))
                    );
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deleteGroup = before.iterator().next();
        app.group().delete(deleteGroup);

        assertEquals(
                app.group().count(),
                before.size() - 1,
                "The group was not deleted, and the number of groups is not equal to the expected result"
        );

        Groups after = app.group().all();

        assertEquals(
                after,
                before.without(deleteGroup),
                "The group with id: " + deleteGroup.getId() + " was not deleted"
        );
    }
}
