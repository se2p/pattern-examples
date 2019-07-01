package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class DecoratorExample {



    interface Component {
        void doOperation();
        void add(Component c);
    }

    class Leaf implements Component {

        private String name;

        public Leaf(String name) {
            this.name = name;
        }

        @Override
        public void doOperation() {
            System.out.println(name);
        }

        @Override
        public void add(Component c) {

        }
    }

    class Composite implements Component {

        private List<Component> children = new ArrayList<>();

        @Override
        public void doOperation() {
            children.stream().forEach(Component::doOperation);
        }

        @Override
        public void add(Component c) {
            children.add(c);
        }
    }

    abstract class Decorator implements Component {
        private Component component;

        public Decorator(Component c) {
            component = c;
        }

        @Override
        public void doOperation() {
            component.doOperation();
        }

        @Override
        public void add(Component c) {
            component.add(c);
        }
    }

    class ConcreteDecoratorA extends Decorator {
        public ConcreteDecoratorA(Component c) {
            super(c);
        }

        @Override
        public void doOperation() {
            super.doOperation();
            System.out.println("...Some extra functionality");
        }
    }

    public void demo() {
        Component leaf1 = new ConcreteDecoratorA(new Leaf("Leaf 1"));
        Component leaf2 = new ConcreteDecoratorA(new Leaf("Leaf 2"));
        Component leaf3 = new Leaf("Leaf 3");
        Component leaf4 = new Leaf("Leaf 4");

        Component comp1 = new Composite();
        Component comp2 = new Composite();
        Component comp3 = new Composite();

        comp1.add(comp2);
        comp1.add(comp3);

        comp3.add(leaf3);
        comp3.add(leaf4);
        comp2.add(leaf1);
        comp2.add(leaf2);

        comp1.doOperation();

    }

    public static void main(String[] args) {
        new DecoratorExample().demo();
    }

}
