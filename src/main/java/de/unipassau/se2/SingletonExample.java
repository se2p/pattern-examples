package de.unipassau.se2;

public class SingletonExample {

    static class Singleton {
        private Singleton() { }

        private static Singleton instance = null;

        public static Singleton getInstance() {
            if(instance == null)
                instance = new Singleton();

            return instance;
        }

        private int counter = 0;

        public void printAndIncreaseCounter() {
            System.out.println("Current count: "+counter);
            counter++;
        }
    }

    public void demo() {
        Singleton.getInstance().printAndIncreaseCounter();
        Singleton.getInstance().printAndIncreaseCounter();
        Singleton.getInstance().printAndIncreaseCounter();
    }

    public static void main(String[] args) {
        new SingletonExample().demo();
    }
}
