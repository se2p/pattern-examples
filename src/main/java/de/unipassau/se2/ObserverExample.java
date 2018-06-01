package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {

    interface Observer {
        void update(Subject s);
    }

    abstract class Subject {
        private List<Observer> observers = new ArrayList<>();

        public void attach(Observer o) {
            observers.add(o);
        }

        public void detach(Observer o) {
            observers.remove(o);
        }

        public void notifyChange() {
            for(Observer o : observers) {
                o.update(this);
            }
        }
    }

    class ConcreteSubjectA extends Subject {
        @Override
        public String toString() {
            return "This is concrete subject A";
        }
        public void makeAChange() {
            notifyChange();
        }
    }

    class ConcreteSubjectB extends Subject {
        @Override
        public String toString() {
            return "This is concrete subject B";
        }
        public void makeAChange() {
            notifyChange();
        }
    }

    class ConcreteObserverA implements Observer {
        @Override
        public void update(Subject s) {
            System.out.println("ObserverA has just been notified that there has been an update to "+s);
        }
    }

    class ConcreteObserverB implements Observer {
        @Override
        public void update(Subject s) {
            System.out.println("ObserverB has just been notified that there has been an update to "+s);
        }
    }

    public void demo() {
        ConcreteObserverA oa = new ConcreteObserverA();
        ConcreteObserverB ob = new ConcreteObserverB();

        ConcreteSubjectA sa = new ConcreteSubjectA();
        ConcreteSubjectB sb = new ConcreteSubjectB();

        sa.attach(oa);
        sa.attach(ob);
        sb.attach(oa);
        sb.attach(ob);

        sa.makeAChange();
        sb.makeAChange();
    }

    public static void main(String[] args) {
        new ObserverExample().demo();
    }
}
