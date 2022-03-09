package homeproject.patterns.creational.builder;

public class BuilderPatternTest {

    public void testBuilder() {
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder("500 GB", "2 GB")
                .withBluetoothEnabled(true)
                .withGraphicsCardEnabled(true)
                .build();
    }

}
