package homeproject.patterns.creational.abstractfactory;

/**
 * If you are familiar with factory design pattern in java, you will notice that we have a single Factory class.
 * This factory class returns different subclasses based on the input provided and factory class uses if-else or switch statement to achieve this.
 * <p>
 * In the Abstract Factory pattern, we get rid of if-else block and have a factory class for each subclass.
 * Then an Abstract Factory class that will return the subclass based on the input factory class.
 *
 * 1. Abstract Factory design pattern provides approach to code for interface rather than implementation.
 * 2. Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, for example we can add another subclass Laptop and a factory LaptopFactory.
 * 3. Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.
 */
public interface ComputerAbstractFactory {
    Computer createComputer();
}
