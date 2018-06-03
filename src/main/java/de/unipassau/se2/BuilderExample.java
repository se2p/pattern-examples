package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class BuilderExample {

    interface Builder {
        Builder addNumber(int x);
        List<Integer> getProduct();
    }

    class ConcreteBuilder implements Builder {
        private List<Integer> theList = new ArrayList<>();
        @Override
        public Builder addNumber(int x) {
            theList.add(x);
            return this;
        }

        @Override
        public List<Integer> getProduct() {
            return theList;
        }
    }

    public void demo() {
        ConcreteBuilder builder = new ConcreteBuilder();
        builder.addNumber(0);
        builder.addNumber(5);
        builder.addNumber(10);
        System.out.println(builder.getProduct());

        ConcreteBuilder builder2 = new ConcreteBuilder();
        builder2.addNumber(0).addNumber(5).addNumber(10);
        System.out.println(builder2.getProduct());

    }

    public static void main(String[] args) {
        new BuilderExample().demo();
    }
}
