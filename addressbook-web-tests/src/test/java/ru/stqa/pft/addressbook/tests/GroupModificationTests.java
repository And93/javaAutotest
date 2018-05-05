package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getTo().groupPage();

        if (app.group().all().size() == 0) {
            app.group()
                    .create(
                            new GroupData()
                                    .withNameGroup("test1")
                                    .withHeader("test2")
                                    .withFooter("test3")
                    );
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.group().all();

        GroupData modifiedGroup = before.iterator().next();

        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withNameGroup("modification1")
                .withHeader("modification2")
                .withFooter("modification3");

        app.group().modify(group);

        Groups after = app.group().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
