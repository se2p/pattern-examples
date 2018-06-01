package de.unipassau.se2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StrategyExample {

    interface Strategy {
        void doTheAlgorithm(List<Integer> aList);
    }

    class ConcreteStrategyA implements Strategy {
        @Override
        public void doTheAlgorithm(List<Integer> aList) {
            aList.stream().sorted().forEach(i -> System.out.println("Element "+i));
        }
    }

    class ConcreteStrategyB implements Strategy {
        @Override
        public void doTheAlgorithm(List<Integer> aList) {
            aList.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.println("Element "+i));
        }
    }

    public void printTheList(List<Integer> aList, Strategy printingStrategy) {
        printingStrategy.doTheAlgorithm(aList);
    }

    public void demo() {
        List<Integer> myList = Arrays.asList(4, 7, 1, 9, 12);
        ConcreteStrategyA strategyA = new ConcreteStrategyA();
        ConcreteStrategyB strategyB = new ConcreteStrategyB();

        printTheList(myList, strategyA);
        printTheList(myList, strategyB);
    }

    public static void main(String[] args) {
        new StrategyExample().demo();
    }
}
