package homeproject.testingfield.other.innerclass;

import org.junit.jupiter.api.Test;

public class Outer {
    private final int x = 10;
    static int y = 12;

    public class Inner { // non-static nested class
//        static int x = 7;
        int y = 5;

        public int myInnerMethod() {
            return x;
        }
    }

    @Test
    public void test() {
        Outer myOuter = new Outer();
        Outer.Inner myInner = myOuter.new Inner();
        System.out.println(myInner.y + myOuter.x + Outer.y);
        System.out.println(myInner.myInnerMethod());
    }

}