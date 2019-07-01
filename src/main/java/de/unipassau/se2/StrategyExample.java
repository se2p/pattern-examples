package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class StrategyExample {


    interface Component {
        void doOperation();
        void add(Component c);
    }

    interface Strategy {
        String formatLeaf(String name);
    }

    class ConcreteStrategy implements Strategy {
        @Override
        public String formatLeaf(String name) {
            return "Operation performed on "+name;
        }
    }

    class PrettyPrintStrategy implements Strategy {
        @Override
        public String formatLeaf(String name) {
            return "*** Lovely operation beautifully performed on "+name+" ***";
        }
    }

    class Leaf implements Component {

        private String name;

        private Strategy formatStrategy = new ConcreteStrategy();

        public void setFormatStrategy(Strategy strategy) {
            formatStrategy = strategy;
        }

        public Leaf(String name) {
            this.name = name;
        }

        @Override
        public void doOperation() {
            System.out.println(formatStrategy.formatLeaf(name));
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

    public void demo() {
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        Leaf leaf3 = new Leaf("Leaf 3");
        Leaf leaf4 = new Leaf("Leaf 4");

        leaf3.setFormatStrategy(new PrettyPrintStrategy());


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
        new StrategyExample().demo();
    }
}
