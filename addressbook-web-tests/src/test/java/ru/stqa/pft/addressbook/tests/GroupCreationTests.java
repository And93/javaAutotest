package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.data.InvalidGroupsData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws IOException {
        app.getTo().groupPage();
        Groups before = app.group().all();

        GroupData group = new GroupData()
                .withNameGroup(TestBase.getDataProperties("groupName_3"))
                .withHeader(TestBase.getDataProperties("header_3"))
                .withFooter(TestBase.getDataProperties("footer_3"));

        app.group().create(group);

        assertEquals(
                app.group().count(),
                before.size() + 1,
                "The group was not created, and the number of groups is not equal to the expected result"
        );

        Groups after = app.group().all();

        assertEquals(
                after,
                before.withAdded(group.withId(after.stream().mapToInt((GroupData g) -> g.getId()).max().getAsInt())),
                "The group: " + group.getNameGroup() + " was not added"
        );
    }

    @Test(dataProviderClass = InvalidGroupsData.class, dataProvider = "invalidGroups")
    public void testBadGroupCreation(GroupData group) {
        app.getTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);

        assertEquals(
                app.group().count(),
                before.size(),
                "The group was created and the number of groups is incorrect"
        );

        Groups after = app.group().all();

        assertEquals(
                after,
                before,
                "The group was created with wrong param: '"
        );
    }
}
