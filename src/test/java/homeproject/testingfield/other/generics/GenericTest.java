package homeproject.testingfield.other.generics;

import homeproject.testingfield.other.equalshashcode.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {

    @Test
    public void test() {
        // instance of Integer type
        GenericClass<Integer> iObj = new GenericClass<Integer>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        GenericClass<String> sObj = new GenericClass<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());

        // generic function
        genericDisplay(new Person("John", "Mexico", 20));
        genericDisplay(143);

        System.out.println("Total sum is:" + sum(Arrays.asList(1, 2, 43, 523, 1, 2)));
        System.out.println("Total sum is:" + sum(Arrays.asList(1.5, 2.2, 43.6, 523.9, 1.92)));

        print(Arrays.asList("this", "that", "o", 1, 234, 56.7));
        ArrayList<Object> list = new ArrayList<>();
        list.add("this");
        list.add("that");
        list.add("o");
        list.add(1);
        list.add(234);
        print(list);
    }

    <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }

    // wildcard example
    private double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number i : list) {
            sum += i.doubleValue();
        }

        return sum;
    }

    private void print(List<?> list) { // same as List<? extends Object>
        list.forEach(System.out::println);
    }
}
