package homeproject.patterns.structural.decorator;

public class DecoratorPatternTest {

    public void testDecorator() {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }

/*      Basic Car. Adding features of Sports Car.
        *****
        Basic Car. Adding features of Luxury Car. Adding features of Sports Car.
*/

}
