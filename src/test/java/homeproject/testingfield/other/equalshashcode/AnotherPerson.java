package homeproject.testingfield.other.equalshashcode;

import java.util.Objects;

public final class AnotherPerson {

    private final String name;
    private final String town;
    private final int age;

    public AnotherPerson(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnotherPerson person = (AnotherPerson) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(town, person.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, town, age);
    }
}
