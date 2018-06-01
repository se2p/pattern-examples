package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class CompositeExample {

    interface Component {
        void theOperation();
    }

    class Composite implements Component {
        private List<Component> children = new ArrayList<>();

        public void add(Component c) {
            children.add(c);
        }

        public void remove(Component c) {
            children.remove(c);
        }

        public Component getChild(int i) {
            return children.get(i);
        }

        @Override
        public void theOperation() {
            for(Component c : children) {
                c.theOperation();
            }
        }
    }

    class Leaf implements Component {
        private String name;

        public Leaf(String name) {
            this.name = name;
        }

        @Override
        public void theOperation() {
            System.out.println("This is leaf component "+name);
        }
    }

    public void demo() {
        Composite comp1 = new Composite();
        Composite comp2 = new Composite();
        Composite comp3 = new Composite();

        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        Leaf leaf3 = new Leaf("Leaf 3");
        Leaf leaf4 = new Leaf("Leaf 4");

        comp1.add(comp2);
        comp1.add(comp3);

        comp2.add(leaf1);
        comp2.add(leaf2);

        comp3.add(leaf3);
        comp3.add(leaf4);

        comp1.theOperation();
    }

    public static void main(String[] args) {
        new CompositeExample().demo();
    }

}
