package de.unipassau.se2;

import de.unipassau.se2.maze.Direction;

public class StrategyExample {

    interface MovementStrategy {
        Direction chooseDirection();
    }

    class Guard {
        private MovementStrategy strategy;

        Guard(MovementStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(MovementStrategy strategy) {
            this.strategy = strategy;
        }

        public void move() {
            System.out.println("Guard moves " + strategy.chooseDirection());
        }
    }

    class PatrolStrategy implements MovementStrategy {
        @Override
        public Direction chooseDirection() {
            return Direction.EAST;
        }
    }

    class ChasePlayerStrategy implements MovementStrategy {
        @Override
        public Direction chooseDirection() {
            return Direction.NORTH;
        }
    }

    public void demo() {
        Guard guard = new Guard(new PatrolStrategy());
        guard.move();
        guard.setStrategy(new ChasePlayerStrategy());
        guard.move();
    }

    public static void main(String[] args) {
        new StrategyExample().demo();
    }
}
