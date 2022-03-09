package homeproject.testingfield.other.inheritance;

import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    void testAnimal() {
        Pigeon pigeon = new Pigeon("pigeonLegs", "wings", "feathers");
        pigeon.eat();
        pigeon.fly();
        pigeon.moveHeadForwardAndBack();

        System.out.println(pigeon.getLegs());
        System.out.println(pigeon.getWings());
        System.out.println(pigeon.getGreyFeathers());

        Bird birdd = new Bird("birdLegs", "wings");
        birdd.eat();
        birdd.fly();

        Animal bird = new Bird("birdLegs", "wings");
        bird.eat();

        Animal animal = new Animal("legs");
        animal.eat();
    }

}
