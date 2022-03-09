package homeproject.testingfield.other.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

public class IterationExampleTest {

    @Test
    void testListIterations() {
        List<String> sampleList = new ArrayList<>();
        sampleList.add("Marcin");
        sampleList.add("Adela");
        sampleList.add("Marek");
        sampleList.add("Magda");

        System.out.println("Iterowanie po liscie (foreach)");
        for (String item : sampleList) {
            System.out.println(item);
        }

        System.out.println("Iterowanie po liscie (for)");
        for (int index = 0; index < sampleList.size(); index++) {
            System.out.println(sampleList.get(index));
        }

        int index = 0;
        System.out.println("Iterowanie po liscie (while)");
        while (index < sampleList.size()) {
            System.out.println(sampleList.get(index));
            index++;
        }
    }

    @Test
    void testSetIterations() {
        Set<String> sampleSet = new HashSet<>();
        sampleSet.add("Marcin");
        sampleSet.add("Adela");
        sampleSet.add("Marek");
        sampleSet.add("Magda");
        sampleSet.add("Marek");

        System.out.println("Iterowanie po secie (foreach)");
        for (String item : sampleSet) {
            System.out.println(item);
        }
    }

    @Test
    void testMapIterations() {
        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("Marek", "Magda");
        sampleMap.put("Marcin", "Adela");

        System.out.println("Iterowanie po wartosciach");
        for (String value : sampleMap.values()) {
            System.out.println(value);
        }

        System.out.println("Iterowanie po kluczach i pobieranie wartosci");
        for (String key : sampleMap.keySet()) {
            String value = sampleMap.get(key);
            System.out.println(key + ": " + value);
        }

        System.out.println("Iterowanie po kluczach i wartosciach");
        for (Map.Entry<String, String> entry : sampleMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }
}
