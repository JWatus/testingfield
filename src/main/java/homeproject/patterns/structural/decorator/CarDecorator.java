package homeproject.patterns.structural.decorator;

/**
 * Decorator design pattern is used to modify the functionality of an object at runtime.
 * At the same time other instances of the same class will not be affected by this, so individual object gets the modified behavior.
 *
 * We use inheritance or composition to extend the behavior of an object but this is done at compile time, and it is applicable to all the instances of the class.
 * We can’t add any new functionality of remove any existing behavior at runtime – this is when Decorator pattern comes into picture.
 *
 * Decorator class implements the component interface, and it has a HAS-A relationship with the component interface.
 * The component variable should be accessible to the child decorator classes, so we will make this variable protected.
 *
 * Concrete Decorators – Extending the base decorator functionality and modifying the component behavior accordingly. We can have concrete decorator classes as LuxuryCar and SportsCar
 */
public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}