package de.unipassau.se2;

import de.unipassau.se2.maze.Direction;
import de.unipassau.se2.maze.MazeGame;
import java.util.ArrayList;
import java.util.List;

public class ObserverExample {

    interface GameObserver {
        void update(String event);
    }

    class ObservableGame {
        private final MazeGame game = MazeGame.demoGame();
        private final List<GameObserver> observers = new ArrayList<>();

        public void attach(GameObserver observer) {
            observers.add(observer);
        }

        public void move(Direction direction) {
            String result = game.move(direction);
            notifyObservers(result);
        }

        private void notifyObservers(String event) {
            for (GameObserver observer : observers) {
                observer.update(event);
            }
        }
    }

    class GameLog implements GameObserver {
        @Override
        public void update(String event) {
            System.out.println("Log: " + event);
        }
    }

    class MiniMap implements GameObserver {
        @Override
        public void update(String event) {
            System.out.println("MiniMap redraws after: " + event);
        }
    }

    public void demo() {
        ObservableGame game = new ObservableGame();
        game.attach(new GameLog());
        game.attach(new MiniMap());

        game.move(Direction.EAST);
    }

    public static void main(String[] args) {
        new ObserverExample().demo();
    }
}
