package homeproject.patterns.creational.singleton;

/**
 * Unlike other solutions enum doesn't allow creating second singleton instance through reflection
 * Enum value is instantiated only once in a Java program
 * Does not allow lazy initialization
 */

public enum EnumSingleton {

    INSTANCE;

    public static void doSomething() {
        //do something
    }
}