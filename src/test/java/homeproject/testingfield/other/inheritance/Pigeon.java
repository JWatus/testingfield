package homeproject.testingfield.other.inheritance;

public class Pigeon extends Bird {

    private String greyFeathers;

    public Pigeon(String legs, String wings, String greyFeathers) {
        super(legs, wings);
        this.greyFeathers = greyFeathers;
    }

    public String getGreyFeathers() {
        return greyFeathers;
    }

    void moveHeadForwardAndBack(){
        System.out.println("Pigeoning.");
    }

    public void setGreyFeathers(String greyFeathers) {
        this.greyFeathers = greyFeathers;
    }
}
