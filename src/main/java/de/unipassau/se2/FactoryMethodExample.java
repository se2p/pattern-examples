package de.unipassau.se2;

public class FactoryMethodExample {

    abstract class Creator {
        protected abstract int factoryMethod();

        public void doOperation() {
            int x = factoryMethod();
            System.out.println("The value is "+x);
        }
    }

    class ConcreteCreatorA extends Creator {
        @Override
        protected int factoryMethod() {
            return 0;
        }
    }

    class ConcreteCreatorB extends Creator {
        @Override
        protected int factoryMethod() {
            return 42;
        }
    }

    public void demo() {
        Creator cb = new ConcreteCreatorB();
        cb.doOperation();


    }

    public static void main(String[] args) {
        new FactoryMethodExample().demo();
    }
}
