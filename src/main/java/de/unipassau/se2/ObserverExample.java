package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
    interface Observer {
        void update(Subject s);
    }

    interface Subject {
        void attach(Observer o);
        void detach(Observer o);
        void notifyObservers();
        String getName();
    }

    class ConcreteSubject implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String name;

        public ConcreteSubject(String name) {
            this.name = name;
        }

        @Override
        public void attach(Observer o) {
            observers.add(o);
        }

        @Override
        public void detach(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for(Observer o : observers) {
                o.update(this);
            }
        }

        public void makeChange() {
            // ...
            notifyObservers();
        }

        public String getName() {
            return name;
        }
    }

    class ConcreteObserver implements Observer {
        @Override
        public void update(Subject s) {
            System.out.println("I have been notified by "+s.getName());
        }
    }

    public void demo() {
        ConcreteObserver observer = new ConcreteObserver();
        ConcreteSubject subject1 = new ConcreteSubject("Foo");
        ConcreteSubject subject2 = new ConcreteSubject("Bar");

        subject1.attach(observer);
        subject2.attach(observer);

        subject1.makeChange();
        subject2.makeChange();
    }

    public static void main(String[] args) {
        new ObserverExample().demo();
    }
}
