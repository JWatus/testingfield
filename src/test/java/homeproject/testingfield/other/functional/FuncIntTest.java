package homeproject.testingfield.other.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FuncIntTest {

    @Test
    void testFunction() { // receives one value and returns another
        Function<Integer, String> intToString = Object::toString;
        assertEquals("5", intToString.apply(5));
    }

    @Test
    void testFunctionWithCompose() {
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        assertEquals("'5'", quoteIntToString.apply(5));
    }

    @Test
    void testFunctionWithAndThen() {
        Function<String, Integer> createIntegerAndAddTen = x -> Integer.parseInt(x) + 10;
        Function<Integer, Integer> multiplyByTen = x -> x * 10;

        Stream.of("10", "20", "30")
                .map(createIntegerAndAddTen.andThen(multiplyByTen))
                .forEach(System.out::println);
    }

    @Test
    void testFunctionForPrimitive() {
        int[] array = {1, 2, 3};
        long[] expectedArray = {(long) 1, (long) 2, (long) 3};
        assertArrayEquals(expectedArray, transformArray(array, i -> (long) i));
    }

    public long[] transformArray(int[] array, IntToLongFunction function) {
        long[] transformedArray = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsLong(array[i]);
        }
        return transformedArray;
    }

    ///////////////////////////////////////

    @Test
    void testBiFunction() { // receives two values and returns another
        BiFunction<Long, Integer, String> stringifyNumbers = (longValue, intValue) -> "Long value: " + longValue + ", int value: " + intValue;
        assertEquals("Long value: 1, int value: 7", stringifyNumbers.apply(1L, 7));
    }

    ///////////////////////////////////////

    @Test
    void testSupplier() { // gets nothing and returns something
        Supplier<Object> getString = () -> "Here we go";
        Supplier<Integer> getInt = () -> 90;

        assertEquals("Here we go", getString.get());
        assertEquals(90, getInt.get());
    }

    ///////////////////////////////////////

    @Test
    void testConsumer() { // gets something and returns nothing
        Consumer<String> soutString = System.out::println;
        soutString.accept("Elo elo elo");
    }

    @Test
    void testConsumerAsAMethodsParameter() {
        printMessage(System.out::println, "Message to print");
    }

    void printMessage(Consumer<String> stringConsumer, String message) {
        stringConsumer.accept(message);
    }

    ///////////////////////////////////////

    @Test
    void testPredicate() { // gets value and returns boolean
        List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

        List<String> namesWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        assertEquals(List.of("Angela", "Aaron"), namesWithA);

        Predicate<String> predicate = s -> s.startsWith("A");
        assertTrue(predicate.test("Anatomy"));
        assertFalse(predicate.test("Yyyyy"));
    }

    ///////////////////////////////////////

    @Test
    void testOperator() { // receive and return the same value type
        List<String> names = Arrays.asList("bob", "josh", "megan");
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        names.replaceAll(toUpperCase);

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        BinaryOperator<Integer> integerBinaryOperator = (i1, i2) -> i1 + i2;
        int sum = values.
                stream()
                .reduce(0, integerBinaryOperator);
    }
}
