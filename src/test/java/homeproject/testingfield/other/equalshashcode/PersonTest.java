package homeproject.testingfield.other.equalshashcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

    @Test
    void checkPerson() {
        // hashcode & equals
        Person person1 = new Person("John", "London", 35);
        Person person11 = new Person("John", "London", 35);
        Person person2 = new Person("Sarah", "New York", 28);

        assertEquals(person1, person11);
        assertEquals(person1.hashCode(), person11.hashCode());

        assertNotEquals(person1, person2);
        assertNotEquals(person1.hashCode(), person2.hashCode());

        Set<Person> personSet = new HashSet<>(Arrays.asList(person1, person11));
        assertEquals(1, personSet.size());

        //
        AnotherPerson anotherPerson = new AnotherPerson("John", "London", 35);

        assertNotEquals(person1, anotherPerson);
        assertEquals(person1.hashCode(), anotherPerson.hashCode());

        // no hashcode
        NoHashcodePerson noHashcodePerson1 = new NoHashcodePerson("John", "London", 35);
        NoHashcodePerson noHashcodePerson11 = new NoHashcodePerson("John", "London", 35);
        NoHashcodePerson noHashcodePerson2 = new NoHashcodePerson("Sarah", "New York", 28);

        assertNotEquals(person1.hashCode(), noHashcodePerson1.hashCode());

        assertEquals(noHashcodePerson1, noHashcodePerson11);
        assertNotEquals(noHashcodePerson1.hashCode(), noHashcodePerson11.hashCode());
        assertNotEquals(noHashcodePerson1, noHashcodePerson2);
        assertNotEquals(noHashcodePerson1.hashCode(), noHashcodePerson2.hashCode());

        Set<NoHashcodePerson> noHashcodeSet = new HashSet<>(Arrays.asList(noHashcodePerson1, noHashcodePerson11));
        assertEquals(2, noHashcodeSet.size());

        // no equals
        NoEqualsPerson noEqualsPerson1 = new NoEqualsPerson("John", "London", 35);
        NoEqualsPerson noEqualsPerson11 = new NoEqualsPerson("John", "London", 35);
        NoEqualsPerson noEqualsPerson2 = new NoEqualsPerson("Sarah", "New York", 28);

        assertEquals(person1.hashCode(), noEqualsPerson1.hashCode());

        assertNotEquals(noEqualsPerson1, noEqualsPerson11);
        assertEquals(noEqualsPerson1.hashCode(), noEqualsPerson11.hashCode());
        assertNotEquals(noEqualsPerson1, noEqualsPerson2);
        assertNotEquals(noEqualsPerson1.hashCode(), noEqualsPerson2.hashCode());

        Set<NoEqualsPerson> noEqualsSet = new HashSet<>(Arrays.asList(noEqualsPerson1, noEqualsPerson11));
        assertEquals(2, noEqualsSet.size());

        // no hashcode & equals
        NoHashcodeAndEqualsPerson noHashcodeAndEqualsPerson1 = new NoHashcodeAndEqualsPerson("John", "London", 35);
        NoHashcodeAndEqualsPerson noHashcodeAndEqualsPerson2 = new NoHashcodeAndEqualsPerson("John", "London", 35);

        assertNotEquals(noHashcodePerson1, noHashcodePerson2);
        assertNotEquals(noHashcodeAndEqualsPerson1.hashCode(), noHashcodeAndEqualsPerson2.hashCode());

        Set<NoHashcodeAndEqualsPerson> noHashcodeAndEqualsSet = new HashSet<>(Arrays.asList(noHashcodeAndEqualsPerson1, noHashcodeAndEqualsPerson2));
        assertEquals(2, noHashcodeAndEqualsSet.size());
    }

}
