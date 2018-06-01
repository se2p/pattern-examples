package de.unipassau.se2;

public class AbstractFactoryExample {

    interface AbstractProductA {
        String getValue();
    }

    class ConcreteProductA1 implements AbstractProductA {
        @Override
        public String getValue() {
            return "This is a concrete A product";
        }
    }

    class ConcreteProductA2 implements AbstractProductA {
        @Override
        public String getValue() {
            return "This is the other concrete A product";
        }
    }

    interface AbstractProductB {
        int getValue();
    }

    class ConcreteProductB1 implements AbstractProductB {
        @Override
        public int getValue() {
            return 0;
        }
    }

    class ConcreteProductB2 implements AbstractProductB {
        @Override
        public int getValue() {
            return 100;
        }
    }

    interface AbstractFactory {
        AbstractProductA createA();
        AbstractProductB createB();
    }

    class ConcreteFactory1 implements AbstractFactory {
        @Override
        public AbstractProductA createA() {
            return new ConcreteProductA1();
        }

        @Override
        public AbstractProductB createB() {
            return new ConcreteProductB1();
        }
    }

    class ConcreteFactory2 implements AbstractFactory {
        @Override
        public AbstractProductA createA() {
            return new ConcreteProductA2();
        }

        @Override
        public AbstractProductB createB() {
            return new ConcreteProductB2();
        }
    }

    public void printProducts(AbstractFactory factory) {
        AbstractProductA a = factory.createA();
        AbstractProductB b = factory.createB();
        System.out.println(a.getValue() +": "+b.getValue());
    }

    public void demo() {
        ConcreteFactory1 factory1 = new ConcreteFactory1();
        ConcreteFactory2 factory2 = new ConcreteFactory2();
        printProducts(factory1);
        printProducts(factory2);
    }

    public static void main(String[] args) {
        new AbstractFactoryExample().demo();
    }
}
