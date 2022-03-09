package homeproject.testingfield.other.inheritance;

public class Bird extends Animal{

    private String wings;

    public Bird(String legs, String wings) {
        super(legs);
        this.wings = wings;
    }

    void fly() {
        System.out.println("Flying.");
    }

    void eat() {
        System.out.println("Bird eating.");
    }


    public String getWings() {
        return wings;
    }

    public void setWings(String wings) {
        this.wings = wings;
    }
}
