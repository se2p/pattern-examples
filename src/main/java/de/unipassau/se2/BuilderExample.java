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

    class SquaredConcreteBuilder implements Builder {
        private List<Integer> theList = new ArrayList<>();

        @Override
        public Builder addNumber(int x) {
            theList.add(x * x);
            return this;
        }

        @Override
        public List<Integer> getProduct() {
            return theList;
        }
    }

    public void demo() {
        Builder builder = new SquaredConcreteBuilder();
        builder.addNumber(0).addNumber(42).addNumber(100);
        System.out.println(builder.getProduct());
    }

    public static void main(String[] args) {
        new BuilderExample().demo();
    }

}
