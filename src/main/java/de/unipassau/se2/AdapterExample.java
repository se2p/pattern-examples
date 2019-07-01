package de.unipassau.se2;

public class AdapterExample {

    class Adaptee {
        void someOldMethod() {
            System.out.println("This is what we want to call");
        }
    }

    interface Target {
        void doSomethingNew();
    }

    class Adapter implements Target {
        private Adaptee adaptee = new Adaptee();

        @Override
        public void doSomethingNew() {
            adaptee.someOldMethod();
        }
    }

    public void demo() {
        Adapter adapter = new Adapter();
        adapter.doSomethingNew();
    }

    public static void main(String[] args) {
        new AdapterExample().demo();
    }
}
