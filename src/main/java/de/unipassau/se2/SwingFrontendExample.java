package de.unipassau.se2;

import de.unipassau.se2.maze.MazeGame;
import de.unipassau.se2.maze.SwingUi;

public class SwingFrontendExample {

    public void demo() {
        SwingUi.show(MazeGame.demoGame());
    }

    public static void main(String[] args) {
        new SwingFrontendExample().demo();
    }
}
