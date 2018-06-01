package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class VisitorExample {

    interface Visitor {
        void visit(ElementA e);
        void visit(ElementB e);
    }

    interface Element {
        void accept(Visitor v);
        String getValue();
    }

    class ElementA implements Element {
        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }

        @Override
        public String getValue() {
            return "This is ElementA";
        }
    }

    class ElementB implements Element {
        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }

        @Override
        public String getValue() {
            return "This is ElementB";
        }
    }

    class PrintVisitor implements Visitor {
        @Override
        public void visit(ElementA e) {
            System.out.println("Visiting ElementA: "+e.getValue());
        }

        @Override
        public void visit(ElementB e) {
            System.out.println("Visiting ElementB: " + e.getValue());

        }
    }

    public void demo() {
        List<Element> elements = new ArrayList<>();
        elements.add(new ElementA());
        elements.add(new ElementB());

        PrintVisitor pv = new PrintVisitor();

        for(Element e : elements) {
            e.accept(pv);
        }
    }

    public static void main(String[] args) {
        new VisitorExample().demo();
    }
}
