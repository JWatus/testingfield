package homeproject.testingfield.other;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;

public class SerializationTest {

    @Test
    @Disabled
    void serializationTest() throws IOException, ClassNotFoundException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("objects.bin"))) {
            outputStream.writeObject(1);
            outputStream.writeObject(2);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("objects.bin"))) {
            Integer number = (Integer) inputStream.readObject();
            System.out.println(number);
            number = (Integer) inputStream.readObject();
            System.out.println(number);
        }
    }

}
