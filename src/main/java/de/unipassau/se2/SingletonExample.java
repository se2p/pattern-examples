package de.unipassau.se2;

public class SingletonExample {

    static class Singleton {
        private static Singleton instance = null;

        private Singleton() {}

        public static Singleton getInstance() {
            if(instance == null)
                instance = new Singleton();

            return instance;
        }

        private int counter = 0;

        public void printCounterAndIncrement() {
            System.out.println("Counter: "+counter);
            counter++;
        }
    }

    public void demo() {
        Singleton.getInstance().printCounterAndIncrement();
        Singleton singleton = Singleton.getInstance();
        singleton.printCounterAndIncrement();
    }

    public static void main(String[] args) {
        new SingletonExample().demo();
        Singleton.getInstance().printCounterAndIncrement();
    }
}
