package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private final String nameGroup;
    private int id;
    private final String header;
    private final String footer;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public GroupData(String nameGroup, int id, String header, String footer) {
        this.nameGroup = nameGroup;
        this.id = id;
        this.header = header;
        this.footer = footer;
    }

    public GroupData(String nameGroup, String header, String footer) {
        this.nameGroup = nameGroup;
        this.id = Integer.MAX_VALUE;
        this.header = header;
        this.footer = footer;
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
        return Objects.equals(nameGroup, groupData.nameGroup);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameGroup);
    }
}
