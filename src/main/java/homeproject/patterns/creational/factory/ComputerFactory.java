package homeproject.patterns.creational.factory;

/**
 * The factory design pattern is used when we have a superclass with multiple subclasses and based on input, we need to return one of the subclass.
 * This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.
 *
 * 1. Factory design pattern provides approach to code for interface rather than implementation.
 * 2. Factory pattern removes the instantiation of actual implementation classes from client code.
 *    Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.
 * 3. Factory pattern provides abstraction between implementation and client classes through inheritance.
 */
public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu);
        } else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
        }
        return null;
    }
}
