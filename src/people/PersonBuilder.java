package people;

import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null || name.isEmpty() || surname.isEmpty()) {
            throw new IllegalStateException("Не хватает параметров для конструктора Person");
        }
        if (!age.isEmpty() && age.getAsInt() < 0) {
            throw new IllegalArgumentException("Возраст меньше нуля");
        }
        return new Person(name, surname, age, address);
    }
}
