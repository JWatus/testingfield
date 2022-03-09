package homeproject.testingfield.other.equalshashcode;

import java.util.Objects;

public final class NoHashcodePerson {

    private final String name;
    private final String town;
    private final int age;

    public NoHashcodePerson(String name, String town, int age) {
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
        NoHashcodePerson person = (NoHashcodePerson) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(town, person.town);
    }

}
