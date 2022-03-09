package homeproject.testingfield.other.equalshashcode;

import java.util.Objects;

public final class NoEqualsPerson {

    private final String name;
    private final String town;
    private final int age;

    public NoEqualsPerson(String name, String town, int age) {
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
    public int hashCode() {
        return Objects.hash(name, town, age);
    }
}
