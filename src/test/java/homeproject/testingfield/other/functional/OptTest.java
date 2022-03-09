package homeproject.testingfield.other.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class OptTest {

    @Test
    void testIfPresent() {
        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    void testOrElse() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("john", name);
    }

    @Test
    void testOrElseGet() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals("john", name);
    }

    /**
     * When using orElseGet() to retrieve the wrapped value, the getMyDefault() method is not even invoked since the contained value is present.
     *
     * However, when using orElse(), whether the wrapped value is present or not, the default object is created.
     * So in this case, we have just created one redundant object that is never used.
     */
    @Test
    public void whenOrElseGetAndOrElse() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultText
                = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text present", defaultText);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text present", defaultText);
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    @Test()
    public void testOrElseThrow() {
        String nullName = "not null";
        String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * get() can only return a value if the wrapped object is not null; otherwise, it throws a no such element exception.
     * This is the major flaw of the get() method. Ideally, Optional should help us avoid such unforeseen exceptions.
     * Therefore, this approach works against the objectives of Optional and will probably be deprecated in a future release.
     */
    @Test()
    public void testGet() {
        Optional<String> opt = Optional.of("baeldung");
        String name = opt.get();
        assertEquals("baeldung", name);
    }

    @Test
    void testFilter() {
        assertTrue(priceIsInRange(new Modem(10.0)));
        assertFalse(priceIsInRange(new Modem(9.9)));
        assertFalse(priceIsInRange(new Modem(null)));
        assertFalse(priceIsInRange(new Modem(15.5)));
        assertFalse(priceIsInRange(null));
    }

    public boolean priceIsInRange(Modem modem2) {
        return Optional.ofNullable(modem2)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }

    public class Modem {
        private final Double price;

        public Modem(Double price) {
            this.price = price;
        }

        public Double getPrice() {
            return price;
        }
    }

    @Test
    public void testMap() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional
                .map(List::size)
                .orElse(0);
        assertEquals(6, size);

        String name = "baeldung";
        Optional<String> nameOptional = Optional.of(name);

        int len = nameOptional
                .map(String::length)
                .orElse(0);
        assertEquals(8, len);
    }

    ///// JDK 9

    @Test
    public void testOr() {
        //given
        String expected = "properValue";
        Optional<String> value = Optional.of(expected);
        Optional<String> defaultValue = Optional.of("default");

        //when
        Optional<String> result = value.or(() -> defaultValue);

        //then
        assertEquals(expected, result.get());
    }

    /**
     * When we have an Optional instance, often we want to execute a specific action on the underlying value of it.
     * On the other hand, if the Optional is empty we want to log it or track that fact by incrementing some metric.
     * <p>
     * The ifPresentOrElse() method is created exactly for such scenarios. We can pass a Consumer that will be invoked
     * if the Optional is defined, and Runnable that will be executed if the Optional is empty.
     */
    @Test
    public void testIfPresentOrGet() {
        // given
        Optional<String> value = Optional.of("properValue");
        AtomicInteger successCounter = new AtomicInteger(0);
        AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

        // when
        value.ifPresentOrElse(
                v -> successCounter.incrementAndGet(),
                onEmptyOptionalCounter::incrementAndGet);

        // then
        assertEquals(1, successCounter.get());
        assertEquals(0, onEmptyOptionalCounter.get());
    }

    @Test
    public void testStream() {
        // given
        Optional<String> value = Optional.of("a");

        // when
        List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList());

        // then
        assertEquals(List.of("A"), collect);
    }
}
