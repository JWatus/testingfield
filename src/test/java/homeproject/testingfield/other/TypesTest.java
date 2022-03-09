package homeproject.testingfield.other;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TypesTest {

    @Test
    void stringTest() {

        // CREATING AND GETTING
        String str1 = "Java";
        String str2 = new String("Java");
        assertEquals(str1, str2);
        assertNotSame(str1, str2);

        // intern() - getting string from the string pool
        String str11 = new String("Javka");
        String str21 = new String("Javka");
        String v1 = str11.intern();
        String v2 = str21.intern();
        assertEquals(str11, str21);
        assertNotSame(str11, str21);
        assertEquals(v1, v2);
        assertSame(v1, v2);

        // TYPE CONVERSION
        // arrays
        String str = "Jav1";
        char[] actualCharArray = str.toCharArray();
        char[] expectedCharArray = {'J', 'a', 'v', '1'};
        assertArrayEquals(expectedCharArray, actualCharArray);

        String[] array = {"a", "b", "c"};
        String actualValue = Arrays.toString(array);
        String expectedValue = "[a, b, c]";
        assertEquals(expectedValue, actualValue);

        actualValue = String.join(", ", array);
        expectedValue = "a, b, c";
        assertEquals(expectedValue, actualValue);

        // int to string
        Integer i = 123;
        String expectedValue1 = "123";

        String actualValue1 = Integer.toString(i);
        assertEquals(expectedValue1, actualValue1);

        actualValue1 = String.valueOf(i);
        assertEquals(expectedValue1, actualValue1);

        // string to int
        actualValue1 = i.toString();
        assertEquals(expectedValue1, actualValue1);

        String str111 = "123";
        Integer valueOf = Integer.valueOf(str111);
        assertEquals(Integer.valueOf(123), valueOf);

        int parseInt = Integer.parseInt(str111);
        assertEquals(123, parseInt);
    }

    @Test
    void stringBuilderTest() {
        StringBuilder sb = new StringBuilder();
        sb.append("Java");
        sb.append(' ');
        sb.append("Rocks").append("!").append(0);
        String value = sb.toString();
        assertEquals("Java Rocks!0", value);
    }

    @Test
    void bigDecimalVsDoubleTest() {
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);
    }

    @Test
    void absTest() {

        Integer a = -8;
        double d = -100;
        float f = -90;

        System.out.println(Math.abs(a));
        System.out.println(Math.abs(d));
        System.out.println(Math.abs(f));
    }

}
