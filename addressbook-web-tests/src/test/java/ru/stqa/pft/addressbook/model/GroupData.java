package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private String nameGroup;
    private int id = Integer.MAX_VALUE;
    private String header;
    private String footer;

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public int getId() {
        return id;
    }
    public String getNameGroup() {
        return nameGroup;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "nameGroup='" + nameGroup + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(nameGroup, groupData.nameGroup);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameGroup, id);
    }
}
