package homeproject.patterns.structural.bridge;

/**
 * Decouple an abstraction from its implementation so that the two can vary independently.
 * The implementation of bridge design pattern follows the notion to prefer Composition to inheritance.
 */
public class BridgePatternTest {

    public void testBridge() {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }

}
