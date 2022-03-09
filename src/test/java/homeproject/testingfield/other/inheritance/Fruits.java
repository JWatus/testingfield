package homeproject.testingfield.other.inheritance;

import org.junit.jupiter.api.Test;

class Fruits {

    // Class 1
    // Super Class
    class Fruit {

        // Method inside super class
        public Fruit() {

            // Print statement
            System.out.println("Super class constructor");

            // Displaying object hashcode of super class
            System.out.println("Super class object hashcode :" +
                    this.hashCode());

            System.out.println(this.getClass().getName());
        }
    }

    // Class 2
    // Sub class extending above super class
    class Apple extends Fruit {

        // Method inside sub class
        public Apple() {

            // Print statement
            System.out.println("Subclass constructor invoked");

            // Displaying object hashcode of sub class
            System.out.println("Sub class object hashcode :" +
                    this.hashCode());

            System.out.println(this.hashCode() + " " +
                    super.hashCode());

            System.out.println(this.getClass().getName() + " " +
                    super.getClass().getName());
        }
    }

    @Test
    // Main driver method
    public void test() {
        // Creating an instance of above class
        Apple myApple = new Apple();
        System.out.println("------------------");
        Fruit myFruit = new Apple();
    }
}