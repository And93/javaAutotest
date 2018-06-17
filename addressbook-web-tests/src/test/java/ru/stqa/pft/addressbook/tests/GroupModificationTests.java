package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        app.getTo().groupPage();

        if (app.group().all().size() == 0) {
            app.group().create(
                    new GroupData()
                            .withNameGroup(TestBase.getDataProperties("groupName_3"))
                            .withHeader(TestBase.getDataProperties("header_3"))
                            .withFooter(TestBase.getDataProperties("footer_3"))
            );
        }
    }

    @Test
    public void testGroupModification() throws IOException {
        app.getTo().groupPage();
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();

        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withNameGroup(TestBase.getDataProperties("groupName_4"))
                .withHeader(TestBase.getDataProperties("header_4"))
                .withFooter(TestBase.getDataProperties("footer_4"));

        app.group().modify(group);

        assertEquals(
                app.group().count(),
                before.size(),
                "The group was not modification, and the number of groups is not equal to the expected result"
        );

        Groups after = app.group().all();

        assertEquals(
                after,
                before.without(modifiedGroup).withAdded(group),
                "The group: " + modifiedGroup.getNameGroup() + " was not modification to: " + group.getNameGroup()
        );
    }
}
