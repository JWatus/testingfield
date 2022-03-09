package homeproject.testingfield.other.equalshashcode;

public final class NoHashcodeAndEqualsPerson {

    private final String name;
    private final String town;
    private final int age;

    public NoHashcodeAndEqualsPerson(String name, String town, int age) {
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

}
