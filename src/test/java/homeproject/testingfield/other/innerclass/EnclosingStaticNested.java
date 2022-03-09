package homeproject.testingfield.other.innerclass;

import org.junit.jupiter.api.Test;

public class EnclosingStaticNested {

    private static int x = 1;
    private int y = 2;

    public static class StaticNested {

        private static int x = 11;
        private int y = 22;

        private void run() {
            System.out.println(EnclosingStaticNested.x);
//            System.out.println(EnclosingStaticNested.y);
            System.out.println(StaticNested.x);
            System.out.println(this.y);
            System.out.println(y);
        }
    }

    @Test
    public void test() {
        EnclosingStaticNested.StaticNested nested = new EnclosingStaticNested.StaticNested();
        nested.run();
    }
}