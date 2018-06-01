package de.unipassau.se2;

public class CommandExample {

    interface Command {
        void execute();
    }

    class Receiver {
        public void printAMessage(String message) {
            System.out.println("Message received: "+message);
        }
    }

    class ConcreteACommand implements Command {
        private Receiver receiver;

        public ConcreteACommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.printAMessage("Executing command A");
        }
    }

    class ConcreteBCommand implements Command {
        private Receiver receiver;

        public ConcreteBCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.printAMessage("Executing command B");
        }
    }

    public void demo() {
        Receiver r = new Receiver();

        ConcreteACommand commandA = new ConcreteACommand(r);
        ConcreteBCommand commandB = new ConcreteBCommand(r);

        commandA.execute();
        commandB.execute();
    }

    public static void main(String[] args) {
        new CommandExample().demo();
    }

}
