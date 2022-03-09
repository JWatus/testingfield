package homeproject.testingfield.other.inheritance;

public class Animal {

    private String legs;

    public Animal(String legs) {
        this.legs = legs;
    }

    void eat() {
        System.out.println("Eating.");
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }
}
