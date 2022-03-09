package homeproject.patterns.behavioral.strategy;

/**
 * Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.
 *
 * One of the best example of strategy pattern is Collections.sort() method that takes Comparator parameter.
 * Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.
 */
public interface PaymentStrategy {
    void pay(int amount);
}