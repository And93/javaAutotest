package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;
    private final String email1;

    private String group;

    public ContactData(String firstName, String middleName, String lastName, String nickName, String email1, String group) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email1 = email1;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail1() {
        return email1;
    }

    public String getGroup() {
        return group;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lastName);
    }
}
