package com.jsp.chap05;

import java.util.Objects;

public class Person {

    private int id;
    private String PersonName;
    private int PersonAge;

    public Person(int id, String personName, int personAge) {
        this.id = id;
        PersonName = personName;
        PersonAge = personAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public int getPersonAge() {
        return PersonAge;
    }

    public void setPersonAge(int personAge) {
        PersonAge = personAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && PersonAge == person.PersonAge && Objects.equals(PersonName, person.PersonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, PersonName, PersonAge);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", PersonName='" + PersonName + '\'' +
                ", PersonAge=" + PersonAge +
                '}';
    }
}
