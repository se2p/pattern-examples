package de.unipassau.se2;

public class AdapterExample {

    class Adaptee {
        void theMethodThatShouldBeAdapted() {
            System.out.println("This is the adapted method");
        }
    }

    interface Target {
        void doSomeFoo();
    }

    class Adapter implements Target {
        private Adaptee adaptee = new Adaptee();

        @Override
        public void doSomeFoo() {
            adaptee.theMethodThatShouldBeAdapted();
        }
    }

    public void demo() {
        Adapter a = new Adapter();
        a.doSomeFoo();
    }

    public static void main(String[] args) {
        new AdapterExample().demo();
    }
}
