package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class VisitorExample {


    interface Visitable {
        void accept(Visitor v);
    }

    interface Component extends Visitable {
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

        @Override
        public void accept(Visitor v) {
            v.visit(this);
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

        @Override
        public void accept(Visitor v) {
            v.visit(this);

        }
    }

    interface Visitor {
        void visit(Leaf l);
        void visit(Composite c);
    }

    class PrintVisitor implements Visitor {
        @Override
        public void visit(Leaf l) {
            System.out.println("Here's a leaf: "+l.name);
        }

        @Override
        public void visit(Composite c) {
            System.out.println("Here's a composite with "+c.children.size()+" children");
            c.children.stream().forEach(child -> child.accept(this));
        }
    }

    public void demo() {
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");
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

        PrintVisitor visitor = new PrintVisitor();
        comp1.accept(visitor);
    }

    public static void main(String[] args) {
        new VisitorExample().demo();
    }
}
