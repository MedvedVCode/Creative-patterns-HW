package people;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this(name, surname);
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this(name, surname);
        this.address = address;
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        this(name, surname, address);
        this.age = age;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.getSurname())
                .setAge(0)
                .setAddress(this.getAddress());
    }

    @Override
    public String toString() {
        String strAge;
        if (hasAge()) {
            strAge = "" + age.getAsInt();
        } else {
            strAge = "не указан";
        }
        return "Person {" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", age = " + strAge +
                ", address = '" + address + '\'' +
                "}\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
