package de.unipassau.se2;

public class DecoratorExample {

    class A {
        public void doIt() {
            System.out.println("A");
        }
    }

    public void demoBasic() {
        A[] aArray = {new A(), new A(), new A()};
        for(A a : aArray) {
            a.doIt();
        }
    }


    class AwithX extends A {
        @Override
        public void doIt() {
            super.doIt();
            System.out.println("Also doing X");
        }
    }

    class AwithY extends A {
        @Override
        public void doIt() {
            super.doIt();
            System.out.println("Also doing Y");
        }
    }

    class AwithXY extends AwithX {
        @Override
        public void doIt() {
            super.doIt();
            System.out.println("Also doing Y");
        }
    }

    public void demoDecorated() {
        A[] aArray = {new AwithX(), new AwithY(), new AwithXY()};
        for(A a : aArray) {
            a.doIt();
        }
    }

    public static void main(String[] args) {
//        new DecoratorExample().demoBasic();
        new DecoratorExample().demoDecorated();
    }
}
